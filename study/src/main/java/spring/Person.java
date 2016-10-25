package spring;

/**
 * @author : lvcf on 2016/10/25 16:19
 * @Description : pojo
 */
public class Person {

    private String name;
    private int age;

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

    public void sayHello(){
        System.out.println("my name is "+name+",i am"+age+" years old");
    }
}
