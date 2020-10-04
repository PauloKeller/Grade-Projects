public class Contatinho {
    private String nome;
    private String celular;

    public Contatinho(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Contatinho{" +
                "nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
