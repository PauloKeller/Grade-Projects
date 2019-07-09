package view;
import java.util.Scanner;
import modelo.*;
public class Principal{
	
	public static void main(String[] args){
		
		
		Fornecedor f1 = new Fornecedor();
		Empregado e1 = new Empregado();
		Administrador adm1 = new Administrador();
		Operario op1 = new Operario();
		Vendedor vnd1 = new Vendedor();
		Scanner leitor = new Scanner(System.in);
		
		f1.defineFornecedor();
		e1.defineEmpregado();
		adm1.defineAdministrador();
		op1.defineOperario();
		vnd1.defineVendedor();
		
		
		
	}
	
}
