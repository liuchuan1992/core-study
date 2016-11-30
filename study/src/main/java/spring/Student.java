package spring;

/**
 * @author : lvcf on 2016/10/25 21:09
 * @Description :学生类
 */
public class Student {
    private String school;
    private String trade;

    public Student(String school, String trade) {
        this.school = school;
        this.trade = trade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }
}
