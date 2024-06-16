package system;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Class for managing a list of Employee objects and performing various operations
public class EmployeeManager {
    private List<Employee> employees;

    // Constructor to initialize the employee list
    public EmployeeManager() {
        // Initialize employee list with sample data
        employees = Arrays.asList(
            new Employee("Alice", 32, "HR", 70000),
            new Employee("Bob", 45, "Engineering", 120000),
            new Employee("Charlie", 29, "Sales", 60000),
            new Employee("David", 35, "Engineering", 110000),
            new Employee("Eve", 28, "HR", 75000)
        );
    }

    // Function to concatenate an employee's name and department
    private Function<Employee, String> nameAndDepartmentFunction = 
        emp -> emp.getName() + " - " + emp.getDepartment();

    // Method to get a list of concatenated name and department strings
    public List<String> getNameAndDeptList() {
        return employees.stream()
            .map(nameAndDepartmentFunction)
            .collect(Collectors.toList());
    }

    // Method to calculate the average salary of all employees
    public double getAverageSalary() {
        return employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
    }

    // Method to filter employees above a certain age
    public List<Employee> getEmployeesAboveAge(int ageThreshold) {
        return employees.stream()
            .filter(emp -> emp.getAge() > ageThreshold)
            .collect(Collectors.toList());
    }

    // Method to sort employees by name
    public List<Employee> sortEmployeesByName() {
        return employees.stream()
            .sorted(Comparator.comparing(Employee::getName))
            .collect(Collectors.toList());
    }

    // Method to sort employees by salary
    public List<Employee> sortEmployeesBySalary() {
        return employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary))
            .collect(Collectors.toList());
    }

    // Method to search employees by name
    public List<Employee> searchEmployeesByName(String name) {
        return employees.stream()
            .filter(emp -> emp.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }
}
