package spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : lvcf on 2016/10/25 16:13
 * @Description : spring Ioc容器功能debug
 */
public class SpringIocDebug {

    @Test
    public void testClassPathXmlApplicationContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person p = (Person) context.getBean("person");
        p.sayHello();
    }
}
