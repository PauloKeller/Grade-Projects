import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

  @Test
  public void testCustomLogarithm() {
    Calculator calculator = new Calculator();
    double base = 2.0;
    double logNumber = 4.0;
    double expected = 2;

    assertEquals(calculator.customLog(base, logNumber), expected);
  }

  @Test
  public void testComplexLogarithm() {
    Calculator calculator = new Calculator();
    Complex base = new Complex(2.0, 2.0);
    Complex logNumber = new Complex(4.0, 1);
    Complex expected = new Complex(2.0, 0.0);
    Complex stub = calculator.complexLog(base, logNumber);

    assertEquals(stub.real(), expected.real());
    assertEquals(stub.imag(), expected.imag());
  }
}
