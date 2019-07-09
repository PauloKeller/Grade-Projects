package view;

import javax.swing.*;

public class ContaVogal {
	
	public static void main(String[] args){
	
	String frase = JOptionPane.showInputDialog(null, "Digite uma frase:");
	
	char letra;
	int carac = frase.length();
	int a = 0;
	int e = 0;
	int i = 0;
	int o = 0;
	int u = 0;
	
	for(int k = 0; k<carac ; k++)
	{
		letra = frase.charAt(k);
		if (letra == 'a') {
			a++;
		}
		if (letra == 'e') {
			e++;
		}
		if (letra == 'i') {
			i++;
		}
		if (letra == 'o') {
			o++;
		}
		if (letra == 'u') {
			u++;
		}
	}
	
	JOptionPane.showMessageDialog(null,"Vogais: "+frase+"\n# of 'a': "+a+"\n# of 'e': "+e+"\n# of 'i': "+i+"\n# of 'o': "+o+"\n# of 'u': "+u);
	
	}
}
