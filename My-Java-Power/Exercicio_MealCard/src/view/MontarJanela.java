package view;

import java.awt.Color;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mytuil.*;


public class MontarJanela {
	public static void montaJanela() 
	{	
		String nome = null;
		int saldo = 0;
		
		JFrame janela = new JFrame();
		
		MealCard aluno1 = new MealCard(nome, saldo);
		
		janela.setTitle("Minha Janela");
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setBounds(50, 200, 500, 500);
		janela.getContentPane().setBackground(new Color(255, 255, 255));
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		janela.setMaximizedBounds(new Rectangle(0, 0, 1620, 1080));
		janela.setVisible(true);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 15, 49, 14);
		labelNome.setForeground(new Color(000,000,000));
		janela.add(labelNome);
		
		JTextField campoNome = new JTextField();
		campoNome.setBounds(55, 10, 150, 22);
		campoNome.setForeground(new Color(000, 000, 000));
		campoNome.setToolTipText("Digite o nome do usuário.");
		janela.add(campoNome);
		janela.setVisible(true);

		JLabel labelSaldo = new JLabel("Saldo:");
		labelSaldo.setBounds(10, 60, 49, 14);
		labelSaldo.setForeground(new Color(000,000,000));
		janela.add(labelSaldo);
		
		JTextField campoSaldo = new JTextField();
		campoSaldo.setBounds(55, 60, 150, 22);
		campoSaldo.setForeground(new Color(000, 000, 000));
		campoSaldo.setToolTipText("Digite o Saldo do usuário.");
		janela.add(campoSaldo);
		janela.setVisible(true);
		
		JButton bCadastrar = new JButton("Cadastar");
		bCadastrar.setBounds(290, 390, 120, 22);
		
		bCadastrar.addActionListener(new ActionListener(){
		@Override
		public  void actionPerformed(java.awt.event.ActionEvent e) {
			aluno1.aluno = campoNome.getText();
			aluno1.saldo = Integer.parseInt(campoSaldo.getText());
			campoSaldo.setVisible(false);
			
			JLabel labelTexto = new JLabel("Saldo:");
			labelTexto.setBounds(10, 255, 100, 14);
			labelTexto.setForeground(new Color(000,000,000));
			janela.add(labelTexto);
			
			JTextArea areaTexto = new JTextArea();
			areaTexto.setForeground(new Color(000,000,000));
			areaTexto.setEditable(true);
			areaTexto.append("Saldo: " + aluno1.getSaldo() + "\n");
			janela.add(areaTexto);
			
			JScrollPane textoAreaScrollPane = new JScrollPane(areaTexto);
			textoAreaScrollPane.setBounds(10, 275, 250, 90);
			janela.add(textoAreaScrollPane);
			janela.setVisible(true);
	
			}
		});
		
		janela.add(bCadastrar);
		
		
	}
}
		
