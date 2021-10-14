import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
  @Test
  public void testNegativeLogarithm() {
    double base = 2.0;
    double logNumber = -4.0;

    Exception exception = assertThrows(RuntimeException.class, () -> {
      Calculator.customLog(base, logNumber);
    });

    String expectedMessage = "Negative values";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void testCustomLogarithm() {
    double base = 2.0;
    double logNumber = 4.0;
    double expected = 2;

    assertEquals(Calculator.customLog(base, logNumber), expected);
  }

  @Test
  public void testPartitionOne() {
    double base = 10.0;
    double logNumber = 0.2;
    double expected = -0.7;

    assertEquals(Calculator.customLog(base, logNumber), expected);
  }

  @Test
  public void testPartitionTow() {
    double base = 10.0;
    double logNumber = 3.2;
    double expected = 0.51;

    assertEquals(Calculator.customLog(base, logNumber), expected);
  }

  @Test
  public void testPartitionThree() {
    double base = 10.0;
    double logNumber = 17.0;
    double expected = 1.23;

    assertEquals(Calculator.customLog(base, logNumber), expected);
  }
}
