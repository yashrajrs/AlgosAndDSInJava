package practice.problems.others;

import java.util.ArrayList;

/**
 * Store string input of employee details into employee objects.
 *
 * @author Yashraj R. Sontakke
 */
public class EmployeeDb {

    final ArrayList<Employee> employees = new ArrayList<Employee>();

    /**
     * Adds employees to the employee list.
     *
     * @param input list of employees to be added.
     */
    public void addEmployees(final String input) {
        final String[] employeeArray = input.split(";");

        for (final String singleEmployee : employeeArray) {
            final String[] employeeDetails = singleEmployee.split(",");
            final Employee employee = new Employee(Integer.parseInt(employeeDetails[0]), employeeDetails[1], employeeDetails[2]);
            employees.add(employee);
        }

    }

    /**
     * Prints the employee list.
     */
    public void printEmployees() {
        for (final Employee employee : employees) {
            System.out.println(String.format("%d-%s-%s", employee.getId(), employee.getName(), employee.getCity()));
        }
    }

    public static void main(String[] args) {
        EmployeeDb employeeDb = new EmployeeDb();
        String input = "1,emp1,city;2,emp2,city2;3,emp3,city3;4,emp4,city4";
        employeeDb.addEmployees(input);
        employeeDb.printEmployees();
    }

}
