package core.TestClone.DeepClone;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * 实现java的深度拷贝
 */
public class CopyUtil {

    public static Map copyMap(Map oldMap) throws Exception {
        Map newMap = oldMap.getClass().newInstance();
        for (Object entry : oldMap.entrySet()) {
            Map.Entry ty = (Map.Entry) entry;
            Object entryKey = copyValue(ty.getKey());
            Object entryValue = ty.getValue();
            entryValue = copyValue(entryValue);
            newMap.put(entryKey, entryValue);
        }
        return newMap;
    }

    public static Object copyValue(Object obj) throws Exception {
        Object clone = obj;
        if (obj instanceof Map) {
            clone = copyMap((Map) obj);
        } else if (obj instanceof List) {
            clone = copyList((List) obj);
        } else if (obj.getClass().isArray()) {
            int len = Array.getLength(obj);
            clone = Array.newInstance(obj.getClass().getComponentType(), len);
            for (int i = 0; i < len; i++) {
                Array.set(clone, i, copyValue(Array.get(obj, i)));
            }
        } else if (obj instanceof BaseCloneable) {
            clone = ((BaseCloneable) obj).clone();
        }
        return clone;
    }

    public static List copyList(List oldList) throws Exception {
        List newList = oldList.getClass().newInstance();
        for (Object obj : oldList) {
            Object value = copyValue(obj);
            newList.add(value);
        }
        return newList;
    }

}
