package lipeng;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 车辆追踪器类
 * page:51
 * 监视器模式，MutablePoint 非线程安全，对他的操作委托给MonitorVehicleTracker，MonitorVehicleTracker并未发布locations或者point。
 * 并且所有操作都会同步，需要返回车辆位置信息时，通过构造方法或者deepCopy方式以及UnmodifiableMap确保point或者map不会被发布。
 * @author lipeng
 * @date 2017/11/8
 */
@ThreadSafe
public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint location = locations.get(id);
        return location == null ? null : new MutablePoint(location);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint location = locations.get(id);
        if (location == null) {
            System.out.println("没有此id=" + id);
            return;
        }
        location.x = x;
        location.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> re = new HashMap<>();
        for (String id : m.keySet()) {
            re.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(re);
    }


}
































