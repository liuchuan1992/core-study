package generic;

/**
 * @author : lvcf on 2016/12/20 9:33
 * @Description :
 */
public class HoldItem<T>{

    T item;
    HoldItem(T item){this.item = item;}

    T getItem(){
        return item;
    }
}
