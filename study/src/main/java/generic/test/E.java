package generic.test;

/**
 * @author : lvcf on 2016/12/20 10:05
 * @Description :
 */
public class E<T extends A & B> {

    T item;
    public void method(T t){
        t.methodA();
        t.methodB();
    }
}
