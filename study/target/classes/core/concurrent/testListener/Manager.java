package core.concurrent.testListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 * 经理类 负责让工人开工，做完之后接受他的消息
 */
public class Manager {

    // 经理手下有一群工人
    private List<Worker> workers;

    /**
     * 构造器
     * 初始化经理
     * @param nWorkers
     */
    public Manager(int nWorkers){
        this.workers = new ArrayList<>();
        int i = 0;
        while (i < nWorkers) {
            workers.add(new Worker());
            i++;
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager(3);
        manager.workers.forEach(m ->{
            m.addListener(() -> {
                System.out.println(Thread.currentThread().getName()+" 收工了");
            });
        });
        manager.workers.forEach(m -> {
                m.start();
        });
    }
}
