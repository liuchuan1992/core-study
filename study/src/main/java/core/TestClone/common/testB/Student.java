package core.TestClone.common.testB;

import core.TestClone.common.testA.Person;

/**
 * Created by lvcf on 2016/9/28 9:17
 * Person的子类，用于测试
 * study
 */
public class Student extends Person{

    public void method(){
        System.out.println(age);
        Teacher t = new Teacher();
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.age);
        Person p = new Person();
        //p.age(); ERROR 父类的protected方法和成员域对于不同包下的子类来说，同样是不可见的
        Teacher t = new Teacher();
        // t.age; ERROR  Person的protected成员域age只能在它的子类自己中使用
        // Student是Person的子类,Teacher也是Person的子类。但是，不能在一个子类中访问另一个子类的protected方法(在不同的包结构下)，尽管这两个子类继承自同一个父类。
    }

}
class Teacher extends Person{

}


/**
 *
 */
class A{

    public void method() throws Exception{
        clone();
        B b = new B();
     //   b.clone(); ERROR
        Object o = new Object();
     //   o.clone(); ERROR
    }
}
class  B{

}