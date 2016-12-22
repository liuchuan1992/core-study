package core.IOStream;

import org.junit.Test;

import java.io.*;

/**
 * @author : lvcf on 2016/12/1 16:15
 * @Description : 测试多种方法读取文件
 */
public class ReaderFile {

    @Test
    public void method1() throws IOException {
        InputStream in = ReaderFile.class.getResourceAsStream("/data.txt");
        StringBuffer sb = new StringBuffer();
        byte[] b = new byte[1024];
        while (in.read(b) != -1){
            sb.append(new String(b));
        }
        System.out.println(sb.toString());
    }

    @Test
    public void method2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ReaderFile.class.getResourceAsStream("/data.txt")));
        StringBuffer sb = new StringBuffer();
        String s ;
        while(null != (s =bufferedReader.readLine())){
         sb.append(s);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void method3() throws IOException {
        StringBuffer sb = new StringBuffer();
        FileReader fileReader = new FileReader(ReaderFile.class.getResource("/data.txt").getFile());
        char[] chars = new char[1024];
        while(-1 != fileReader.read(chars)){
            sb.append(chars);
        }
        System.out.println(sb.toString());
    }
}
