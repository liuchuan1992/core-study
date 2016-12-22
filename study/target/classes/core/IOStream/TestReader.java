package core.IOStream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by lvcanfeng on 2016/10/16 21:55
 */
public class TestReader {

    /**
     * 按字符读取
     * @throws IOException
     */
    @Test
    public void testReader() throws IOException {
        StringBuffer sb = new StringBuffer();
        URL url = TestReader.class.getResource("/data.txt");
        FileReader reader = new FileReader(url.getFile());
        char[] c = new char[1024];
        while (-1 != reader.read(c)) {
            sb.append(c);
        }
        System.out.println(sb.toString());
        reader.close();
    }

    /**
     * 按行读取
     * @throws IOException
     */
    @Test
    public void testReadLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(TestReader.class.getResourceAsStream("/data.txt"),"utf-8"));
        StringBuffer sb = new StringBuffer();
        String s ;
        while(null != (s = br.readLine())){
            sb.append(s);
        }
        System.out.println(sb.toString());
    }

}
