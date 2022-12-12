package Test;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Deniz Eskici", 5900, 45, 2012);
        employee.bonusCalculation();
        employee.taxCalculation();
        employee.raiseSalary();
        System.out.println(employee.toString());
    }
}
