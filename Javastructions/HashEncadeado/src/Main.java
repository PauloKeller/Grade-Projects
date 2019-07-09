public class Main {
    public static void main(String[] args) {
        HashSondagem hash = new HashSondagem(10);
        hash.inserir(53);
        hash.inserir(36);
        hash.inserir(57);
        hash.inserir(21);
        hash.inserir(17);
        hash.inserir(46);
        hash.inserir(56);
        hash.inserir(73);
        hash.inserir(17);
        hash.imprimir();
        System.out.println("Buscar:" );
        System.out.println("17: "+ hash.buscar(17) );
        System.out.println("27: " + hash.buscar(27) );
        System.out.println("36: " + hash.buscar(36) );
    }
}
