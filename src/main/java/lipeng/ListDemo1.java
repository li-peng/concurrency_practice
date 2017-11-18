package lipeng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lipeng
 * @date 2017/11/8
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Collections.synchronizedList(list);

    }
}
