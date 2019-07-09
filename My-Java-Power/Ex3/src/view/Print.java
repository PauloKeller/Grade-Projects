package view;
import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
	Scanner	reader = new Scanner(System.in);
	int n = 5;
	int v[] = new int[n];
	int i;
	for(i=0 ; i< n; i++){
		System.out.printf("Informe %2do. Valor de %d",(i+1),n);
		v[i] = reader.nextInt();
	}
	int maior = v[0];
	int menor = v[0];
	for(i=0; i<n; i++){
		if(v[i] < menor)
			menor = v[i];
		if(v[i] > maior)
			maior = v[i];
			
	}
	System.out.printf("Maior numero:%d",maior);
	System.out.printf("Menor numero:%d",menor);
	}
}