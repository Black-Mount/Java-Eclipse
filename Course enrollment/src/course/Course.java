package course;

import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    private String courseCode; // Store the course code
    private String name; // Store the course name
    private int maxCapacity; // Store the maximum capacity of the course
    private AtomicInteger enrolledStudents; // Atomic integer to store the count of enrolled students

    // Constructor to initialize the course details
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new AtomicInteger(0); // Initialize enrolled students count to 0
    }

    // Getter for the course code
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for the course name
    public String getName() {
        return name;
    }

    // Getter for the maximum capacity of the course
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Getter for the count of enrolled students
    public int getEnrolledStudents() {
        return enrolledStudents.get();
    }

    // Method to add a student to the course
    public void addStudent() {
        if (enrolledStudents.get() < maxCapacity) { // Check if the course has not reached its capacity
            enrolledStudents.incrementAndGet(); // Increment the enrolled student count
        } else {
            throw new IllegalStateException("Course capacity reached."); // Throw an exception if capacity is reached
        }
    }

    private static AtomicInteger totalEnrolledStudents = new AtomicInteger(0); // Static variable to track total enrolled students across all courses

    // Static method to get the total number of enrolled students
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents.get();
    }

    // Static method to increment the total enrolled students count
    public static void incrementTotalEnrolledStudents() {
        totalEnrolledStudents.incrementAndGet();
    }
}
