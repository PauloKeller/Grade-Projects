package controller;

import model.DataManager;
import model.Subject;
import view.View;

public class Logar implements Loga {
	
	private View view;
	private Subject model;

	public Logar(View observer, Subject subject) {
		view = observer;
		model = subject;
	}
	
	public void login() {
		
		view.displayLogin();
		
	}

}
