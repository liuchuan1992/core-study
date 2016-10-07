package core.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/9/4.
 * jdk8 CountDownLatch 测试
 * 目的
 */
public class TestCountDownLatch {

    private static  CountDownLatch count = new CountDownLatch(3);

    public static void main(String[] args) throws  Exception{
        new Thread(() -> {
            int i = 3;
            while(i > 0 ){
                count.countDown();
                System.out.println(Thread.currentThread().getName()+"  do ");
                i--;
            }
        }).start();
        count.await();
        System.out.println(Thread.currentThread().getName()+" finish waiting");
    }
}
