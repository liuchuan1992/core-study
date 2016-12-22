package JVM_param;

/**
 * @author : lvcf on 2016/11/30 17:08
 * @Description : 测试垃圾回收机制
 * -verbose:gc -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class TestAllocation2 {


    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation4 = new byte[4 * _1MB];//大对象直接进入老年区 PretenureSizeThreshold = 3MB 所以直接进入老年区
        /**
         * Heap
         def new generation   total 9216K, used 1502K [0x03e00000, 0x04800000, 0x04800000)
         eden space 8192K,  18% used [0x03e00000, 0x03f77b18, 0x04600000)
         from space 1024K,   0% used [0x04600000, 0x04600000, 0x04700000)
         to   space 1024K,   0% used [0x04700000, 0x04700000, 0x04800000)
         tenured generation   total 10240K, used 4096K [0x04800000, 0x05200000, 0x05200000)
         the space 10240K,  40% used [0x04800000, 0x04c00010, 0x04c00200, 0x05200000)
         Metaspace       used 99K, capacity 2248K, committed 2368K, reserved 4480K

         */
    }
}
