package designPattern.vistorPattern;

/**
 * @author : lvcf on 2016/10/21 16:56
 * @Description :Element 抽象节点元素
 */
public interface Employee {

    void accept(Department handler);
}
