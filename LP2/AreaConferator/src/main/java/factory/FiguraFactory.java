package factory;

import figuras.*;

public class FiguraFactory implements Factory<Calculable, FiguraType> {
	@Override
	public Calculable create(final FiguraType ft, double... params) {
		Calculable obj = null;
		switch(ft) {
			case QUADRADO: 
				obj =  new Quadrado(params[0]); 
				break;
			case RETANGULO: 
				obj =  new Retangulo(params[0], params[1]); 
				break;
			case CIRCULO:
				obj = new Circulo(params[0]);
				break;
			case TRIANGULO:
				obj = new Triangulo(params[0], params[1]);
				break;
			case PARALELOGRAMA:
				obj = new Paralelograma(params[0], params[1]);
				break;
			case TRAPEZIO:
				obj = new Trapezio(params[0], params[1], params[2]);
				break;
			case HEXAGONO:
				obj = new Hexagono(params[0]);
				break;
			case LOSANGO:
				obj = new Losango(params[0], params[1]);
				break;
			case CUBO:
				obj = new Cubo(params[0]);
				break;
			case CILINDRO:
				obj = new Cilindro(params[0], params[1]);
				break;
			case PIRAMIDE:
				obj = new Piramide(params[0], params[1]);
				break;
			case ESFERA:
				obj = new Esfera(params[0]);
				break;
			case PRISMA:
				obj = new Prisma(params[0], params[1], params[2], params[3], params[4], params[5]);
				break;
		}
		return obj;
	}
}
