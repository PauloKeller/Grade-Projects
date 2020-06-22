import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneValidatorTest {

    @Test
    public void shouldValidateValidValues() {
        PhoneValidator tester = new PhoneValidator();

        assertTrue(tester.validate("842864"));
        assertTrue(tester.validate("248628"));
        assertTrue(tester.validate("468262"));
    }

    @Test
    public void shouldValidateInvalidValues() {
        PhoneValidator tester = new PhoneValidator();

        assertFalse(tester.validate("123456"));
        assertFalse(tester.validate("123312"));
        assertFalse(tester.validate("422332"));
        assertFalse(tester.validate("145671"));
    }
}