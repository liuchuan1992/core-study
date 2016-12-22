package core;

/**
 * Created by lvcanfeng on 2016/10/2 9:29
 * java 初始化所做的事情是：执行<clinit>类构造器方法 ，
 * 编译器自动生成收集类中的所有类变量的赋值动作和静态语句块中的语句合并而成的；
 * 编译器收集的顺序是由语句在源文件中出现的顺序决定
 * 这个例子测试的就是 private static int i = 1;这个语句在step1 和step2 输出的结果是不同的
 */
public class TestStatic {

    private static int i = 1; // step1
    static{
        i = 10;
    }
    //private static int i = 1; // step2


    public static void main(String[] args) {
        System.out.println(i);
    }
}
