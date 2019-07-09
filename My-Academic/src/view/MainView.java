package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Aluno;
import model.DataManager;

import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	static DataManager dataManager;
	private JTextField textNome;
	private JTextField textDuracao;
	private JTextField textData;
	private JTextField textObservacoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setTitle("My Academic");
		dataManager = dataManager.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 600);
		contentPane = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1150, 30);
		contentPane.add(toolBar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(0, 0, 100, 30);
		toolBar.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
				Thread four = new Thread() {
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
				four.start();
			}
		});
		
		JLabel lblFaculdade = new JLabel("Faculdade");
		lblFaculdade.setBounds(419, 104, 510, 17);
		lblFaculdade.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblFaculdade);
		lblFaculdade.setText(dataManager.getUsuario().getFaculdade().getNome());
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(419, 50, 250, 42);
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 35));
		contentPane.add(lblUsuario);
		lblUsuario.setText(dataManager.getUsuario().getNome());
		
		JLabel lblCurso = new JLabel("New label");
		lblCurso.setBounds(419, 133, 468, 15);
		contentPane.add(lblCurso);
		lblCurso.setText(dataManager.getUsuario().getCurso().getNome());
		
		JLabel lblMaterias = new JLabel("Matérias");
		lblMaterias.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMaterias.setBounds(498, 222, 137, 30);
		contentPane.add(lblMaterias);
		
		JTabbedPane materiasPane = new JTabbedPane(JTabbedPane.TOP);
		materiasPane.setBounds(374, 264, 447, 330);
		contentPane.add(materiasPane);
		
		JPanel materia1 = new JPanel();
		materiasPane.addTab("Logica de Programação", null, materia1, null);
		materia1.setLayout(null);
		
		JLabel lblFaltas1 = new JLabel("Faltas: 8");
		lblFaltas1.setBounds(12, 12, 70, 15);
		materia1.add(lblFaltas1);
		
		JLabel lblNotas1 = new JLabel("Notas");
		lblNotas1.setBounds(14, 81, 42, 15);
		materia1.add(lblNotas1);
		
		JLabel lblTrabalho1 = new JLabel("Trabalho: 2.0");
		lblTrabalho1.setBounds(14, 134, 100, 15);
		materia1.add(lblTrabalho1);
		
		JLabel lblP11 = new JLabel("P1: 5.0");
		lblP11.setBounds(14, 170, 70, 15);
		materia1.add(lblP11);
		
		JLabel lblMediaPacial1 = new JLabel("Media Parcial: 6.0");
		lblMediaPacial1.setBounds(229, 12, 130, 15);
		materia1.add(lblMediaPacial1);
		
		JLabel lblMediaFinal1 = new JLabel("Media Final:");
		lblMediaFinal1.setBounds(229, 134, 111, 15);
		materia1.add(lblMediaFinal1);
		
		JLabel lblP21 = new JLabel("P2: ");
		lblP21.setBounds(14, 198, 70, 15);
		materia1.add(lblP21);
		
		JPanel materia2 = new JPanel();
		materiasPane.addTab("Estrutura de Dados", null, materia2, null);
		materia2.setLayout(null);
		
		JLabel lblFaltas2 = new JLabel("Faltas: 6");
		lblFaltas2.setBounds(12, 12, 70, 15);
		materia2.add(lblFaltas2);
		
		JLabel lblNotas2 = new JLabel("Notas");
		lblNotas2.setBounds(14, 81, 42, 15);
		materia2.add(lblNotas2);
		
		JLabel lblTrabalho2 = new JLabel("Trabalho: 3.0");
		lblTrabalho2.setBounds(14, 134, 120, 15);
		materia2.add(lblTrabalho2);
		
		JLabel lblP12 = new JLabel("P1: 7.0");
		lblP12.setBounds(14, 170, 70, 15);
		materia2.add(lblP12);
		
		JLabel lblMediaPacial2 = new JLabel("Media Pacial: 8.3");
		lblMediaPacial2.setBounds(229, 12, 130, 15);
		materia2.add(lblMediaPacial2);
		
		JLabel lblMediaFinal2 = new JLabel("Media FInal: ");
		lblMediaFinal2.setBounds(229, 134, 111, 15);
		materia2.add(lblMediaFinal2);
		
		JLabel lblP22 = new JLabel("P2: ");
		lblP22.setBounds(14, 198, 70, 15);
		materia2.add(lblP22);		
		
		JPanel materia3 = new JPanel();
		materiasPane.addTab("Algoritimos", null, materia3, null);
		materia3.setLayout(null);
		
		JLabel lblFaltas3 = new JLabel("Faltas: 4");
		lblFaltas3.setBounds(12, 12, 70, 15);
		materia3.add(lblFaltas3);
		
		JLabel lblNotas3 = new JLabel("Notas");
		lblNotas3.setBounds(14, 81, 42, 15);
		materia3.add(lblNotas3);
		
		JLabel lblTrabalho3 = new JLabel("Trabalho: 0.0");
		lblTrabalho3.setBounds(14, 134, 120, 15);
		materia3.add(lblTrabalho3);
		
		JLabel lblP13 = new JLabel("P1: 8.0");
		lblP13.setBounds(14, 170, 70, 15);
		materia3.add(lblP13);
		
		JLabel lblMediaPacial3 = new JLabel("Media Pacial: 4.0");
		lblMediaPacial3.setBounds(229, 12, 130, 15);
		materia3.add(lblMediaPacial3);
		
		JLabel lblMediaFinal3 = new JLabel("Media FInal: ");
		lblMediaFinal3.setBounds(229, 134, 111, 15);
		materia3.add(lblMediaFinal3);
		
		JLabel lblP23 = new JLabel("P2: ");
		lblP23.setBounds(14, 198, 70, 15);
		materia3.add(lblP23);
		
		JPanel panelSobre = new JPanel();
		panelSobre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelSobre.setBounds(12, 264, 350, 330);
		contentPane.add(panelSobre);
		panelSobre.setLayout(null);
		
		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setBounds(12, 29, 70, 15);
		panelSobre.add(lblSobre);
		
		JLabel lblSobreOCurso = new JLabel("Estágio");
		lblSobreOCurso.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSobreOCurso.setBounds(113, 222, 204, 27);
		contentPane.add(lblSobreOCurso);
		
		JLabel lblSemestre = new JLabel("4º Semestre");
		lblSemestre.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSemestre.setBounds(27, 30, 168, 42);
		contentPane.add(lblSemestre);
		
		JLabel lblNumeroMaterias = new JLabel("Matérias: 3");
		lblNumeroMaterias.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNumeroMaterias.setBounds(27, 70, 116, 15);
		contentPane.add(lblNumeroMaterias);
		
		JLabel lblHorasExtracurriculares = new JLabel("Horas Extracurriculares:" + dataManager.getUsuario().getCurso().getHorasExtracurriculares());
		lblHorasExtracurriculares.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHorasExtracurriculares.setBounds(27, 100, 238, 15);
		contentPane.add(lblHorasExtracurriculares);
		
		JPanel panelAtividades = new JPanel();
		panelAtividades.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelAtividades.setBounds(833, 264, 314, 330);
		contentPane.add(panelAtividades);
		panelAtividades.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 20, 70, 15);
		panelAtividades.add(lblNome);
		
		JLabel lblDuracao = new JLabel("Duração:");
		lblDuracao.setBounds(10, 60, 70, 15);
		panelAtividades.add(lblDuracao);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 100, 70, 15);
		panelAtividades.add(lblData);
		
		JLabel lblObservaes = new JLabel("Observações:");
		lblObservaes.setBounds(10, 140, 108, 15);
		panelAtividades.add(lblObservaes);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double duracao = Double.parseDouble(textDuracao.getText());
				JOptionPane.showMessageDialog(null, "Sua atividade foi enviada para analise!");
				lblHorasExtracurriculares.setText("Horas Extracurriculares:" + (dataManager.getUsuario().getCurso().getHorasExtracurriculares() - duracao));
			}
		});
		btnEnviar.setBounds(115, 190, 117, 25);
		panelAtividades.add(btnEnviar);
		
		textNome = new JTextField();
		textNome.setBounds(60, 20, 228, 19);
		panelAtividades.add(textNome);
		textNome.setColumns(10);
		
		textDuracao = new JTextField();
		textDuracao.setBounds(80, 60, 208, 19);
		panelAtividades.add(textDuracao);
		textDuracao.setColumns(10);
		
		textData = new JTextField();
		textData.setBounds(60, 100, 228, 19);
		panelAtividades.add(textData);
		textData.setColumns(10);
		
		textObservacoes = new JTextField();
		textObservacoes.setBounds(110, 140, 178, 19);
		panelAtividades.add(textObservacoes);
		textObservacoes.setColumns(10);
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAtividades.setBounds(889, 222, 186, 27);
		contentPane.add(lblAtividades);
		
		String text = dataManager.getUsuario().getNome();
		String[] columns = {"Column 1","Column 2"};		 
		DefaultTableModel model = new DefaultTableModel(columns, 3);
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
		
	}
}

