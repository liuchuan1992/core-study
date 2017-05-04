package core.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvcf on 2017/4/18 14:05
 * @Description :
 */
public class TestThread {

    public static void main(String[] args) {
     /*   Thread th = new Thread(() ->{
            System.out.println("I'm a thread");
        });
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a thread");
            }
        });*/
        List<Integer> list = createList();
         list.stream().filter(integer -> integer < 2).forEach(i -> {
             System.out.println(i);
         });

    }

    private static List<Integer> createList(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            list.add(i);
        }
        return list;
    }
}
