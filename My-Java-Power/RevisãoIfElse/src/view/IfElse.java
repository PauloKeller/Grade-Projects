package view;

public class IfElse {

	public static void main(String[] args) {
		java.util.Scanner reader = new java.util.Scanner(System.in);
		int numero1 = 0;
		int numero2 = 0;
		System.out.println("Digite o valor do primeiro numero:");
		numero1 = reader.nextInt();
		System.out.println("Digite o valor do segundo numero:");
		numero2 = reader.nextInt();
		
		if(numero1 > numero2)
			System.out.println("O primeiro numero e maior que o segundo!");
		if(numero1 < numero2)
			System.out.println("O segundo numero e maior que o primeiro!");
		if(numero1 == numero2)
			System.out.println("Os dois numeros são iguais");
		if(numero1 != numero2)
			System.out.println("Os numeros sao diferentes!");
	}

}
