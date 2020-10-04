import java.util.List;

public class WhatsApp {
    private List<Contatinho> contatos;
    private List<Mensagem> mensagens;

    public WhatsApp(List<Contatinho> contatos, List<Mensagem> mensagens) {
        this.contatos = contatos;
        this.mensagens = mensagens;
    }

    public void listarContatos() throws EmptyDataException {
        if (contatos.isEmpty()) {
            throw new EmptyDataException("Lista vazia");
        }
        for (Contatinho contato: contatos) {
            System.out.println(contato.toString());
        }
    }

    public void listarMensagens() throws EmptyDataException {
        if (mensagens.isEmpty()) {
            throw new EmptyDataException("Lista vazia");
        }
        for (Mensagem mensagem: mensagens) {
            System.out.println(mensagem.toString());
        }
    }
}
