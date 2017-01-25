package core.java8;

import generic.Wildcard.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvcf on 2016/12/22 16:52
 * @Description :
 */
public class TestConsumer<T> {

    T t;
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.forEach((Object goods) -> System.out.println(goods));
    }

}

