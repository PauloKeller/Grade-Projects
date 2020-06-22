import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ReaderTest {

    @Test
    public void shouldReadValidFile() {
        Reader reader = new Reader();

        assertEquals(reader.read("phones.txt"), new ArrayList<String>(Arrays.asList("842864", "123456", "248628", "123312", "468262", "422332", "145671")));
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotReadInvalidFile() {
        Reader reader = new Reader();

        reader.read("wrong.txt");
    }
}
