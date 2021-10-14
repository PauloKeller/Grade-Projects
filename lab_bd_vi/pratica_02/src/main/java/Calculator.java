public class Calculator {
  public static double customLog(double base, double logNumber) {
    double result;

    if (!(base < 0) && !(logNumber < 0)) {
      result = Math.log(logNumber) / Math.log(base);

      return round(result, 2);
    }

    throw new ArithmeticException("Negative values");
  }

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }
}
