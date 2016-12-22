package designPattern.vistorPattern;

/**
 * @author : lvcf on 2016/10/21 18:17
 * @Description : 客户端测试类
 */
class Client
{
    public static void main(String args[])
    {
        EmployeeList list = new EmployeeList();
        Employee fte1,fte2,fte3,pte1,pte2;

        fte1 = new FullTimeEmployee("张无忌",3200.00,45);
        fte2 = new FullTimeEmployee("杨过",2000.00,40);
        fte3 = new FullTimeEmployee("段誉",2400.00,38);
        pte1 = new PartTimeEmployee("洪七公",80.00,20);
        pte2 = new PartTimeEmployee("郭靖",60.00,18);

        list.addEmployess(fte1);
        list.addEmployess(fte2);
        list.addEmployess(fte3);
        list.addEmployess(pte1);
        list.addEmployess(pte2);

        Department dep = new HRDepartment();
        list.accept(dep);
    }
}