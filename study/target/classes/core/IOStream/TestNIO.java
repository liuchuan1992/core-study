package core.IOStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : lvcf on 2016/12/8 16:40
 * @Description :
 */
public class TestNIO {

    @Test
    public void method() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\test.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer b = ByteBuffer.allocate(10);
        int len;
        while(-1 !=(len = fileChannel.read(b))){
            System.out.println(len);
        }
        System.out.println(111);
    }
}
