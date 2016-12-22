package core.getResource;

import org.junit.Test;

import java.io.File;

/**
 * Created by lvcanfeng on 2016/10/10 21:28
 * Java中取资源时,经常用到Class.getResource和ClassLoader.getResource,这里来看看他们在取资源文件时候的路径问题
 * 测试class.getResource()和this.class.getClassLoader.getResource()获取资源文件路径
 * 用法：
 *  1.path不以’/'开头时，默认是从此类所在的包下取资源；
 *  2.path  以’/'开头时，则是从ClassPath根下获取；
 */
public class TestGetResource {

    @Test
    public void test1(){//获取上层目录下的1.txt
        String path = this.getClass().getResource("../1.txt").getFile();
        System.out.println(path);
        File file = new File(path);
    }

    //@Test
    public void test2(){//两者的区别在于class.getResource()处理的时候在resolveName()方法中做了处理
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getClassLoader().getResource(""));
    }

}
