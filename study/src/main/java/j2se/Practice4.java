package j2se;

import java.util.*;

/**
 * @author : lvcf on 2017/1/12 13:39
 * @Description :从10个人的名字中随机输出5个
 */
public class Practice4 {

    private  static List<String> nameList = new ArrayList<>();
    public static String pickNames(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<5;i++) {
            int nextInt = new Random().nextInt(nameList.size());
            sb.append(nameList.get(nextInt)+",");
            nameList.remove(nextInt);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10;i++){
            nameList.add("name"+i);
        }
        System.out.println(pickNames());
    }
}
