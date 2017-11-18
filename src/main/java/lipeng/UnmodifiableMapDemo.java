package lipeng;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * UnmodifiableMap 只提供只读操作
 *
 * @author lipeng
 * @date 2017/11/8
 */
public class UnmodifiableMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a","111");
        Map<String, String> map2 = Collections.unmodifiableMap(map);
        map.put("a","222");
        // map数据的修改会反映到map2上
        map.put("B","333");
        System.out.println(map2.size());
        System.out.println(map2.get("a"));
//        map2.put("12", "abc"); //报错

        Map<Integer,Integer> map3=new HashMap<>();
        map3.put(1,1);
        Map<Integer,Integer> map4=new HashMap<>(map3);
        map3.put(1,2);
        // map3数据的修改会反映到map4上
        System.out.println(map4.get(1));
    }
}
