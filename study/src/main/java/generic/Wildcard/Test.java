package generic.Wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvcf on 2016/12/20 20:18
 * @Description :
 */
public class Test<T extends Fruit> {

   T t;

    public  void method(T t){
        t.method();
    }

    public  static <T extends Fruit> void  method1(List<T> list){
        list.add(null);
        Fruit f = list.get(0);
        System.out.println(f);
//        list.add(new Goods());

    }

    public <T extends Fruit> void method2(T t){

    }

    public static void main(String[] args) {
        Test.method1(new ArrayList<Apple>());
    }
}
