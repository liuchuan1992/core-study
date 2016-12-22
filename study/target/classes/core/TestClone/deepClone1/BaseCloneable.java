package core.TestClone.deepClone1;

import core.TestClone.DeepClone.CopyUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by lvcanfeng on 2016/9/28 21:57
 * 所有继承此类的引用类型 都能深度拷贝
 */
public class BaseCloneable implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        //把该类自己申明的属性克隆就行
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            int psf = Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL;  // public static final修饰的field不进行clone
            int mod = field.getModifiers();
            if ((mod & psf) == psf) {
                continue;
            }
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                field.set(clone, CopyUtil.copyValue(value));
            } catch (Exception e) {
                throw new CloneNotSupportedException();
            }
        }
        return clone;
    }
}
