package exercicio2;

public class App {

    public static void main(String[] args) {
        final Invoice mouse = new Invoice(123, "mouse", 5, 10.0);
        System.out.println("itemNumber: " + mouse.getItemNumber() + ", itemDesc: " + mouse.getItemDesc());
        System.out.println(mouse.getInvoiceAmount());
        final Invoice teclado = new Invoice(123, "teclado", -5, -1.0);
        System.out.println("itemNumber: " + teclado.getItemNumber() + ", itemDesc: " + teclado.getItemDesc());
        System.out.println(teclado.getInvoiceAmount());
    }
}
