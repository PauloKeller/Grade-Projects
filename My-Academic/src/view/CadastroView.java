package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.BuscaAluno;
import controller.Logar;
import model.Aluno;
import model.Curso;
import model.DataManager;
import model.Faculdade;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class CadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordSenha;
	private JPasswordField passworConfirmeSenha;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textFaculdade;
	private JTextField textCurso;
	private JLabel lblCadastroDoAluno;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel lblNewLabel_1;
	private JButton btnFinalizar;
	DataManager dataManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroView() {
		setFont(new Font("Dialog", Font.BOLD, 17));
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(9, 3, -120, 30));
		
		label = new JLabel("");
		contentPane.add(label);
		
		lblCadastroDoAluno = new JLabel("Cadastro do Aluno");
		lblCadastroDoAluno.setFont(new Font("Dialog", Font.BOLD, 22));
		contentPane.add(lblCadastroDoAluno);
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
		
		label_1 = new JLabel("");
		contentPane.add(label_1);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblSenha);
		
		passwordSenha = new JPasswordField();
		contentPane.add(passwordSenha);
		
		label_2 = new JLabel("");
		contentPane.add(label_2);
		
		JLabel lblValidaSenha = new JLabel("Confirme:");
		lblValidaSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblValidaSenha);
		
		passworConfirmeSenha = new JPasswordField();
		passworConfirmeSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(passworConfirmeSenha);
		
		label_3 = new JLabel("");
		contentPane.add(label_3);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		contentPane.add(textNome);
		
		label_4 = new JLabel("");
		contentPane.add(label_4);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		label_5 = new JLabel("");
		contentPane.add(label_5);
		
		JLabel lblFaculdade = new JLabel("Faculdade:");
		lblFaculdade.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblFaculdade);
		
		textFaculdade = new JTextField();
		contentPane.add(textFaculdade);
		textFaculdade.setColumns(10);
		
		label_6 = new JLabel("");
		contentPane.add(label_6);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblCurso);
		
		textCurso = new JTextField();
		contentPane.add(textCurso);
		textCurso.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1);
		
		label_7 = new JLabel("");
		contentPane.add(label_7);
		
		dataManager = dataManager.getInstance();
		
		btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View view = new View();
				
				BuscaAluno busca = new BuscaAluno(view, dataManager);
				
				Logar logar = new Logar(view, dataManager);
				
				view.setBusca(busca); // View -> Controller
				view.setLogin(logar);

				dataManager.registerObserver(view); // Model -> View
				
				System.out.println("***View de Cadastro***");
				int result = 0;
				
				int id = dataManager.generateId();
				String email = txtEmail.getText();
				String senha = passwordSenha.getText().toString();
				String confirmaSenha = passworConfirmeSenha.getText().toString();
				String nome = textNome.getText();
				String cpf = textCpf.getText();
				String txtFaculdade = textFaculdade.getText();
				String txtCurso = textCurso.getText();
				Faculdade faculdade = new Faculdade("Faculdade de Tecnologia de São José dos Campos", "Fatec", "Rua 3, São josé dos Campos", 1239440000, "www.fatec.org.com");
				Curso curso = new Curso("Análise e Desenvolvimento de Sistemas", 3, 40, 360);
				Aluno aluno = new Aluno(id, email, senha, nome, cpf, faculdade, curso);
				
				cpf = dataManager.trocaToNumber(cpf);
				nome = dataManager.removeCaracteres(nome);
				txtFaculdade = txtFaculdade.toUpperCase();
				txtCurso = txtCurso.toUpperCase();
				
				if(dataManager.searchAluno(aluno)){
					result = 1;
				} else if (!dataManager.validarEmail(email)){
					result = 2;
				} else if (!senha.equals(confirmaSenha)){
					result = 3;
				} else if(!(senha.length() >= 4)){
					result = 4;
				} else if (!(nome.length() >= 4)) {
					result = 5;
				}else if (dataManager.verificaString(nome)){
					result = 6;
				}else if (cpf.length()<11){
					result = 7;
				}else if (dataManager.verificaNumerosCPF(cpf)){
					result = 8;
				}else if (!dataManager.isCPF(cpf)) {
					result = 9;
				}else if (!txtFaculdade.equals("FATEC")){
					result = 10;
				}else if (!txtCurso.equals("ADS")) {
					result = 11;
				}
				
				switch (result) {
				case 1:
					JOptionPane.showMessageDialog(null, "O email ja existe, tente outro!");
					break;
					
				case 2:
					JOptionPane.showMessageDialog(null, "O email não e valido!");
					break;

				case 3:
					JOptionPane.showMessageDialog(null, "As senha nao sao iguais!");
					break;
					
				case 4:
					JOptionPane.showMessageDialog(null, "Senha muito curta!");
					break;
					
				case 5:
					JOptionPane.showMessageDialog(null, "Nome precisa ter no minimo 4 letras!");
					break;
					
				case 6:
					JOptionPane.showMessageDialog(null, "Nome pode conter apenas letras!");
					break;
					
				case 7:
					JOptionPane.showMessageDialog(null, "Faltam alguns digitos no CPF!");
					break;
					
				case 8:
					JOptionPane.showMessageDialog(null, "CPF pode conter apenas letras!");
					break;
					
				case 9:
					JOptionPane.showMessageDialog(null, "O CPF nao e valido!");
					break;
					
				case 10:
					JOptionPane.showMessageDialog(null, "Essa faculdade ainda nao existe nao existe na nossa base de dados!");
					break;
					
				case 11:
					JOptionPane.showMessageDialog(null, "Esse curso ainda nao existe na nossa base de dados!");
					break;
					

				default:
					senha = dataManager.hashGenerator(senha);
					dataManager.addAluno(id, email, confirmaSenha, nome, cpf, faculdade, curso);
					dataManager.escreverArquivoAluno(dataManager.getArquivo(), id, email, senha, nome, cpf, faculdade, curso);
					Aluno alunoLogin = new Aluno(id, email, senha, nome, cpf, faculdade, curso);
					dataManager.setUsuario(alunoLogin);
					
					System.out.println("Logado como usuario:" + dataManager.getUsuario().getEmail());
					MainView mainScreen = new MainView();
					mainScreen.setVisible(true);
					Thread tree = new Thread() {
						public void run() {
							try {
							    //thread to sleep for the specified number of milliseconds
							    Thread.sleep(500);
							    close();
							} catch ( java.lang.InterruptedException ie) {
							    System.out.println(ie);
							}
						}
					};
					tree.start();
					break;
				}
			
				
				
			}
		});
		contentPane.add(btnFinalizar);
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
		
	}
}
