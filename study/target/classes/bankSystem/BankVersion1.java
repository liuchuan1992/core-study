package bankSystem;

/**
 * @author : lvcf on 2017/1/17 10:00
 * @Description :
 */
public class BankVersion1 {

    public static void main(String[] args) {
        System.out.print("请输入用户名：11");
    }

}

class User{
    private String name;
    private String pwd;
    private double moneyCount;

    public User(String name, String pwd, double moneyCount) {
        this.name = name;
        this.pwd = pwd;
        this.moneyCount = moneyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount) {
        this.moneyCount = moneyCount;
    }
}