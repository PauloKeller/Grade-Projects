public class Employee {
    int matricula;
    String nome;
    private Double salary;

    public Employee(int matricula, String nome, Double salary) {
        this.matricula = matricula;
        this.nome = nome;
        this.salary = salary;
    }

    public Double getSalary() {
        if (salary <= 1500.00) {
            return salary - (salary * 0.06);
        }
        return salary - (salary * 0.095);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}
