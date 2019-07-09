package view;

public class Or {
	public void or (boolean[] array1, boolean[] array2, boolean[] r){
		for (int n = 0;n < 4;n++){
			r[n] = array1[n] || array2[n];
		System.out.printf("%s or %s = %s \n",array1[n],array2[n],r[n]);
		}
	}
	public static void main(String[] args){
		boolean[] array1 = {true,true,false,false};
		boolean[] array2 = {true,false,true,false};
		boolean[] r = new boolean[4];
		Or operadores = new Or();
		
		operadores.or(array1,array2,r);
	}

}

