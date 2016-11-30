package JVM_param;

/**
 * @author : lvcf on 2016/11/22 20:15
 * @Description :GC finalize 机制测试
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVA_HOOK = null;

    public void isAlive(){
        System.out.println("yes,i am still alive ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVA_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVA_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVA_HOOK = null;
        //提醒jvm可以进行内存回收啦
        System.gc();
        //因为finalize方法优先级比较低 所以暂停0.5秒等待他
        Thread.sleep(500);
        if(SAVA_HOOK != null){
            SAVA_HOOK.isAlive();
        }else{
            System.out.println("no ,i am dead ");
        }
        //下面这段代码和上面的完全相同 但是这次自救却失败了
        SAVA_HOOK = null;
        System.gc();
        //因为finalize方法优先级比较低 所以暂停0.5秒等待他
        Thread.sleep(500);
        if(SAVA_HOOK != null){
            SAVA_HOOK.isAlive();
        }else{
            System.out.println("no ,i am dead ");
        }
    }
}
