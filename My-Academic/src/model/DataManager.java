package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.Buffer;
import java.text.Normalizer;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import json.JSONParser;
import json.ParseException;

import java.security.*;

import view.Observer;

public class DataManager implements Subject {

	private static List observers;
	private static List alunos;
	private List instituicoes;
	private List atividades;
	private static int flag;
	private static DataManager uniqueInstance;
	private Aluno usuario;
	private int id = 0;
	private String arquivo = ".Dados/Alunos.json";



	public DataManager() {
		// Iniciando a DataManager

		File diretorio = new File(".Dados");
		diretorio.mkdir();

		File fileAluno = new File(".Dados/Alunos.json");
		File fileInstituicao = new File(".Dados/Instituição.txt");

		try {
			fileAluno.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		observers = new LinkedList();
		alunos = new LinkedList();
		instituicoes = new LinkedList();
		atividades = new LinkedList();
	}

	public static DataManager getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new DataManager();
		}
		return uniqueInstance;
	}

	public void registerObserver(Observer o) {
		observers.add(o);

	}

	public void removeObserver(Observer o) {
		observers.remove(o);

	}

	public static void notifyObservers(String msg) {

		for (Object i : observers) {
			Observer ob = (Observer) i;
			ob.update(msg);
		}
	}

	public void notifyObserversAdd() {

		for (Object i : observers) {
			Observer ob = (Observer) i;
			ob.update("Cadastrado realizado com Sucesso");
		}

	}

	public void notifyObserversSearch(List result) {

		for (Object i : observers) {
			Observer obs = (Observer) i;
			obs.update(result);
		}
	}

	public void addAluno(int id, String email, String senha, String nome, String cpf, Faculdade faculdade,
			Curso curso) {
		Aluno aluno = new Aluno(id, email, senha, nome, cpf, faculdade, curso);
		alunos.add(aluno);
		notifyObserversAdd();

	}

	public boolean searchAluno(Aluno aluno) {
		List matchAlunos = new LinkedList();
		for (Iterator i = alunos.iterator(); i.hasNext();) {
			Aluno alunos = (Aluno) i.next();
			if (alunos.getEmail().matches(aluno.getEmail())) {
				matchAlunos.add(aluno);
				notifyObserversSearch(matchAlunos);
				return true;
			}
		}
		
		return false;
	}

	public void lerArquivoAlunoAtualizarBanco(String arquivo) {
		Thread one = new Thread() {
			public void run() {

				// LEITURA DE JSON
				JSONObject jsonObjectAluno;
				// Cria o parse de tratamento
				JSONParser parser = new JSONParser();
				// Variaveis que irao armazenar os dados do Aluno do arquivo JSON
				String nome;
				String email;
				String cpf;
				String senha;
				int id;
				
				//Objeto Faculdade
				JSONObject jsonObjectFaculdade;
				// Variaveis que irao armazenar os dados da Faculdade do arquivo JSON
				String faculdadeNome = "";
				String faculdadeSigla;
				String faculdadeEndereco;
				int faculdadeTelefone;
				String site;
				
				//Objeto Faculdade
				JSONObject jsonObjectCurso;
				// Variaveis que irao armazenar os dados da Faculdade do arquivo JSON
				String cursoNome = "";
				int duracao;
				int numeroMaterias;
				double horasExtracurriculares;
			
				try {

					FileReader readerAluno = new FileReader(arquivo);
					BufferedReader bufferAluno = new BufferedReader(readerAluno);

					String linha = bufferAluno.readLine();

					while (linha != null) {

						// Salva no objeto JSONObject o que o parse tratou do
						// arquivo
						jsonObjectAluno = (JSONObject) parser.parse(linha);

						// Salva nas variaveis os dados do Aluno retirados do arquivo
						nome = (String) jsonObjectAluno.get("nome");
						email = (String) jsonObjectAluno.get("email");
						cpf = (String) jsonObjectAluno.get("cpf");
						senha = (String) jsonObjectAluno.get("senha");
						id = (int) (long) jsonObjectAluno.get("id");
						
						//Retira do objeto aluno o objeto faculdade
						jsonObjectFaculdade = (JSONObject) jsonObjectAluno.get("faculdade");
						
						System.out.println(jsonObjectFaculdade);
						
						// Salva nas variaveis os dados da Faculdade retirados do arquivo
						faculdadeNome = (String) jsonObjectFaculdade.get("nome");
						faculdadeSigla = (String) jsonObjectFaculdade.get("sigla");
						faculdadeEndereco = (String) jsonObjectFaculdade.get("endereco");
						site = (String) jsonObjectFaculdade.get("site");
						faculdadeTelefone = (int)(long) jsonObjectFaculdade.get("telefone");
						
						//Retira do objeto aluno o objeto curso
						jsonObjectCurso = (JSONObject) jsonObjectAluno.get("curso");
						
						System.out.println(jsonObjectCurso);
						
						// Salva nas variaveis os dados do Curso retirados do arquivo
						cursoNome = (String) jsonObjectCurso.get("nome");
						duracao = (int)(long) jsonObjectCurso.get("duracao");
						numeroMaterias = (int)(long) jsonObjectCurso.get("numeroMaterias");
						horasExtracurriculares = (double) jsonObjectCurso.get("horasExtracurriculares");
						
						if (id > DataManager.this.id){
							setId(id);
						}
						Faculdade faculdade = new Faculdade(faculdadeNome, faculdadeSigla, faculdadeEndereco, faculdadeTelefone, site);
					
						Curso curso = new Curso(cursoNome, duracao, numeroMaterias, horasExtracurriculares);
						
						Aluno aluno = new Aluno(id, email, senha, nome, cpf, faculdade, curso);
						
						alunos.add(aluno);
						linha = bufferAluno.readLine();
					}
				}
				// Trata as exceptions que podem ser lançadas no decorrer do
				// processo
				catch (JSONException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		one.run();
	}

	public void escreverArquivoAluno(String arquivo, int id, String email, String senha, String nome, String cpf,
			Faculdade faculdade, Curso curso) {

		// ESCRITA DE JSON
		// Cria um Objeto JSON
		JSONObject jsonObjectAluno = new JSONObject();
		try {
			// Cria o buffer de leitura
			FileWriter escreverArquivoAluno = new FileWriter(arquivo, true);
			BufferedWriter bufferArquivoAluno = new BufferedWriter(escreverArquivoAluno);

			FileWriter writeFile = null;

			// Armazena dados do Aluno em um Objeto JSON
			jsonObjectAluno.put("id", id);
			jsonObjectAluno.put("email", email);
			jsonObjectAluno.put("nome", nome);
			jsonObjectAluno.put("senha", senha);
			jsonObjectAluno.put("cpf", cpf);

			// Cria o objeto da faculdade
			JSONObject jsonObjectFaculdade = new JSONObject();

			// Armazena dados do Faculdade em um Objeto JSON
			jsonObjectFaculdade.put("nome", faculdade.getNome());
			jsonObjectFaculdade.put("sigla", faculdade.getSigla());
			jsonObjectFaculdade.put("endereco", faculdade.getEndereco());
			jsonObjectFaculdade.put("telefone", faculdade.getTelefone());
			jsonObjectFaculdade.put("site", faculdade.getSite());
			
			// Adiciona o objeto faculdade ao objeto aluno
			jsonObjectAluno.put("faculdade", jsonObjectFaculdade);
		
			// Cria o objeto do curso
			JSONObject jsonObjectCurso = new JSONObject();

			// Armazena dados do Curso em um Objeto JSON
			jsonObjectCurso.put("nome", curso.getNome());
			jsonObjectCurso.put("duracao", curso.getDuracao());
			jsonObjectCurso.put("numeroMaterias", curso.getNumeroMaterias());
			jsonObjectCurso.put("horasExtracurriculares", curso.getHorasExtracurriculares());
			
			// Adiciona o objeto curso ao objeto aluno
			jsonObjectAluno.put("curso",jsonObjectCurso);
			
			// //cria um JSONArray e preenche com valores string
			// JSONArray jsonArrayCursos = new JSONArray();
			//
			// jsonArrayCursos.add("logistica");
			// jsonArrayCursos.add("ação");
			// jsonArrayCursos.add("ficção");
			//
			// //insere o array no JSONObject com o rótulo "generos"
			// jsonObjectAluno.put("Aulas", jsonArrayCursos);
			
			
			bufferArquivoAluno.write(jsonObjectAluno.toString());
			bufferArquivoAluno.newLine();// TODO: IMPORTANTE NECESSARIO PARA NAO DAR CRASH NA LEITURA
										
			bufferArquivoAluno.close();
			escreverArquivoAluno.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Imprimne na Tela o Objeto JSON para vizualização
		System.out.println(jsonObjectAluno);
	}

	public int generateId() {

		id = getId();
		
		id += 1;
		
		setId(id);
		
		return id;
	}

	public static boolean validarEmail(String email) {
		flag = 1;
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				flag = 0;
				isEmailIdValid = true;
				notifyObservers("Email valido");
				return isEmailIdValid;
			}
		}
		notifyObservers("Email Invalido");
		return isEmailIdValid;
	}

	public static boolean verificaString(String input) {
		flag = 0;
		boolean result = false;
		Pattern pt = Pattern.compile("[^a-zA-Z ]");
		Matcher match = pt.matcher(input);
		while (match.find()) {
			result = true;
			flag = 1;
		}
		notifyObservers("Dado Aceito");
		return result;
	}

	public static String removeCaracteres(String input) {
		String strSemAcentos = Normalizer.normalize(input, Normalizer.Form.NFD);
		strSemAcentos = strSemAcentos.replaceAll("[^\\p{ASCII}]", "");
		return strSemAcentos;
	}

	public static String trocaToNumber(String input) {
		input = input.replaceAll("[^0-9]", "");
		return input;
	}

	public static boolean verificaNumerosCPF(String input) {
		flag = 0;
		boolean result = false;
		Pattern pt = Pattern.compile("[^0-9--.]");
		Matcher match = pt.matcher(input);
		while (match.find()) {
			flag = 1;
			result = true;
		}
		return result;
	}

	public static boolean isCPF(String CPF) {
		flag = 0;
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			notifyObservers("CPF Aceito");
			return (false);
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo
		// (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere
											// numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos
			// informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
				flag = 0;
				notifyObservers("CPF Aceito");
				;
				return (true);
			} else {
				flag = 1;
				notifyObservers("CPF não e valido");
				;
				return (false);
			}
		} catch (InputMismatchException erro) {
			flag = 1;
			return (false);
		}

	}

	public String hashGenerator(String string) {
		String testString = string;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] messageDigest = md.digest(testString.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);

		return hashtext;
	}

	public int login(String login, String senha) {
		List matchAlunos = new LinkedList();
		for (Iterator i = alunos.iterator(); i.hasNext();) {
			Aluno aluno = (Aluno) i.next();
			if (aluno.getEmail().matches(login)) {
				if (aluno.getSenha().matches(senha)) {
					matchAlunos.add(aluno);
					setUsuario(aluno);
					return 0;
				} else {
					return 1;
				}
			}
		}
		return 2;
	}

	public Aluno getUsuario() {
		return usuario;
	}

	public void setUsuario(Aluno aluno) {
		this.usuario = aluno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
}
