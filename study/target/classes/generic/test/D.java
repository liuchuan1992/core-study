package generic.test;

/**
 * @author : lvcf on 2016/12/20 10:01
 * @Description :
 */
public class D {
    static <T extends A> void methodA(T t){
        t.methodA();
    }

    static <T extends B> void methodB(T t){
        t.methodB();
    }

    public static void main(String[] args) {
        C c = new C();
        D.methodA(c);
        D.methodB(c);
    }
}
