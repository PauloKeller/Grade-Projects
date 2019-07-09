package view;

public class And {
	public void and (boolean[] array1, boolean[] array2, boolean[] r){
		for (int n = 0;n < 4;n++){
			r[n] = array1[n] && array2[n];
		System.out.printf("%s and %s = %s \n",array1[n],array2[n],r[n]);
		}
	}
	public static void main(String[] args){
		boolean[] array1 = {true,true,false,false};
		boolean[] array2 = {true,false,true,false};
		boolean[] r = new boolean[4];
		And operadores = new And();
		
		operadores.and(array1,array2,r);
	}

}
