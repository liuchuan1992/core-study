package core.IOStream;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvcanfeng on 2016/10/16 15:44
 * 测试jdk原生的InputStream
 */
public class TestInputStream {


    /**
     * 测试InoutStream read();
     * data.txt的内容：abcdefg,higklmn
     * 测试结果：97 正好是a字母对应的ASCII码
     * 总结：jdk源码中说这个方法是读取下一个字节，或者-1 表示已经读完 所以这个方法的用处是读取流中的一个字节
     *
     */
    @Test
    public void testRead() throws IOException {
        InputStream in = TestInputStream.class.getResourceAsStream("/data.txt");
        System.out.println(in.read());
    }

    @Test
    public void testReadString() throws IOException{
        InputStream in = TestInputStream.class.getResourceAsStream("/data.txt");
        StringBuffer str = new StringBuffer();
        byte[] bf = new byte[1024];
        int len = 0 ;
        while(-1 != (len = in.read(bf))){
            str.append(new String(bf));
        }
        System.out.println(str.toString());
        in.close();
    }

}
