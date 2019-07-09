package view;

public class Not {
	public void not (boolean[] array1, boolean[] array2, boolean[] r){
		for (int n = 0;n < 2;n++){
			r[n] = array1[n] != array2[n];
		System.out.printf("%s not = %s \n",array1[n],array2[n],r[n]);
		}
	}
	public static void main(String[] args){
		boolean[] array1 = {true,false};
		boolean[] array2 = {false,true};
		boolean[] r = new boolean[2];
		Not operadores = new Not();
		
		operadores.not(array1,array2,r);
	}
}