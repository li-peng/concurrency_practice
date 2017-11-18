package lipeng;

/**
 * @author lipeng
 * @date 2017/11/14
 */
@ThreadSafe
public class SafePoint {
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    private SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private SafePoint(SafePoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
