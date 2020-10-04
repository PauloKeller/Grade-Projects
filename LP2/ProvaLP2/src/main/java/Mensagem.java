public abstract class Mensagem {
    private Contatinho destinatario;
    private String horaEnvio;
    private String conteudo;

    public Mensagem(Contatinho destinatario, String horaEnvio, String conteudo) {
        this.destinatario = destinatario;
        this.horaEnvio = horaEnvio;
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "destinatario=" + destinatario +
                ", horaEnvio='" + horaEnvio + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
