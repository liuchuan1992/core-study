package generic.test;

/**
 * @author : lvcf on 2016/12/20 9:54
 * @Description :
 */
public class C implements A,B {

    @Override
    public void methodA() {
        System.out.println("A::methodA");
    }

    @Override
    public void methodB() {
        System.out.println("B::methodB");
    }

}
