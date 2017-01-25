package j2se;

/**
 * @author : lvcf on 2017/1/12 14:05
 * @Description :字符串数组元素求和
 */
public class Practice6 {

    public static int sum(String[] strArry){
        int sum = 0;
        for(String str : strArry) {
            char num[] = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(char c : num){
                if(Character.isDigit(c)){
                    sb.append(c);
                }
            }
            sum += Integer.valueOf(sb.toString());
        }
        return  sum;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"123fs2","fds2sa2a"};
        System.out.println(sum(strings));
    }
}
