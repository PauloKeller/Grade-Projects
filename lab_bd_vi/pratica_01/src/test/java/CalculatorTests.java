import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

  @Test
  public void testCustomLogarithm() {
    double base = 2.0;
    double logNumber = 4.0;
    double expected = 2;

    assertEquals(Calculator.customLog(base, logNumber), expected);
  }

  @Test
  public void testComplexLogarithm() {
    Complex base = buildComplexNumber(2.0, 2.0);
    Complex logNumber = buildComplexNumber(4.0, 1);
    Complex expected = buildComplexNumber(2.0, 0.0);

    Complex stub = Calculator.complexLog(base, logNumber);

    assertEquals(stub.real(), expected.real());
    assertEquals(stub.imag(), expected.imag());
  }

  private Complex buildComplexNumber(double real, double imaginary) {
    return new Complex(real, imaginary);
  }
}