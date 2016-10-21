package designPattern.vistorPattern;

/**
 * @author : lvcf on 2016/10/21 17:01
 * @Description :具体节点 ConcreteElement 实现抽象节点元素声明的接口
 */
public class PartTimeEmployee implements Employee {

    private String name;
    private double hourWage;
    private int workTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public PartTimeEmployee(String name, double hourWage, int workTime) {

        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(Department vistor) {

    }
}
