package control;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

//import com.sun.glass.events.KeyEvent;

public class MontarJanela {
	public static void montaJanela()
	{
		JFrame janela = new JFrame();
		janela.setTitle("Minha Janela");
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setBounds(50,200,500,500);
		janela.getContentPane().setBackground(new Color(000, 000, 255));
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		janela.setMaximizedBounds(new Rectangle(0,0,1620,1080));
		janela.setVisible(true);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 15, 49, 14);
		labelNome.setForeground(new Color(000,000,000));
		janela.add(labelNome);
		
		JLabel labelSexo = new JLabel("Sexo:");;
		labelSexo.setBounds(10, 45, 49, 14);
		labelSexo.setForeground(new Color(000,000,000));
		labelSexo.setToolTipText("Selecione o sexo.");
		janela.add(labelSexo);
		
		JLabel labelIdioma = new JLabel("Idioma:");
		labelIdioma.setBounds(10, 75, 52, 14);
		labelIdioma.setForeground(new Color(000,000,000));
		labelIdioma.setToolTipText("Escolha o Idioma.");
		janela.add(labelIdioma);
		
		JLabel labelEstado= new JLabel("Estado:");
		labelEstado.setBounds(10, 105, 60, 14);
		labelEstado.setForeground(new Color(000,000,000));
		labelEstado.setToolTipText("Escolha o Estado.");
		janela.add(labelEstado);
		
		JLabel labelProf = new JLabel("Profissão:");
		labelProf.setBounds(10, 155, 75, 14);
		labelProf.setForeground(new Color(000,000,000));
		labelProf.setToolTipText("Escolha a profissão.");
		janela.add(labelProf);
		
		JLabel labelTexto = new JLabel("Comentarios:");
		labelTexto.setBounds(10, 255, 100, 14);
		labelTexto.setForeground(new Color(000,000,000));
		labelTexto.setToolTipText("Digite um comentario.");
		janela.add(labelTexto);
		
		JTextField campoNome = new JTextField();
		campoNome.setBounds(55, 10, 150, 22);
		campoNome.setForeground(new Color(000, 000, 000));
		campoNome.setToolTipText("Digite o nome do usuário.");
		janela.add(campoNome);
		janela.setVisible(true);
	
		JRadioButton radioMasculino = new JRadioButton("Masculino");
		radioMasculino.setSelected(true);
		radioMasculino.setForeground(Color.BLACK);
		radioMasculino.setToolTipText("Selecione o sexo.");
		radioMasculino.setBackground(new Color(000, 000, 255));
		radioMasculino.setBounds(60, 45, 100, 15);
		janela.add(radioMasculino);
		
		JRadioButton radioFeminino = new JRadioButton("Feminino");
		radioFeminino.setForeground(Color.BLACK);
		radioFeminino.setToolTipText("Selecione o sexo.");
		radioFeminino.setBackground(new Color(000, 000, 255));
		radioFeminino.setBounds(160, 45, 100, 15);
		janela.add(radioFeminino);
		
		ButtonGroup radioGrupo = new ButtonGroup();
		radioGrupo.add(radioMasculino);
		radioGrupo.add(radioFeminino);
		
		JCheckBox checkPort = new JCheckBox("Português");
		checkPort.setForeground(Color.BLACK);
		checkPort.setBounds(60, 75, 100, 15);
		checkPort.setBackground(new Color(000,000,255));
		checkPort.setToolTipText("Escolha o idioma.");
		janela.add(checkPort);
		
		JCheckBox checkIngles = new JCheckBox("Inglês");
		checkIngles.setForeground(Color.BLACK);
		checkIngles.setBounds(160, 75, 100, 15);
		checkIngles.setBackground(new Color(000,000,255));
		checkIngles.setToolTipText("Escolha o idioma.");
		janela.add(checkIngles);
		janela.setVisible(true);
		
		String[] estados = {"São Paulo", "Rio de Janeiro", "Minas Gerais", "Goiás","Paraná"};
		JComboBox comboEstado = new JComboBox(estados);
		comboEstado.setBounds(65, 105, 110, 20);
		comboEstado.setForeground(Color.BLACK);
		comboEstado.setEditable(true);
		comboEstado.setToolTipText("Selecione o Estado.");
		janela.add(comboEstado);
		janela.setVisible(true);
		
		String[] prof = {"Analista de Sitemas", "Digitador", "Gerente de rede",
						"Gerente de BD", "Programador", "Webdesing"};
		JList lista = new JList(prof);
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setBackground(new Color(255,255,255));
		lista.setForeground(Color.BLACK);
		lista.setSelectedIndex(2);
		
		JScrollPane painelLista = new JScrollPane(lista);
		painelLista.setBackground(new Color(255,255,255));
		painelLista.setBounds(90, 155, 120, 90);
		janela.add(painelLista);
		janela.setVisible(true);
		
		JTextArea areaTexto = new JTextArea();
		areaTexto.setForeground(new Color(000,100,000));
		areaTexto.setText("Meu Texto");
		areaTexto.setEditable(true);
		
		JScrollPane textoAreaScrollPane = new JScrollPane(areaTexto);
		textoAreaScrollPane.setBounds(10, 275, 250, 90);
		janela.add(textoAreaScrollPane);
		janela.setVisible(true);
		
		JButton bSair = new JButton("Sair");
		bSair.setBounds(140, 390, 120, 22);
		//bSair.setMnemonic(KeyEvent.VK_S);
		bSair.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(0);
			}
		});
		janela.add(bSair);
		
		JButton bCadastrar = new JButton("Cadastar");
		bCadastrar.setBounds(290, 390, 120, 22);
		bCadastrar.setToolTipText("Alt+C = cadastrar.");
		//bCadastrar.setMnemonic(KeyEvent.VK_C);
		bCadastrar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				areaTexto.append("\nNome: " + campoNome.getText());
				
				if (radioMasculino.isSelected())
					areaTexto.append("\nSexo: " + radioMasculino.getText());
				else
					areaTexto.append("\nSexo " + radioFeminino.getText());
				
				areaTexto.append("\nIdiomas: ");
				if (checkPort.isSelected() )
					areaTexto.append(" " + checkPort.getText());
				
				if (checkIngles.isSelected())
					areaTexto.append(" " + checkIngles.getText());
				
				areaTexto.append("\nEstado: " + comboEstado.getSelectedItem());
				
				Object[] prof = lista.getSelectedValues();
				areaTexto.append("\nProfissão: ");
				for (int i = 0; i < prof.length; i++)
					areaTexto.append(" " + prof[i]);
				
					
				
					
			}
		});
		
		janela.add(bCadastrar);
	}

}
