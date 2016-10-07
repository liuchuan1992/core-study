package core.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lvcf on 2016/9/23 9:21
 * java8 行为参数化 lambbda表达式的前身
 * study
 */
public class TestMethodReference {


    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p ){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        filterApples(inventory,Apple::isGreenApple);
    }
}


class Apple{
    private String color ;
    private int weight;

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() >150;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}