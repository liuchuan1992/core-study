package JVM_param;

/**
 * @author : lvcf on 2016/11/22 16:41
 * @Description :
 */
public class ReferenceCountingGC {
    public Object instance = null;

    //private static final int _1MB = 1024*1024;
    //private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args){
       /* ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;*/
        String s = "123";
        System.gc();
    }

}
