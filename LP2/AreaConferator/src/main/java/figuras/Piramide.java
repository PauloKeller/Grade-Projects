package figuras;

public class Piramide implements Calculable {
    private double base;
    private double incli;

    public Piramide(final double pBase, final double pIncli) {
        base = pBase;
        incli = pIncli;
    }

    @Override
    public double calcularArea() {
        return 2 * base * incli + (int)Math.pow(base, 2);
    }

}
