package j2se;

import java.util.Random;

/**
 * @author : lvcf on 2017/1/12 13:52
 * @Description : 存钱取钱问题
 */
public class Practice5 {

    private static int moneyCount;
    public static synchronized void addMoney(){
        int count = new Random().nextInt(1000);
        moneyCount += count;
        System.out.println("存入 "+count+",当前金额："+moneyCount);
    }

    public static synchronized void readuceMoney(){
        int count = new Random().nextInt(1000);
        int moneyRemian = moneyCount - count;
        if(moneyRemian < 0){
            System.out.println("当前余额："+moneyCount+",需要取款："+count+",余额不足，取款失败.");
        }else {
            moneyCount = moneyRemian;
            System.out.println("取出 " + count + ",当前金额：" + moneyCount);
        }
    }

    public static void main(String[] args) {
        addMoney();
       new Thread(new Runnable() {
           @Override
           public void run() {
               readuceMoney();
           }
       }).start();

    }
}
