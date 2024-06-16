package system;

//Class representing an Employee with name, age, department, and salary attributes
public class Employee {
 private String name;
 private int age;
 private String department;
 private double salary;

 // Constructor to initialize an Employee object
 public Employee(String name, int age, String department, double salary) {
     this.name = name;
     this.age = age;
     this.department = department;
     this.salary = salary;
 }

 // Getter for name
 public String getName() {
     return name;
 }

 // Getter for age
 public int getAge() {
     return age;
 }

 // Getter for department
 public String getDepartment() {
     return department;
 }

 // Getter for salary
 public double getSalary() {
     return salary;
 }
}
