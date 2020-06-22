package figuras;

public class Prisma implements Calculable {
    double b ,h, s1, s2;
    double s3, Ht;

    public Prisma(double b, double h, double s1, double s2, double s3, double ht) {
        this.b = b;
        this.h = h;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        Ht = ht;
    }

    @Override
    public double calcularArea() {
        return  b * h + (s1 + s2 + s3) * Ht;
    }

}