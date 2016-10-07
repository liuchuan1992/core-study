package core.classLoader;

/**
 * Created by lvcanfeng on 2016/10/3 15:13
 * 测试：调用Class.forName()会触发类的初始化
 * 这里TestClass一定会被初始化 具体可以去看虚拟机对于类初始化条件的第四条
 */
public class TestClass {
    /*static{
        System.out.println("TestClass initation..");
    }*/

    public static void main(String[] args) throws Exception{
        Class TestClass = Class.forName("core.classLoader.Dog",false, core.classLoader.TestClass.class.getClassLoader());
    }

}

class Dog{
    static{
        System.out.println("dog initation");
    }
}
