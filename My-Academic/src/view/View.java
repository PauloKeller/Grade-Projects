package view;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import java.awt.SplashScreen;

import model.Aluno;
import model.DataManager;
import controller.*;


public class View implements Observer {

	private Busca busca;
	private Cadastra cadastra;
	private Loga loga;
	private DataManager dataManager;
	private List list;
	private String arquivoAluno = ".Dados/Alunos.json";
	Scanner leitor = new Scanner(System.in);

	public View() {
		this.list = new LinkedList();
	}

	public void setCadastra(Cadastra cadastra) {
		this.cadastra = cadastra;
	}

	public void setBusca(Busca busca) {
		this.busca = busca;
	}

	public void setLogin(Loga loga) {
		this.loga = loga;
	}

	public void update(List l) {
		list = l;
		busca.buscar();
	}

	public void displayLogin() {
		LoginView frame = new LoginView();
		frame.setVisible(true);
	}

	public void displayAluno() {

		if (!list.isEmpty()) {
			for (Object i : list) {
				Aluno aluno = (Aluno) i;				
				System.out.println("***View do Aluno***");
				System.out.println("Pegar o Aluno: " + aluno.getEmail());
				System.out.println("-------------");
				System.out.println("***View do Aluno***");
				System.out.println("Pegar o Aluno: " + aluno.getSenha());
				System.out.println("-------------");
				System.out.println("***View do Aluno***");
				System.out.println("Pegar o Aluno: " + aluno.getNome());
				System.out.println("-------------");
				System.out.println("***View do Aluno***");
				System.out.println("Pegar o Aluno: " + aluno.getCpf());
				System.out.println("-------------");
				System.out.println("***View do Aluno***");
				System.out.println("Pegar o Aluno: " + aluno.getId());
				System.out.println("-------------");
				break;
			}
		} else {
			update("***N�o foi encontrado nenhum Aluno***");		
		}
	}


	public void displayCadastroAluno() {
		CadastroView cadastroSceen = new CadastroView();
		cadastroSceen.setVisible(true);


//		cursandoAluno = cursandoAluno.toUpperCase();
//		if (result1 == false && result2 == false && result3 == false && result4 == false && result5 == false
//				&& result6 == false) {
//			dataManager.addAluno(idDoAluno, loginDoAluno, emailDoAluno, senhaDoAluno, nomeDoAluno, cpfDoAluno,
//					cursandoAluno);
//			dataManager.escreverArquivoAluno(arquivoAluno, idDoAluno, loginDoAluno, emailDoAluno, senhaDoAluno,
//					nomeDoAluno, cpfDoAluno, cursandoAluno);
//		} else {
//			update("Alguma falha no cadastro, por favor entre com os dados novamente!");
//			displayCadastroAluno();
//		}
	}

	public void update(String msg) {
		System.out.println(msg);
	}

}
