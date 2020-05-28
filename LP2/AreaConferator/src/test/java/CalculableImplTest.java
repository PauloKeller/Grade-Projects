import java.util.Arrays;

import figuras.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CalculableImplTest {
    private Calculable cut;
    private double expectedResult;

    public CalculableImplTest(final Calculable pCut, final double pExpectedResult) {
        this.cut = pCut;
        this.expectedResult = pExpectedResult;
    }

    @Test
    public void testCalculoFigurasGeometricas() {
        Assert.assertEquals(expectedResult, cut.calcularArea(), 0.1);
    }

    @Parameters(name = "{index}: {0} = expected: {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new Circulo(2.0), 12.5},
                        {new Cubo(2.5), 37.5},
                        {new Hexagono(3.5), 31.8},
                        {new Losango(4.5, 3.5), 7.8},
                        {new Paralelograma(15.0, 7.5), 112.5},
                        {new Quadrado(4.0), 16.0},
                        {new Retangulo(4.0, 2.0), 8.0},
                        {new Trapezio(4.0, 2.0, 3.0), 9.0},
                        {new Triangulo(4.0, 2.0), 4.0},
                        {new Cilindro(4.0, 2.0), 150.7},
                        {new Esfera( 37.0), 17203.36},
                        {new Prisma( 3, 4, 3, 6, 6, 8), 132.000000},
                        {new Piramide( 3, 4), 33.0},
                });
    }
}
