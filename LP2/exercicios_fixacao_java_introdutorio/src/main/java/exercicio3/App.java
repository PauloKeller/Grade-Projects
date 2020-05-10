package exercicio3;

public class App {

    public static void main(String[] args) {
        final Employee employee1 = new Employee("Employee", "1", 800.00);
        final Employee employee2 = new Employee("Employee", "2", 2000.00);
        final Employee employee3 = new Employee("Employee", "3", 0.0);

        System.out.println("Yearly: " + employee1.getYearlyAmount());
        System.out.println("Yearly: " + employee2.getYearlyAmount());
        System.out.println("Yearly: " + employee3.getYearlyAmount());

        final Double percent = 0.1;

        employee1.increaseSalary(percent);
        employee2.increaseSalary(percent);

        System.out.println("Yearly: " + employee1.getYearlyAmount());
        System.out.println("Yearly: " + employee2.getYearlyAmount());
        System.out.println("Yearly: " + employee3.getYearlyAmount());
    }
}
