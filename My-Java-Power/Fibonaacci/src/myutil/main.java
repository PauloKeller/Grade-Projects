package myutil;
import myutil.fibonacci;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =0;
		Scanner leitor=new Scanner(System.in);
		
		System.out.println("Digite o número : ");
		n=leitor.nextInt();
		System.out.println("Digite o número  :" );
		for (int i = 0; i <= n; i++) {
            System.out.print("(" + i + "):" + fibonacci.fibo(i) + "\t"); 
        }
	}

}
