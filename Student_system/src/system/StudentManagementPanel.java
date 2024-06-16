package system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Ensure the package name matches the package of your project
// package your.package.name;

public class StudentManagementPanel extends JPanel {
    private JTextField nameField, ageField, idField;
    private DefaultTableModel studentTableModel;
    private JTable studentTable;

    public StudentManagementPanel() {
        setLayout(new BorderLayout());

        // Form to add/update student
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        // Add button to add a new student
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new AddStudentAction());
        formPanel.add(addButton);

        // Update button to update an existing student
        JButton updateButton = new JButton("Update Student");
        updateButton.addActionListener(new UpdateStudentAction());
        formPanel.add(updateButton);

        add(formPanel, BorderLayout.NORTH); // Add the form panel to the top of the layout

        // Table to display student details
        studentTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Age"}, 0);
        studentTable = new JTable(studentTableModel);
        add(new JScrollPane(studentTable), BorderLayout.CENTER); // Add the table inside a scroll pane to the center

        // Populate table with some initial data
        addStudentToTable("1", "Alice", "20");
        addStudentToTable("2", "Bob", "22");
    }

    // Method to add a student to the table
    private void addStudentToTable(String id, String name, String age) {
        studentTableModel.addRow(new Object[]{id, name, age});
    }

    // Action listener for the add button
    private class AddStudentAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();
            addStudentToTable(id, name, age);
        }
    }

    // Action listener for the update button
    private class UpdateStudentAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                studentTableModel.setValueAt(idField.getText(), selectedRow, 0);
                studentTableModel.setValueAt(nameField.getText(), selectedRow, 1);
                studentTableModel.setValueAt(ageField.getText(), selectedRow, 2);
            }
        }
    }
}
