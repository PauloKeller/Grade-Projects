//(Nota: 3,0) Considere a tabela abaixo ao desenvolver um programa que leia a quantidade em litros do
// combustível (considere números inteiros exatos como entrada) e o tipo de bebida(kkkk) (Etanol – E ou Gasolina – G),
// calcule e imprima o valor a ser pago pelo cliente, sabendo-se que o litro de Etanol custa R$ 3,50 e o litro de Gasolina custa R$ 5,25 (1,5) –
// Todos os descontos são aplicados sobre a quantidade total adquirida pelo cliente.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static public void main(String args[]) {
        final List<Contatinho> contatos = new ArrayList<Contatinho>();
        final List<Mensagem> mensagens = new ArrayList<Mensagem>();
        final Contatinho contato1 = new Contatinho("Contato1", "12313123");
        contatos.add(contato1);
        final Contatinho contato2 = new Contatinho("Contato2", "adwadawd");
        contatos.add(contato2);
        final MsgTexto msgTexto = new MsgTexto(contato2, "10:10", "aaaa", 10);
        mensagens.add(msgTexto);
        final MsgAudio msgAudio = new MsgAudio(contato1, "15:12", "vvvv", 2);
        mensagens.add(msgAudio);
        final MsgFoto msgFoto = new MsgFoto(contato1, "20:30", "bbbb", 100);
        mensagens.add(msgFoto);

        WhatsApp whatsApp = new WhatsApp(contatos, mensagens);
        try {
            whatsApp.listarContatos();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            whatsApp.listarMensagens();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
