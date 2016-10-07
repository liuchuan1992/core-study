package core.TestClone.deepClone1;

import java.lang.reflect.Field;

/**
 * Created by lvcanfeng on 2016/9/28 21:57
 * 所有继承此类的引用类型 都能深度拷贝
 */
public class BaseCloneable implements Cloneable{

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            field.setAccessible(true);
            try {
                field.set(obj, DeeplyCloneUtil.deepClone(field.get(this)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
