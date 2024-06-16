package system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CourseEnrollmentPanel extends JPanel {
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private DefaultListModel<String> enrollmentListModel;

    public CourseEnrollmentPanel() {
        setLayout(new BorderLayout());

        // Panel for selecting student and course
        JPanel selectionPanel = new JPanel(new GridLayout(3, 2));
        selectionPanel.add(new JLabel("Select Student:"));
        studentComboBox = new JComboBox<>(new String[]{"Alice", "Bob"});
        selectionPanel.add(studentComboBox);

        selectionPanel.add(new JLabel("Select Course:"));
        courseComboBox = new JComboBox<>(new String[]{"Math", "Science", "History"});
        selectionPanel.add(courseComboBox);

        // Enroll button to enroll a student in a course
        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new EnrollAction());
        selectionPanel.add(enrollButton);

        add(selectionPanel, BorderLayout.NORTH); // Add the selection panel to the top of the layout

        // List to display enrollments
        enrollmentListModel = new DefaultListModel<>();
        JList<String> enrollmentList = new JList<>(enrollmentListModel);
        add(new JScrollPane(enrollmentList), BorderLayout.CENTER); // Add the list inside a scroll pane to the center
    }

    // Action listener for the enroll button
    private class EnrollAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String student = (String) studentComboBox.getSelectedItem();
            String course = (String) courseComboBox.getSelectedItem();
            enrollmentListModel.addElement(student + " enrolled in " + course);
        }
    }
}
