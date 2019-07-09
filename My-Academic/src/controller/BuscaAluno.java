package controller;

import model.DataManager;
import model.Subject;
import view.View;



public class BuscaAluno implements Busca {
	
	private View view;
	private Subject model;
	
	public BuscaAluno(View observer, Subject subject) {
		view = observer;
		model = subject;
	}

	public void buscar() {
		view.displayAluno();
			
	}
		

}
