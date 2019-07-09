package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Busca;
import controller.BuscaAluno;
import controller.Cadastra;
import controller.Logar;
import controller.Loga;
import model.Aluno;
import model.DataManager;
import view.View;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {
	
	static DataManager dataManager;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField senha;
	private String senhaUsuario;
	private String loginUsuario;
	


	/**
	 * Create the frame.
	 */
	public LoginView() {
		setFont(new Font("Dialog", Font.BOLD, 17));
		setTitle("Login");
		dataManager = dataManager.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(49, 98, 81, 26);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(49, 142, 81, 26);
		contentPane.add(lblSenha);
		
		usuario = new JTextField();
		usuario.setBounds(158, 96, 237, 26);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		senha = new JPasswordField();
		senha.setBounds(158, 146, 237, 26);
		contentPane.add(senha);
		
		
		//TODO: Action MainView
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mUsuario = usuario.getText().toString();
				String mSenha = senha.getText().toString();
				
				mSenha = dataManager.hashGenerator(mSenha);
				int result = dataManager.login(mUsuario, mSenha);
				
				switch (result) {
					case 0:
						System.out.println("Logado como usuario:" + dataManager.getUsuario().getEmail());
						MainView mainScreen = new MainView();
						mainScreen.setVisible(true);
						Thread two = new Thread() {
							public void run() {
								try {
								    //thread to sleep for the specified number of milliseconds
								    Thread.sleep(300);
								    close();
								} catch ( java.lang.InterruptedException ie) {
								    System.out.println(ie);
								}
							}
						};
						two.start();
						break;

					case 1:
						JOptionPane.showMessageDialog(null, "Você esqueceu sua senha? Tente novamente!");
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Usuario não encontrado, tente novamente!");
						break;
						
				}
			}	
		});
		btnEntrar.setBounds(280, 185, 110, 25);
		contentPane.add(btnEntrar);
		
		
		//TODO:Action Caastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						Thread two = new Thread() {
							public void run() {
								View view = new View();
								view.displayCadastroAluno();
								try {
								    //thread to sleep for the specified number of milliseconds
								    Thread.sleep(300);
								    close();
								} catch ( java.lang.InterruptedException ie) {
								    System.out.println(ie);
								}
							}
						};
						two.start();
			}
		});
		btnCadastrar.setBounds(158, 185, 110, 25);
		contentPane.add(btnCadastrar);
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
		
	}
}
