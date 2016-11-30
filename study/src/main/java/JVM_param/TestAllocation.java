package JVM_param;

/**
 * @author : lvcf on 2016/11/30 17:08
 * @Description : 测试垃圾回收机制
 */
public class TestAllocation {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB];
    }
}
