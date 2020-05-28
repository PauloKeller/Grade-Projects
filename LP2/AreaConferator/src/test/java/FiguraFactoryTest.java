import java.util.Arrays;

import factory.Factory;
import factory.FiguraFactory;
import figuras.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FiguraFactoryTest {
    private Factory<Calculable, FiguraType> cut;
    private Class<Calculable> expectedClass;
    private FiguraType type;
    private double[] parameters;

    public FiguraFactoryTest(final FiguraType pType, final Class<Calculable> pExpectedClass, final double... pParameters) {
        this.cut = new FiguraFactory();
        this.expectedClass = pExpectedClass;
        this.type = pType;
        this.parameters = pParameters;
    }

    @Test
    public void testCalculoFigurasGeometricas() {
        Assert.assertTrue(cut.create(type, parameters).getClass().equals(expectedClass));
    }

    @Parameters(name = "{index}: {0} = expected: {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {FiguraType.CIRCULO, Circulo.class, new double[]{2.0}},
                        {FiguraType.CUBO, Cubo.class, new double[]{2.5}},
                        {FiguraType.HEXAGONO, Hexagono.class, new double[]{3.5}},
                        {FiguraType.LOSANGO, Losango.class, new double[]{4.5, 3.5}},
                        {FiguraType.PARALELOGRAMA, Paralelograma.class, new double[]{15.0, 7.5}},
                        {FiguraType.QUADRADO, Quadrado.class, new double[]{4.0}},
                        {FiguraType.RETANGULO, Retangulo.class, new double[]{4.0, 2.0}},
                        {FiguraType.TRAPEZIO, Trapezio.class, new double[]{4.0, 2.0, 3.0}},
                        {FiguraType.TRIANGULO, Triangulo.class, new double[]{4.0, 2.0}},
                });
    }
}
