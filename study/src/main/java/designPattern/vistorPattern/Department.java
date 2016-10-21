package designPattern.vistorPattern;

/**
 * @author : lvcf on 2016/10/21 16:48
 * @Description : 访问者模式 --部门类：抽象访问者类 (Vistor)
 */
public abstract class Department {

    //财务部处理类
    public abstract void handle(FADepartment employee);

    public abstract void handle(PartTimeEmployee employee);

}
