package controller;

import model.Aluno;
import model.Subject;
import model.DataManager;
import view.View;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class CadastraAluno implements Cadastra {
	
	private View view;
	private Subject model;
	
	public CadastraAluno(View observer, Subject subject) {
		view = observer;
		model = subject;	
	}
	
	public void cadastrar() {
		
			view.displayCadastroAluno();
					
	}
	
	
	
}
