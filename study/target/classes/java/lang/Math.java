package java.lang;

/**
 * Created by lvcf on 2016/9/18 9:35
 * study 该类的全限定名为java.lang.Math，直接运行此类会出现java.lang.NoSuchMethodException: java.lang.Math.main([Ljava.lang.String;)
 * 这是因为根据虚拟机默认的双亲委派模型，已经加载了rt包下面的Math方法，而这个方法是没有main方法的，因此抛异常时正常的
 */
public class Math {

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
