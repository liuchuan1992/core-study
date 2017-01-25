package j2se;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : lvcf on 2017/1/12 13:29
 * @Description :定义文本 d://info.txt 读取文本内容
 */
public class Practice3 {

    public static String readFile(String fileName) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String str ;
        while ((str = bufferedReader.readLine()) != null){
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(readFile("D://info.txt"));
    }
}
