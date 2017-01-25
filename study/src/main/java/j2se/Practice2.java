package j2se;

import java.io.File;

/**
 * @author : lvcf on 2017/1/12 13:20
 * @Description :显示某一目录下的所有文件名
 */
public class Practice2 {

    public static void showName(File file){
        for(String s : file.list()){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        showName(new File("E://dubbo"));
    }
}
