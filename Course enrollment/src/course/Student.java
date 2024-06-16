package course;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name; // Store the student's name
    private String id; // Store the student's ID
    private Map<Course, Double> enrolledCourses; // Store the courses the student is enrolled in along with their grades

    // Constructor to initialize the student's name and ID
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>(); // Initialize the enrolledCourses map
    }

    // Getter for the student's name
    public String getName() {
        return name;
    }

    // Setter for the student's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the student's ID
    public String getId() {
        return id;
    }

    // Setter for the student's ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for the student's enrolled courses and grades
    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll the student in a course
    public void enrollInCourse(Course course) {
        if (!enrolledCourses.containsKey(course)) { // Check if the student is not already enrolled in the course
            enrolledCourses.put(course, null); // Enroll the student with no grade initially
            course.addStudent(); // Increment the course's enrolled student count
        }
    }

    // Method to assign a grade to the student for a course
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) { // Check if the student is enrolled in the course
            enrolledCourses.put(course, grade); // Assign the grade to the student
        }
    }
}
