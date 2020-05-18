import java.util.ArrayList;
import java.util.List;

public class CubbyHole {
    private int contents;
    private boolean available = false;
    private final List<Integer> values =  new ArrayList();

    CubbyHole() {
        for (int i = 0; i < 10; i++) {
            values.add(i);
        }
    }


    public synchronized int get(int who) {
        return values.get(who);
    }

    public synchronized void put(int who, int value) {
        values.add(value,who);
    }
}
