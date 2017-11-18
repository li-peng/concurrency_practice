package lipeng;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lipeng
 * @date 2017/11/8
 */
@NotThreadSafe
public class NumberRange {
    //不变性条件 lower<upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        if (i > upper.get()) {
            System.out.println("low不能大于upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        if (i < lower.get()) {
            System.out.println("upper不能小于low");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return i >= lower.get() && i <= upper.get();
    }
}
