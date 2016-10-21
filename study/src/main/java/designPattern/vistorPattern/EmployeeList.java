package designPattern.vistorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvcf on 2016/10/21 17:06
 * @Description :Object structure 员工集合
 */
public class EmployeeList {

    //定义员工集合
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployess(Employee e){
        employeeList.add(e);
    }

    public void accept(Department handler){
        employeeList.forEach(employee -> employee.accept(handler));
    }
}
