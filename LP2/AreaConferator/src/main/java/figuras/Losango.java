package figuras;

public class Losango implements Calculable {
	private double diagonalMe;
	private double diagonalMa;
	
	public Losango(final double pDiagonalMe, final double pDiagonalMa) {
		diagonalMa = pDiagonalMa;
		diagonalMe = pDiagonalMe;
	}

	@Override
	public double calcularArea() {
		return (diagonalMa * diagonalMe) / 2;
	}
	
}
