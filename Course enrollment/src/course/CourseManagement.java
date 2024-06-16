package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>(); // Static list to store all courses
    private static Map<Student, Map<Course, Double>> studentGrades = new HashMap<>(); // Static map to store student grades for each course

    // Static method to add a new course
    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity); // Create a new course object
        courses.add(course); // Add the course to the list of courses
    }

    // Static method to enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course); // Enroll the student in the course
        Course.incrementTotalEnrolledStudents(); // Increment the total enrolled students count
    }

    // Static method to assign a grade to a student for a course
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade); // Assign the grade to the student
        if (!studentGrades.containsKey(student)) { // Check if the student is not already in the map
            studentGrades.put(student, new HashMap<>()); // Add the student to the map
        }
        studentGrades.get(student).put(course, grade); // Add the grade for the course
    }

    // Static method to calculate the overall grade for a student
    public static double calculateOverallGrade(Student student) {
        Map<Course, Double> grades = studentGrades.get(student); // Get the student's grades
        if (grades == null || grades.isEmpty()) {
            return 0; // Return 0 if there are no grades
        }

        double total = 0; // Variable to store the total grades
        int count = 0; // Variable to store the count of grades
        for (Double grade : grades.values()) {
            if (grade != null) {
                total += grade; // Add the grade to the total
                count++; // Increment the count
            }
        }

        return count > 0 ? total / count : 0; // Calculate the average grade
    }

    // Static method to get the list of courses
    public static List<Course> getCourses() {
        return new ArrayList<>(courses); // Return a copy of the courses list
    }
}
