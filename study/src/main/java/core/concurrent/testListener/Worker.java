package core.concurrent.testListener;

/**
 * Created by Administrator on 2016/9/4.
 */
public class Worker extends  Thread{
    private Listener listener;


    //自定义监听器
    public static interface Listener{
        public void finish();
    }
    //添加监听器
    public Worker addListener(Listener listener){
        this.listener = listener;
        return this;
    }
    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+"  工人开始工作啦.");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"  工人结束工作啦.");
            listener.finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
