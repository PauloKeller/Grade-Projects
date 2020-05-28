package figuras;

public class Cilindro  implements Calculable {
    private double raio;
    private double altura;

    public Cilindro(final double pRaio, final double paltura) {
        raio = pRaio;
        altura = paltura;
    }

    @Override
    public double calcularArea() {
        return 2 * Math.PI * raio * (raio + altura);
    }
}
