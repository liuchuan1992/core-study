package core.TestClone.test;

/**
 * 测试clone
 */
public class Teacher implements Cloneable {
    private String name;
    private int age;
    private Professor pro;

    public Teacher(String name, int age, Professor pro) {
        this.name = name;
        this.age = age;
        this.pro = pro;
    }

    public Object clone() {
        Object o = null;
        try {
            //Object中的clone()识别出你要复制的是哪一个对象。
            o = super.clone();
            //TODO 自己实现深拷贝
            pro = (Professor) pro.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    public Professor getPro() {
        return pro;
    }



    public static void main(String[] args) {
        Professor p = new Professor("wangwu", 50);
        Teacher s1 = new Teacher("zhangsan", 18, p);
        Teacher s2 = (Teacher) s1.clone();
        s2.getPro().setName("maer");
        s2.getPro().setAge(40);
        System.out.println(s1.getPro());
        //name=maer,age=40
        System.out.println(s2.getPro());
        //name=maer,age=40
    }
}

class Professor implements Cloneable {
    private String name;
    private int age;

    public Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
