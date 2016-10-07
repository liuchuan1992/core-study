package core.classLoader.constantPool;

/**
 * Created by lvcanfeng on 2016/10/5 11:22
 * 测试：不管A B两个类是否在同包不同包下，对于同一个字符串来说，虚拟机维护的字符串常量池都是同一个
 */
public class Test {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(a.name == b.str);
    }
}
