package view;

import javax.swing.*;

public class Monograma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int novoNome;
		int numeroSpaco = 0;
		String nome;
		String nomes;
		String primeiro;
		String meio;
		String ultimo;
		String spaco;
		String monograma;

		spaco = " ";

		nome = JOptionPane.showInputDialog(null, "Digite o nome inteiro:(Primeiro, Meio, Ultimo)");
		

		for (int i = 0; i < nome.length(); i++) {
			if (nome.charAt(i) == ' ')
				numeroSpaco++;
		}

		switch (numeroSpaco) {

		case 1:
			String[] valores = nome.split(" ");
			primeiro = valores[0];
			meio = valores[1];
			monograma = primeiro.substring(0, 1) + meio.substring(0, 1);
			
		case 2:
			primeiro = nome.substring(0, nome.indexOf(spaco));
			nome = nome.substring(nome.indexOf(spaco) + 1, nome.length());
			meio = nome.substring(0, nome.indexOf(spaco));
			ultimo = nome.substring(nome.indexOf(spaco) + 1, nome.length());
			monograma = primeiro.substring(0, 1) + meio.substring(0, 1) + ultimo.substring(0, 1);
			
			JOptionPane.showMessageDialog(null, "Monograma:" + monograma + "Espaços:" + numeroSpaco);

		}
	}

}
