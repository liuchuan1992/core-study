package generic;

import java.awt.*;

/**
 * @author : lvcf on 2016/12/20 9:36
 * @Description :
 */
public class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item) {
        super(item);
    }
    Color color(){
        return item.getColor();
    }
}
