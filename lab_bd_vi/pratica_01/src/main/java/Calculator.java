
public class Calculator {
  static public double customLog(double base, double logNumber) {
    return Math.log(logNumber) / Math.log(base);
  }

  static public Complex complexLog(Complex base, Complex logNumber) {
    final double real = Math.log(logNumber.real()) / Math.log(base.real());
    final double imaginary = Math.log(logNumber.imag()) / Math.log(base.imag());

    return new Complex(real, imaginary);
  }
}