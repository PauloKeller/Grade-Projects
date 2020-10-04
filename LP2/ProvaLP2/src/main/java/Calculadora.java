//(Nota: 2,0) Escreva um método Java que simule uma calculadora das operações abaixo, retornando o resultado da operação:
//
//        1) * - Multiplicação
//        2) / - Divisão
//        3) ** - Potenciação
//        4) // - Divisão com resultado inteiro
//
//        A função deve receber dois parâmetros, na seguinte sequência:
//
//        1) Lista de valores a serem usados na operação (List<Double> - ex: [45.5, 67.77, 88.3, 98.2]), que deverá possuir N elementos; e
//        2) Lista de operações a serem executadas (List<String> - ex: [ "/", "//", "*"]), que deverá ter N - 1 elementos em relação a lista de valores.
//
//        As operações devem ser executadas sobre a sequência de valores passados como parâmetros. Exemplo: Operação 1: 45.5 / 67.77  = Resultado: R1
//        Operação 2: R1 // 88.3 = Resultado: R2
//        Operação 3: R2 * 98.2 = Resultado: RF
//
//        RF = Resultado final


import java.util.List;

public class Calculadora {
    public Calculadora() {

    }

    public double calcular(List<Double> elementos, List<String>operacoes) {
        int indexOp = 0;
        double n1 = 0;
        double n2 = 0;
        double valor = 0;
        double elementoAnt = 0;

        for (double elemento : elementos) {
            n1 = elemento;
            n2 = n1;
            valor = calculaResultado(n1, n2, operacoes.get(indexOp));
            if (indexOp >= operacoes.size()) {
                return valor;
            }
            indexOp++;
        }

        return valor;
    }

    private double calculaResultado(double n1, double n2, String op) {
        double resultado = 0;
        switch (op) {
            case "*":
                resultado = n1 * n2;
                break;
            case "**":
                resultado = Math.pow(n1, n2);
                break;
            case "/":
                resultado = n1 / n2;
                break;
            case "//":
                resultado = Math.round(n1 / n2);
        }

        return resultado;
    }
}
