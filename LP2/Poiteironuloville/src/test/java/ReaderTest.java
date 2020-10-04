import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReaderTest {

    @Test
    public void shouldReadValidFile() {
        Reader reader = new Reader();
        ArrayList<String> result = reader.read("phones.txt");
        assertTrue(result.size() > 0);
    }
}
