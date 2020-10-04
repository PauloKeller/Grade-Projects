public class MsgFoto extends Mensagem {
    private int tamanho;

    public MsgFoto(Contatinho destinatario, String horaEnvio, String conteudo, int tamanho) {
        super(destinatario, horaEnvio, conteudo);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {

        return super.toString() + "MsgFoto{" +
                "tamanho=" + tamanho +
                '}';
    }
}
