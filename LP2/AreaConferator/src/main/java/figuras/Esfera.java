package figuras;

public class Esfera implements Calculable {
    private double raio;

    public Esfera(final double pRaio) {
        raio = pRaio;
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * (raio * raio);
    }
}
