package core.thread;

/**
 * Created by Administrator on 2016/9/3.
 * 线程类方法使用 主要是join() notify()等等
 */
public class TestThreadMethod {

    /**
     * 测试线程类中的join()方法
     * 1.源码中的定义：public final void join() throws InterruptedException {join(0);}
     * 2.源码注解：Waits for this thread to die.等待当前线程执行结束
     * 3.解析  thread.join()，是用来指定当前主线程等待thread线程执行完毕后，再来继续执行Thread.join()后面的代码。
     */
    public static void testThreadJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"  start...");
            try {
                Thread.sleep(10000);
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+"  end...");
        },"Thread-lcf");
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName()+ "  this is the lastest invoke code");
    }

    public static void  main(String[] args) throws  Exception{
        TestThreadMethod.testThreadJoin();
    }
}
