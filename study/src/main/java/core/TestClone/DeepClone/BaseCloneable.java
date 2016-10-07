package core.TestClone.DeepClone;

import java.lang.reflect.Field;

public class BaseCloneable implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        //把该类自己申明的属性克隆就行
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
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
