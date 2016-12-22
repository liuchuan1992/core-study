package core.TestClone.deepClone1;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * Created by lvcf on 2016/9/27 14:37
 * study
 * 实现map list,Array的深度拷贝
 */
public class DeeplyCloneUtil {

    /**
     * 设置为protected是因为不想在不同包下暴露这个方法
     * @param obj
     * @return
     * @throws Exception
     */
    protected static Object deepClone(Object obj) throws Exception{
        if(obj == null)
            return null;  //空值不赋值 10-12 新修改
        Object clone = obj;
        //Object clone = null; 我自己写的时候错误的地方
        if(obj instanceof Map)
            clone = cloneMap((Map)obj);
        else if(obj instanceof List)
            clone =cloneList((List)obj);
        else if(obj.getClass().isArray())
            clone = cloneArray(obj);
        else if(obj instanceof BaseCloneable)
            clone = ((BaseCloneable)obj).clone();
        return clone;
    }

    /**
     * clonelist
     * @param obj
     * @return
     */
    private static Object cloneArray(Object obj) throws Exception{
        int len = Array.getLength(obj);
        Object newArray = Array.newInstance(obj.getClass().getComponentType(),len);
        for(int i = 0;i<len;i++){
            Array.set(newArray,i,deepClone(Array.get(obj,i)));
        }
        return newArray;
    }

    private static List cloneList(List obj) throws  Exception{
        List newList = obj.getClass().newInstance();
        for(Object o : obj){
            newList.add(deepClone(o));
        }
        return newList;
    }

    private static Map cloneMap(Map obj) throws Exception {
        Map newMap = obj.getClass().newInstance();
        for(Object entry : obj.entrySet()){
            //for(Object entry : obj.keySet()){我自己写的时候错误的地方
            Map.Entry ey = (Map.Entry)entry;
            Object key = ey.getKey();
            Object value = ey.getValue();
            newMap.put(key, deepClone(value));
        }
        return newMap;
    }
}
