import java.util.ArrayList;

public class Company {
    private final ArrayList<Employee> employees = new ArrayList<Employee>();

    public Company() {
        for (int index = 0; index <= 9; index++) {
            final Employee employee = new Employee(index, "Nome" + index, 250.0*index);
            this.employees.add(employee);
        }
    }

    public void printSalaries() {
        System.out.println(this.employees.toString());
    }
}
