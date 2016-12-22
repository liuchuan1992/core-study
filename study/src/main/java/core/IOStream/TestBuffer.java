package core.IOStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : lvcf on 2016/12/6 15:47
 * @Description : 测试java.io.* 包装类的效率问题  bufferedInputStream  InputStream
 */
public class TestBuffer {
    private static final String FILENAME = "E:ubuntu.iso";

    public static void main(String[] args) throws IOException {
        long l1 = readByBufferedInputStream();
        System.out.println("通过BufferedInputStream读取用时:" + l1);
        long l2 = readByInputStream();
        System.out.println("通过InputStream读取用时:" + l2);
    }

    public static long readByInputStream() throws IOException {
        InputStream in = new FileInputStream(FILENAME);
        byte[] b = new byte[8192];
        int l = 0;
        long start = System.currentTimeMillis();
        while (in.read(b, 0, b.length) != -1) {
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long readByBufferedInputStream() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILENAME));
        byte[] b = new byte[8192];
        int l = 0;
        long start = System.currentTimeMillis();
        while (in.read(b, 0, b.length) != -1) {
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
