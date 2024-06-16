package system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeManagementPanel extends JPanel {
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JTextField gradeField;
    private DefaultTableModel gradeTableModel;
    private JTable gradeTable;

    public GradeManagementPanel() {
        setLayout(new BorderLayout());

        // Form to assign grades
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("Select Student:"));
        studentComboBox = new JComboBox<>(new String[]{"Alice", "Bob"});
        formPanel.add(studentComboBox);

        formPanel.add(new JLabel("Select Course:"));
        courseComboBox = new JComboBox<>(new String[]{"Math", "Science", "History"});
        formPanel.add(courseComboBox);

        formPanel.add(new JLabel("Grade:"));
        gradeField = new JTextField();
        formPanel.add(gradeField);

        // Assign grade button to assign a grade to a student in a course
        JButton assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(new AssignGradeAction());
        formPanel.add(assignGradeButton);

        add(formPanel, BorderLayout.NORTH); // Add the form panel to the top of the layout

        // Table to display grades
        gradeTableModel = new DefaultTableModel(new Object[]{"Student", "Course", "Grade"}, 0);
        gradeTable = new JTable(gradeTableModel);
        add(new JScrollPane(gradeTable), BorderLayout.CENTER); // Add the table inside a scroll pane to the center
    }

    // Action listener for the assign grade button
    private class AssignGradeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String student = (String) studentComboBox.getSelectedItem();
            String course = (String) courseComboBox.getSelectedItem();
            String grade = gradeField.getText();

            // Check if the grade is a valid number
            try {
                double parsedGrade = Double.parseDouble(grade);
                if (parsedGrade < 0 || parsedGrade > 100) {
                    // Display an error message if the grade is out of range
                    JOptionPane.showMessageDialog(GradeManagementPanel.this,
                            "Grade must be between 0 and 100.", "Invalid Grade", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                // Display an error message if the grade is not a valid number
                JOptionPane.showMessageDialog(GradeManagementPanel.this,
                        "Grade must be a number.", "Invalid Grade", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // If the grade is valid, add it to the table
            gradeTableModel.addRow(new Object[]{student, course, grade});
            gradeField.setText(""); // Clear the grade field after adding
        }
    }
}
