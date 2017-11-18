package lipeng;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lipeng
 * @date 2017/11/8
 * Point 是不可变的，线程安全的，ConcurrentHashMap 也是线程安全的。unModifiableMap 作用是，安全的发布全部位置信息（即客户端不可修改）
 */
@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unModifiableMap;

    public DelegatingVehicleTracker(ConcurrentHashMap<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unModifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unModifiableMap;
    }
    //返回会，位置的移动不反应到此map
    public Map<String, Point> getLocations2() {
        return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
    }
    public Point getLocations(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        Point p = locations.get(id);
        if (p != null) {
            locations.put(id, new Point(x, y));
        }
    }

//    public void setLocation(String id, int x, int y) {
//        if (locations.replace(id, new Point(x, y)) == null) {
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Point> map = new ConcurrentHashMap<>();
        map.put("A", new Point(1, 2));
        map.put("B", new Point(3, 4));

        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(map);
        tracker.setLocation("A", 5, 6);
        System.out.println(tracker.getLocations("A"));
        Map<String, Point> re = tracker.getLocations();
        Map<String, Point> re1 = tracker.getLocations2();
        tracker.setLocation("A", 7, 8);
        System.out.println(re.get("A"));
        System.out.println(re1.get("A"));
//        re.put("C", new Point(1, 2)); 报错
    }
}
