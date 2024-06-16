package system;


import javax.swing.*;
import java.awt.*;

// Ensure the package name matches the package of your project
// package your.package.name;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public MainFrame() {
        setTitle("Student Management System"); // Set the title of the window
        setSize(800, 600); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation

        // Create a tabbed pane to hold different sections
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Student Management", new StudentManagementPanel()); // Add Student Management tab
        tabbedPane.addTab("Course Enrollment", new CourseEnrollmentPanel()); // Add Course Enrollment tab
        tabbedPane.addTab("Grade Management", new GradeManagementPanel()); // Add Grade Management tab

        setJMenuBar(createMenuBar()); // Create and set the menu bar

        add(tabbedPane, BorderLayout.CENTER); // Add the tabbed pane to the center of the frame
    }

    // Create the menu bar with options
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Add menu items and their action listeners
        JMenuItem addStudentItem = new JMenuItem("Add Student");
        addStudentItem.addActionListener(e -> tabbedPane.setSelectedIndex(0)); // Switch to Student Management tab
        menu.add(addStudentItem);

        JMenuItem updateStudentItem = new JMenuItem("Update Student");
        updateStudentItem.addActionListener(e -> tabbedPane.setSelectedIndex(0)); // Switch to Student Management tab
        menu.add(updateStudentItem);

        JMenuItem viewStudentDetailsItem = new JMenuItem("View Student Details");
        viewStudentDetailsItem.addActionListener(e -> tabbedPane.setSelectedIndex(0)); // Switch to Student Management tab
        menu.add(viewStudentDetailsItem);

        JMenuItem enrollCourseItem = new JMenuItem("Enroll in Course");
        enrollCourseItem.addActionListener(e -> tabbedPane.setSelectedIndex(1)); // Switch to Course Enrollment tab
        menu.add(enrollCourseItem);

        JMenuItem assignGradeItem = new JMenuItem("Assign Grades");
        assignGradeItem.addActionListener(e -> tabbedPane.setSelectedIndex(2)); // Switch to Grade Management tab
        menu.add(assignGradeItem);

        menuBar.add(menu); // Add the menu to the menu bar
        return menuBar;
    }
}
