package core.java8;

import java.util.Arrays;

/**
 * @author : lvcf on 2017/5/4 11:07
 * @Description :
 */
public class StreamTest {

    public static void main(String[] args) {
        String[] a = {"1.0", "2.0", "3.0", "4.0", "5.0"};
        Arrays.stream(a)
                .map((v) -> Double.valueOf(v)) //String转Double
                .filter((v) -> v > 2) //过滤
                .sorted((v1, v2) -> v2.compareTo(v1))//降序排列
              //  .limit(2)
                .forEach(v -> System.out.println(v));//终止操作 循环输出
    }
}
