package core.classLoader.constantPool;

/**
 * Created by lvcanfeng on 2016/10/5 14:18
 * 测试字符串常量池
 */
public class TestIntern {

    public static void main(String[] args) {
        String a = new String("abc");
        String b = a;
        String c = new String("abc");
        System.out.println("before intern:a = b?"+(a == b));
        System.out.println("before intern:b = c?"+ (b == c));
        b = b.intern();
        c = c.intern();
        System.out.println("after intern:a = b?"+(a == b));
        System.out.println("after intern:b = c?"+ (b == c));

        //
        System.out.println("------------------------------------------");
        String s1 = "test";
        final String s2 = "st";
        String s3 = "te"+s2;
        String s4 = s3.intern();
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }
}
