package core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvcf on 2016/9/12 10:29
 * study
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Map<String, Object> oldMap = new HashMap<>();
        oldMap.put("person1", new Person());
        Map newMap = copyMap(oldMap);
//        ((Person)newMap.get("person1")).a = 2;
        System.out.println(((Person)oldMap.get("person1")).name.hashCode());
        System.out.println(((Person)newMap.get("person1")).name.hashCode());
    }

    private static Object copyValue(Object entryValue) throws Exception {
        if(entryValue instanceof Map) {
            entryValue = copyMap((Map) entryValue);
        } else if(entryValue instanceof List) {
            entryValue = copyList((List) entryValue);
        }else if (entryValue instanceof Cloneable) {
            Method cloneMethod = entryValue.getClass().getDeclaredMethod("clone", null);
            cloneMethod.setAccessible(true);
            entryValue = cloneMethod.invoke(entryValue, null);
        } /*else {
            throw new RuntimeException("unsupport clone type");
        }*/
        return entryValue;
    }

    private static List copyList(List oldList) throws Exception {
        List newList = oldList.getClass().newInstance();
        for (Object obj : oldList) {
            Object value = copyValue(obj);
            newList.add(value);
        }
        return newList;
    }

    private static Map copyMap(Map oldMap) throws Exception {
        Map newMap = oldMap.getClass().newInstance();
        for(Object entry : oldMap.entrySet()) {
            Map.Entry ty = (Map.Entry)entry;
            String entryKey = (String) ty.getKey();
            Object entryValue = ty.getValue();
            entryValue = copyValue(entryValue);
            newMap.put(entryKey, entryValue);
        }
        return newMap;
    }

    static class Person implements Cloneable{
        int a = 1;
        String name = "2";

        @Override
        protected Person clone() throws CloneNotSupportedException {
            Person o = (Person) super.clone();

            return o;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "a=" + a +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
