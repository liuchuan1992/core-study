import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvcf on 2016/12/15 19:38
 * @Description :
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add("123");
        list1.add(112);
        String s = list.get(0);
        int i = list1.get(0);
        List list2 = list;
        int[] arr = new int[]{1,2,3};
        A.method(i);
    }

}

class A{

    public static <T> void method(T t){
        System.out.println(t.toString());
    }
}