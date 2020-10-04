public class MsgAudio extends  Mensagem {
    private int duracao;


    public MsgAudio(Contatinho destinatario, String horaEnvio, String conteudo, int duracao) {
        super(destinatario, horaEnvio, conteudo);
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return  super.toString() + "MsgAudio{" +
                "duracao=" + duracao +
                '}';
    }
}
