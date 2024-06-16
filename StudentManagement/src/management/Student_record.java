package management;

import java.util.*;

//Student class to represent individual student objects
class Student {
 private String name;
 private int id;
 private int age;
 private String grade;

 // Constructor to initialize student attributes
 public Student(String name, int id, int age, String grade) {
     this.name = name;
     this.id = id;
     this.age = age;
     this.grade = grade;
 }

 // Getter methods for accessing student attributes
 public String getName() {
     return name;
 }

 public int getId() {
     return id;
 }

 public int getAge() {
     return age;
 }

 public String getGrade() {
     return grade;
 }

 // Setter method to update student grade
 public void setGrade(String grade) {
     this.grade = grade;
 }

 // Setter method to update student age
 public void setAge(int age) {
     this.age = age;
 }
}

//Class containing methods to manage student records
public class Student_record {
 private static List<Student> students = new ArrayList<>(); // List to store student objects
 private static int totalStudents = 0; // Counter to keep track of total students

 // Method to add a new student to the system
 public static void addStudent(String name, int id, int age, String grade) {
     Student newStudent = new Student(name, id, age, grade); // Create a new student object
     students.add(newStudent); // Add the student to the list
     totalStudents++; // Increment the total number of students
     System.out.println("Student added successfully.");
 }

 // Updated method to provide options for updating age, grade, or both
 public static void updateStudent(int id, int newAge, String newGrade) {
     boolean updateAge = false;
     boolean updateGrade = false;

     // Prompt user to choose what to update
     System.out.println("What do you want to update?");
     System.out.println("1. Update Age");
     System.out.println("2. Update Grade");
     System.out.println("3. Update Both");

     Scanner scanner = new Scanner(System.in);
     int choice = scanner.nextInt();
     scanner.nextLine(); // Consume newline

     switch (choice) {
         case 1:
             updateAge = true;
             break;
         case 2:
             updateGrade = true;
             break;
         case 3:
             updateAge = true;
             updateGrade = true;
             break;
         default:
             System.out.println("Invalid choice. No update performed.");
             return;
     }

     boolean studentFound = false;
     for (Student student : students) {
         if (student.getId() == id) {
             studentFound = true;
             if (updateAge) {
                 student.setAge(newAge);
             }
             if (updateGrade) {
                 student.setGrade(newGrade);
             }
             System.out.println("Student information updated successfully.");
             break;
         }
     }

     if (!studentFound) {
         System.out.println("Student ID not found.");
     }
 }

 // Method to view details of a student by their ID
 public static void viewStudent(int id) {
     boolean studentFound = false;
     for (Student student : students) {
         if (student.getId() == id) {
             studentFound = true;
             System.out.println("Student ID: " + student.getId());
             System.out.println("Name: " + student.getName());
             System.out.println("Age: " + student.getAge());
             System.out.println("Grade: " + student.getGrade());
             break;
         }
     }

     if (!studentFound) {
         System.out.println("Student ID not found.");
     }
 }

 // Method to display the menu for administrator interaction
 public static void displayMenu() {
     System.out.println("\nStudent Record Management System");
     System.out.println("1. Add New Student");
     System.out.println("2. Update Student Information");
     System.out.println("3. View Student Details");
     System.out.println("4. Exit");
     System.out.print("Enter your choice: ");
 }

 // Main method to run the Student Record Management System
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     int choice;
     do {
         displayMenu();
         choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1:
                 // Add new student
                 System.out.print("Enter student name: ");
                 String name = scanner.nextLine();
                 System.out.print("Enter student ID: ");
                 int id = scanner.nextInt();
                 System.out.print("Enter student age: ");
                 int age = scanner.nextInt();
                 scanner.nextLine(); // Consume newline
                 System.out.print("Enter student grade: ");
                 String grade = scanner.nextLine();
                 addStudent(name, id, age, grade);
                 break;
             case 2:
                 // Update student information
                 System.out.print("Enter student ID to update: ");
                 int updateId = scanner.nextInt();
                 scanner.nextLine(); // Consume newline

                 System.out.print("Enter new age (or 0 to skip): ");
                 int newAge;
                 try {
                     newAge = scanner.nextInt();
                     scanner.nextLine(); // Consume newline
                 } catch (InputMismatchException e) {
                     System.out.println("Invalid input. Age update skipped.");
                     scanner.nextLine(); // Consume newline
                     newAge = 0;
                 }

                 System.out.print("Enter new grade (or leave empty to skip): ");
                 String newGrade = scanner.nextLine();

                 updateStudent(updateId, newAge, newGrade);
                 break;
             case 3:
                 // View student details
                 System.out.print("Enter student ID to view details: ");
                 int viewId = scanner.nextInt();
                 viewStudent(viewId);
                 break;
             case 4:
                 // Exit the program
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
         }
     } while (choice != 4);

     scanner.close(); // Close the scanner object
 }
}
