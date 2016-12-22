package JVM_param;

/**
 * @author : lvcf on 2016/11/30 17:08
 * @Description : 测试垃圾回收机制  对象优先在Eden区分配内存 当Eden内存不够时 发生一次minorGC
 * -verbose:gc -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
 */
public class TestAllocation {


    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//发生一次minor GC
        /**
         * [GC (Allocation Failure) [DefNew: 7482K->601K(9216K), 0.0071891 secs] 7482K->6745K(19456K), 0.0072352 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
         Heap
         def new generation   total 9216K, used 4779K [0x03e00000, 0x04800000, 0x04800000)
         eden space 8192K,  51% used [0x03e00000, 0x04214938, 0x04600000)
         from space 1024K,  58% used [0x04700000, 0x04796698, 0x04800000)
         to   space 1024K,   0% used [0x04600000, 0x04600000, 0x04700000)
         tenured generation   total 10240K, used 6144K [0x04800000, 0x05200000, 0x05200000)
         the space 10240K,  60% used [0x04800000, 0x04e00030, 0x04e00200, 0x05200000)
         Metaspace       used 99K, capacity 2248K, committed 2368K, reserved 4480K
         */
    }
}
