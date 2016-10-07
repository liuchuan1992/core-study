package core.classLoader;

/**
 * Created by lvcanfeng on 2016/10/5 10:32
 * 测试内部静态类在外部类初始化时会不会初始化
 */
public class TestInnerClass {

    static{
        System.out.println("TestInnerClass init");
    }

    private static class InnerClass{
         static final int i = 10;
         static final int  cache[];
        static {
            cache = new int[2];
            cache[0] = 0;
            cache[1] = 1;
            System.out.println("InnerClass init");
        }
    }

    public static void main(String[] args) {
        Integer.valueOf(128);
        System.out.println(InnerClass.cache);
    }
}
