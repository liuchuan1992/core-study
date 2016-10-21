package designPattern.vistorPattern;

/**
 * @author : lvcf on 2016/10/21 17:16
 * @Description : 财务部门 具体访问者 concrete Vistor
 * user for : 计算员工工资
 */
public class FADepartment extends Department {


    @Override//计算临时员工的工资
    public void handle(FullTimeEmployee employee) {
        String name = employee.getName();
        double weekWage = employee.getWeeklyWage();
        int workTime = employee.getWorkTime();
        if (workTime > 40) {
            weekWage = weekWage + (workTime - 40) * 100;
        } else if (workTime < 40) {
            weekWage = weekWage - (40 - workTime) * 80;
            if (weekWage < 0) {
                weekWage = 0;
            }
        }
        System.out.println("正式员工" + name + "实际工资为：" + weekWage + "元。");
    }


    @Override //计算全职员工的工资
    public void handle(PartTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("临时工" + employee.getName() + "实际工资为：" + workTime * hourWage + "元。");
    }
}
