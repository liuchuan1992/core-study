package core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : lvcf on 2016/12/14 15:00
 * @Description : NioTimeServer 多路复用类
 */
public class MutiplexerTimeServer implements Runnable{
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;

    public MutiplexerTimeServer(int port) {
        try{
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024); //绑定本机的某个端口 最大连接数是1024
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("the timeServer starts in port:" + port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while(!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    }catch (Exception e ){
                        key.cancel();
                        if(key.channel() != null){
                            key.channel().close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //多路复用器关闭后,所有注册在上面的channel和pipe等资源都会被自动关闭 所以不需要重复释放资源
        if(selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                //read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if(readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("the timeServer receive order :" + body) ;
                    String currentTime = "QUERY TIME ORDER".equals(body) ? new Date(System.currentTimeMillis()).toString() : "BAD　ORDER";
                    doWrite(sc,currentTime);
                }else if(readBytes < 0){
                    //对端链路关闭
                    key.cancel();
                    sc.close();
                }else{
                    //读到0个字节,忽略
                }
            }
        }
    }

    private void doWrite(SocketChannel sc, String response) throws IOException {
        if(response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            sc.write(byteBuffer);
        }
    }


}
