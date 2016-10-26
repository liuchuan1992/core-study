package spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author : lvcf on 2016/10/25 16:13
 * @Description : spring Ioc容器功能debug
 */
public class SpringIocDebug {

    @Test
    public void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person p = (Person) context.getBean("person");
        p.sayHello();
    }

    /**
     * 使用DefaultListableBeanFactory 直接构造IOC容器
     */
    @Test
    public void test1(){
        ClassPathResource res = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(res);
        Person p = (Person) factory.getBean("person");
        p.sayHello();
        Assert.assertNotNull(factory.getBean("student"));
    }
}
