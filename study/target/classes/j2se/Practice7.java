package j2se;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvcf on 2017/1/12 14:13
 * @Description :
 */
public class Practice7 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Jerry",22,70,"class04"));
        list.add(new Student("Owen",25,90,"class05"));
        list.add(new Student("Jim",30,00,"class05"));
        list.add(new Student("Jerry",28,66,"class06"));
        list.add(new Student("Jerry",24,100,"class04"));

    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;
    private String className;

    public Student(String name, int age, double score, String className) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.className = className;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score > o.score) {
            return 1 ;
        }else if (this.score < o.score) {
            return -1 ;
        }else {
            if(this.age >= o.age){
                return 1;
            }else{
                return -1;
            }
        }
    }
}