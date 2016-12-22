package core.TestClone.deepClone1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvcanfeng on 2016/9/28 22:43
 * 测试自己的深拷贝方法
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Head head = new Head();

        Doudou d1 = new Doudou();
        d1.name = "doudou1";
        head.doudou.put("d1",d1);

        Doudou d2 = new Doudou();
        d2.name = "doudou2";
        head.doudou.put("d2",d2);

        Eye eye1 = new Eye();
        eye1.name = "left eye";

        Eye eye2 = new Eye();
        eye2.name = "right eye";
        head.eyes = new Eye[]{eye1,eye2};

        Month month = new Month();
        month.teeth.add(new Teeth("智齿",2));
        month.teeth.add(new Teeth("犬齿",3));
        head.month = month;

        Man man = new Man();
        man.head = head;
        Man newMan = (Man) man.clone();

        Doudou d3 = new Doudou();
        d3.name = "doudou3";
        newMan.head.doudou.put("d1",d3);
        System.out.println(11);

    }

    static class Man extends BaseCloneable{
        Head head;

    }
    static class Head extends BaseCloneable{
        Month month;
        Map<String,Doudou> doudou = new HashMap<>();
        Eye[] eyes;

    }
    static class Teeth extends BaseCloneable{
        String name;//如门齿、犬齿、臼齿、智齿等
        int num;//数量

        public Teeth(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
    static class Month extends BaseCloneable{
        List<Teeth> teeth =new ArrayList<>();
    }
    static class Eye extends BaseCloneable{
        String name;
    }
    static class Doudou extends BaseCloneable{
        String name;
    }
}
