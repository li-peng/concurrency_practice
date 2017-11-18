package lipeng;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author lipeng
 * @date 2017/11/8
 */
@Immutable
public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        if ("x" != null) {
            builder.append("x", x);
        }
        if ("y" != null) {
            builder.append("y", y);
        }
        return builder.toString();
    }
}
