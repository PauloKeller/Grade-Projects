package exercicio4;

public class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        real = 0.0;
        imaginary = 0.0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static Complex add(Complex z1, Complex z2) {
        return new Complex(z1.real + z2.real, z1.imaginary + z2.imaginary);
    }

    public static Complex subtract(Complex z1, Complex z2) {
        return new Complex(z1.real - z2.real, z1.imaginary - z2.imaginary);
    }

    public static Complex multiply(Complex z1, Complex z2) {
        double _real = z1.real * z2.real - z1.imaginary * z2.imaginary;
        double _imaginary = z1.real * z2.imaginary + z1.imaginary * z2.real;
        return new Complex(_real, _imaginary);
    }

    public static Complex divide(Complex z1, Complex z2) {
        Complex output = multiply(z1, z2.conjugate());
        double div = Math.pow(z2.mod(), 2);
        return new Complex(output.real / div, output.imaginary / div);
    }

    public Complex conjugate() {
        return new Complex(this.real, -this.imaginary);
    }

    public double mod() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    @Override
    public String toString() {
        String re = this.real + "";
        String im = "";
        if (this.imaginary < 0)
            im = this.imaginary + "i";
        else
            im = "+" + this.imaginary + "i";
        return re + im;
    }

    @Override
    public final boolean equals(Object z) {
        if (!(z instanceof Complex))
            return false;
        Complex a = (Complex) z;
        return (real == a.real) && (imaginary == a.imaginary);
    }
}
