import java.util.ArrayList;
import java.util.Arrays;

public class Aluno {
    int matricula = -1;
    String nome = "";
    String curso = "";
    Double[] notas = new Double[4];

    public Aluno(int matricula, String nome, String curso, Double[] notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
}
