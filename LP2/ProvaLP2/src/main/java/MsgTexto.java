public class MsgTexto extends Mensagem {
    private int numChar;

    public MsgTexto(Contatinho destinatario, String horaEnvio, String conteudo, int numChar) {
        super(destinatario, horaEnvio, conteudo);
        this.numChar = numChar;
    }

    @Override
    public String toString() {
        return super.toString() + "MsgTexto{" +
                "numChar=" + numChar +
                '}';
    }
}
