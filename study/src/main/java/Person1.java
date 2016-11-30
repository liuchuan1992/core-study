import spring.Student;

/**
 * @author : lvcf on 2016/10/25 16:19
 * @Description : pojo
 */
 class Person1 {


    private Student student;
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
        System.out.println("my name is " + name + ",i am" + age + " years old, my school is " + student.getSchool() + ",my trade is " + student.getTrade());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
