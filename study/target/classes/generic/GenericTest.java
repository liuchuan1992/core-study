package generic;

import generic.Wildcard.Apple;
import generic.Wildcard.Fruit;
import generic.Wildcard.Goods;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : lvcf on 2016/12/22 10:25
 * @Description : 泛型是给编译器看的 我们可以透过反射去往List<Integer>里加入String字符串
 */
public class GenericTest {

    public static void main(String[] args) throws Exception {
        java.util.List<Integer> list = new ArrayList<>();
        list.getClass().getMethod("add",Object.class).invoke(list,"abc");
        System.out.println(list.get(0));
        //printCollection(list);
        Set<Goods> set = new HashSet<>();
        printCollection(set);
        Class<String> clazz = String.class;
        Constructor<String> stringConstructor = clazz.getConstructor(String.class);
    }

    public static void printCollection(Collection<? super Fruit> collection){
        collection.add(new Apple());
        //collection.add("!23");compile error
        for(Object o : collection) System.out.println(o);
    }
    public static Class<?> forName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

}
