package core.thread;

/**
 * Created by Administrator on 2016/9/3.
 * 可以试试注释掉Thread.yield和不注释执行的结果,执行结果并不确定；
 * 没有调用yield()方法时，虽然输出有时改变，但是通常消费者行先打印出来，然后事生产者。
 * 调用yield()方法时，两个线程依次打印，然后将执行机会交给对方，一直这样进行下去
 * yield意味着放手，放弃，投降。一个调用yield()方法的线程告诉虚拟机它乐意让其他线程占用自己的位置。这表明该线程没有在做一些紧急的事情。注意，这仅是一个暗示，并不能保证不会产生任何影响。
 */
public class TestThreadYield {

    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}
