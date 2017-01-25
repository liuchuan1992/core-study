package j2se;

import java.util.*;

/**
 * @author : lvcf on 2017/1/12 14:22
 * @Description :
 */
public class Practice8 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,6,8,2,2,1,2};
        List<Integer> list = new ArrayList<>();
        for(int i : ints){
            list.add(i);
     }
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer i : list){
            method(map,i);
        }
        List<Dto> dtoList = new ArrayList<>();
       for(Map.Entry<Integer,Integer> entry :map.entrySet()){
           dtoList.add(new Dto(entry.getKey(),entry.getValue()));
       }
        Collections.sort(dtoList);
        for(Dto dto : dtoList){
            System.out.println(dto.toString());
        }
    }

    public static void method( Map<Integer,Integer> map,int i ){
        if(map.containsKey(i)){
            map.put(i,map.get(i)+1);
        }else{
            map.put(i,1);
        }
    }
}

class Dto implements Comparable<Dto>{
    private int num;
    private int count;

    public Dto(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Dto o) {
        if(this.num > o.num){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return num+":"+count+"次";
    }
}