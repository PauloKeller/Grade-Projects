import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    static int alunoCount = 0;
    final static Aluno[] turma = new Aluno[30];

    public static void main(String[] args) {


        for (int index = 0; index <= 29; index++) {
            final Aluno aluno = new Aluno(index, "Aluno" + index, "Curso-" + index, new Double[]{
                    new Random().nextDouble(),
                    new Random().nextDouble(),
                    new Random().nextDouble(),
                    new Random().nextDouble()
            });
            turma[index] = aluno;
        }
        System.out.println(Arrays.toString(turma));

        final Aluno alunoEditado = editarAluno("Aluno3", "Novo Nome", "Novo curso", new Double[]{0.3, 7.0, 8.5, 9.0});
        System.out.println("Aluno editado: " + alunoEditado.toString());

        final Aluno procurarAlunoPeloNome = findAlunoByName("Aluno7");
        if (procurarAlunoPeloNome != null) {
            System.out.println("Aluno por nome: " + procurarAlunoPeloNome.toString() );
        }

        final Aluno procurarAlunoPelaMatricula = findAlunoByMatricula(9);
        if (procurarAlunoPelaMatricula != null) {
            System.out.println("Aluno por matricula: " + procurarAlunoPelaMatricula.toString() );
        }

        if(removerAluno("Aluno8")) {
            System.out.println("Aluno excluido!");
        }

        if (!adicionarAluno(15, "Aluno ja Matriculado", "Curso-15", new Double[]{0.0, 0.0, 0.0, 0.0})){
            System.out.println("Aluno já matriculado!");
        }

        if (adicionarAluno(99, "Novo Matriculado", "Curso-10", new Double[]{0.0, 0.0, 0.0, 0.0})){
            System.out.println("Aluno matriculado!");
        }

    }

    static public Aluno findAlunoByName(String nome) {
        for (Aluno aluno : turma) {
            if (aluno.nome.equals(nome)) {
                return aluno;
            }
        }
        return null;
    }

    static public Aluno findAlunoByMatricula(int matricula) {
        for (Aluno aluno : turma) {
            if (aluno != null) {
                if (aluno.matricula == matricula) {
                    return aluno;
                }
            }
        }
        return null;
    }

    static public Aluno editarAluno(String nome, String novoNome, String novoCurso, Double[] novasNotas) {
        final Aluno aluno = findAlunoByName(nome);
        aluno.nome = novoNome;
        aluno.curso = novoCurso;
        aluno.notas = novasNotas;
        return aluno;
    }

    static public boolean removerAluno(String nome) {
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

   static public boolean adicionarAluno(int matricula, String nome, String curso, Double[] notas) {
        Aluno aluno = findAlunoByMatricula(matricula);
        if (aluno != null) return false;
        alunoCount++;
        turma[alunoCount] = new Aluno(matricula, nome, curso, notas);
        return true;
    }
}
