package exercicio4;

public class App {
    public static void main(String[] args) {
        Complex c1 = new Complex(5.5, 4);
        Complex c2 = new Complex(1.2, 3.5);
        Complex add =  Complex.add(c1, c2);
        Complex sub =  Complex.subtract(c1, c2);
        Complex mult =  Complex.multiply(c1, c2);
        Complex div =  Complex.divide(c1, c2);

        System.out.println("add: " + add + ", sub: " + sub + ", mult: " + mult + ", div: " + div);
        System.out.println(c1.toString());

    }
}
