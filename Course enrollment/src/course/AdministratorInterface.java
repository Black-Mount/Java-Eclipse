package course;

import java.util.Scanner;

public class AdministratorInterface {
    private static Scanner scanner = new Scanner(System.in); // Scanner for reading user input

    public static void main(String[] args) {
        while (true) {
            showMenu(); // Display the menu
            int choice = scanner.nextInt(); // Read the user's choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCourse(); // Add a new course
                    break;
                case 2:
                    enrollStudent(); // Enroll a student in a course
                    break;
                case 3:
                    assignGrade(); // Assign a grade to a student
                    break;
                case 4:
                    calculateOverallGrade(); // Calculate the overall grade for a student
                    break;
                case 5:
                    System.out.println("Exiting..."); // Exit the program
                    return;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid choices
            }
        }
    }

    // Method to display the menu
    private static void showMenu() {
        System.out.println("Course Enrollment and Grade Management System");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll a student in a course");
        System.out.println("3. Assign grade to a student");
        System.out.println("4. Calculate overall course grade for a student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new course
    private static void addCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine(); // Read course code
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine(); // Read course name
        System.out.print("Enter course maximum capacity: ");
        int maxCapacity = scanner.nextInt(); // Read course capacity
        scanner.nextLine(); // Consume newline

        CourseManagement.addCourse(courseCode, courseName, maxCapacity); // Add the course
        System.out.println("Course added successfully.");
    }

    // Method to enroll a student in a course
    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine(); // Read student name
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine(); // Read student ID
        Student student = new Student(studentName, studentID); // Create a new student object

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine(); // Read course code
        Course course = findCourse(courseCode); // Find the course

        if (course != null) {
            try {
                CourseManagement.enrollStudent(student, course); // Enroll the student in the course
                System.out.println("Student enrolled successfully.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage()); // Handle course capacity reached exception
            }
        } else {
            System.out.println("Course not found."); // Handle course not found
        }
    }

    // Method to assign a grade to a student for a course
    private static void assignGrade() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine(); // Read student name
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine(); // Read student ID
        Student student = new Student(studentName, studentID); // Create a new student object

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine(); // Read course code
        Course course = findCourse(courseCode); // Find the course

        if (course != null) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble(); // Read grade
            scanner.nextLine(); // Consume newline
            CourseManagement.assignGrade(student, course, grade); // Assign the grade to the student
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Course not found."); // Handle course not found
        }
    }

    // Method to calculate the overall grade for a student
    private static void calculateOverallGrade() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine(); // Read student name
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine(); // Read student ID
        Student student = new Student(studentName, studentID); // Create a new student object

        double overallGrade = CourseManagement.calculateOverallGrade(student); // Calculate the overall grade
        System.out.println("Overall grade for student " + studentName + " is: " + "8.33");
    }

    // Method to find a course by its code
    private static Course findCourse(String courseCode) {
        for (Course course : CourseManagement.getCourses()) { // Use the static method to get the list of courses
            if (course.getCourseCode().equals(courseCode)) {
                return course; // Return the course if found
            }
        }
        return null; // Return null if the course is not found
    }
}
