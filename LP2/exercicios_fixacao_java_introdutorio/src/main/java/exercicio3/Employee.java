package exercicio3;

public class Employee {
    private String firstName;
    private String lastName;
    private Double salary = 0.0;

    public Employee(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (salary > 0) this.salary = salary;
    }

    public void increaseSalary(Double percent) {
        this.salary = this.salary + (this.salary * percent);
    }

    Double getYearlyAmount() {
        return this.salary * 12;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
