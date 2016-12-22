package designPattern.vistorPattern;

/**
 * @author : lvcf on 2016/10/21 18:14
 * @Description : 人力资源部门 具体访问者 concrete Vistor
 * user for : 计算员工工时
 */
public class HRDepartment extends Department {

    @Override
    public void handle(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("正式员工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
        if (workTime > 40) {
            System.out.println("正式员工" + employee.getName() + "加班时间为：" + (workTime - 40) + "小时。");
        } else if (workTime < 40) {
            System.out.println("正式员工" + employee.getName() + "请假时间为：" + (40 - workTime) + "小时。");
        }
    }

    @Override
    public void handle(PartTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("临时工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
    }
}
