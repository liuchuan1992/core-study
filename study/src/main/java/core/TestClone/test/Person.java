package core.TestClone.test;

/**
 * Created by lvcf on 2016/9/28 10:21
 * 测试java clone是浅拷贝
 * study
 */
public class Person implements Cloneable{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone(); //告诉Object.clone()你要clone哪个对象
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 18);
        //TODO name是String引用类型 通过查看clone()前后 hashcode的值可以判断 name是不是深拷贝
        //上面的说法是错误的 String的hashcode方法是被重写的
        System.out.println(p1.getName().hashCode());
        Person p2 = (Person) p1.clone();
        System.out.println(p2.getName().hashCode()); //这里两次打印是一样的，说明Object.clone是浅拷贝
        p2.setName("lis");
        p2.setAge(20);
        System.out.println("name="
                + p1.getName() + ",age=" + p1.getAge());   //name=zhangsan,age=18
        //修改p2后，没有对p1产生影响。
        System.out.println("name="
                + p2.getName() + ",age=" + p2.getAge());  //name=lis,age=20
    }
}