package core.IOStream;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : lvcf on 2016/12/1 16:33
 * @Description : 往文件里写内容
 */
public class WriteFile {

    public static final String CONTEXT = "你好,hello,world111";

    @Test
    public void method1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("e://test.txt");
        fileOutputStream.write(CONTEXT.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @Test
    public void method2() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("e://test.txt"));
        bw.write(CONTEXT);
        bw.flush();
    }
}
