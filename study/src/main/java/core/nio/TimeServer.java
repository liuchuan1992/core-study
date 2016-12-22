package core.nio;

/**
 * @author : lvcf on 2016/12/14 14:58
 * @Description : nio timeServer netty权威指南第30页
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //采用默认8080
            }
        }
        MutiplexerTimeServer timeServer = new MutiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MutiplexerTimeServer-001").start();
    }
}