package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import model.*;
import view.*;
import controller.*;

public class Test {
	
	static DataManager dataManager;

	public static void main(String[] args) throws IOException {
		String arquivo = ".Dados/Alunos.json";
		dataManager = dataManager.getInstance();
		
		View view = new View();
		
		BuscaAluno busca = new BuscaAluno(view, dataManager);
		
		
		Logar logar = new Logar(view, dataManager);
		
		view.setBusca(busca); // View -> Controller
		view.setLogin(logar);

		dataManager.registerObserver(view); // Model -> View

		dataManager.lerArquivoAlunoAtualizarBanco(arquivo);
		
		LoginView loginView = new LoginView();
		
		loginView.setVisible(true);
		 
	}
}
