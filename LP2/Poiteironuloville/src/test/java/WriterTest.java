import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WriterTest {

    @Test
    public void shouldReadValidFile() {
        Writer writer  = new Writer();

        assertTrue(writer.write("valid.txt", new String[]{"842864", "123456", "248628", "123312", "468262", "422332", "145671"}));
    }
}