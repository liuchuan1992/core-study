package generic;

/**
 * @author : lvcf on 2016/12/19 16:40
 * @Description :
 */
public class TList implements List {

    private String element;
    @Override
    public void put(String e) {
        element = e;
    }

    @Override
    public String get() {
        System.out.println(element.toString());
        return element;
    }

    public void method(){
        System.out.println(element.toString());
    }
}
