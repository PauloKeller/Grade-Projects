import java.util.Scanner;

public class App {
    int alunoCount = 0;
    final Aluno[] turma = new Aluno[30];
    Scanner myObj = new Scanner(System.in);
    String userName = myObj.nextLine();

    public static void main(String[] args) {


    }

    public Options handleInput(String input) {
        switch (input) {
            case "1":
                return Options.ADD;
            case "2":
                return Options.EDIT;
            case "3":
                return Options.FIND_BY_MATRICULA;
            case "4":
                return Options.FIND_BY_NOME;
            case "5":
                return Options.REMOVE;
            default:
                return Options.UKNOWN;
        }
    }

    public Aluno findAlunoByName(String nome) {
        for (Aluno aluno : turma) {
            if (aluno.nome.equals(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno findAlunoByMatricula(int matricula) {
        for (Aluno aluno : turma) {
            if (aluno.matricula == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno editarAluno(String nome) {
        final Aluno aluno = findAlunoByName(nome);
        return aluno;
    }

    public boolean removerAluno(String nome) {
        int index = 0;
        boolean hasAluno = false;
        for (Aluno aluno : turma) {
            if (aluno.nome.equals(nome)) {
                turma[index] = null;
                hasAluno = true;
            }
            index++;
        }

        return hasAluno;
    }

    public void listarAlunos() {
        for (Aluno aluno : turma) {
            System.out.println(aluno.toString());
        }
    }

    public boolean adicionarAluno(int matricula, String nome, String curso, Double[] notas) {
        Aluno aluno = findAlunoByMatricula(matricula);
        if (aluno != null) return false;
        alunoCount++;
        turma[alunoCount] = new Aluno(matricula, nome, curso, notas);
        return true;
    }
}
