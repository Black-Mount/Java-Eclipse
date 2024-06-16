package system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Class for the Employee Management GUI
public class EmployeeManagementGUI {
    private EmployeeManager employeeManager; // Reference to the EmployeeManager
    private JFrame frame; // Main frame for the GUI
    private JTable table; // Table to display employee data
    private DefaultTableModel tableModel; // Table model for the JTable

    // Constructor to initialize the GUI with an EmployeeManager
    public EmployeeManagementGUI(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
        createAndShowGUI(); // Create and display the GUI
    }

    // Method to create and display the GUI
    public void createAndShowGUI() {
        frame = new JFrame("Employee Management System"); // Initialize the main frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setSize(800, 600); // Set frame size

        // Table setup
        String[] columnNames = {"Name", "Age", "Department", "Salary"}; // Column names for the table
        tableModel = new DefaultTableModel(columnNames, 0); // Initialize table model with column names
        table = new JTable(tableModel); // Initialize JTable with the table model
        JScrollPane scrollPane = new JScrollPane(table); // Add table to scroll pane

        // Buttons
        JButton btnShowNameAndDept = new JButton("Show Name and Department");
        btnShowNameAndDept.addActionListener(e -> showNameAndDept()); // Add action listener for button

        JButton btnAverageSalary = new JButton("Show Average Salary");
        btnAverageSalary.addActionListener(e -> showAverageSalary()); // Add action listener for button

        JButton btnFilterAge = new JButton("Filter Age > 30");
        btnFilterAge.addActionListener(e -> filterAge(30)); // Add action listener for button

        JButton btnSortByName = new JButton("Sort by Name");
        btnSortByName.addActionListener(e -> sortByName()); // Add action listener for button

        JButton btnSortBySalary = new JButton("Sort by Salary");
        btnSortBySalary.addActionListener(e -> sortBySalary()); // Add action listener for button

        JTextField searchField = new JTextField(10); // Text field for searching employees by name
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(e -> searchByName(searchField.getText())); // Add action listener for button

        // Layout setup
        JPanel panel = new JPanel(); // Panel for buttons and search field
        panel.add(btnShowNameAndDept);
        panel.add(btnAverageSalary);
        panel.add(btnFilterAge);
        panel.add(btnSortByName);
        panel.add(btnSortBySalary);
        panel.add(searchField);
        panel.add(btnSearch);

        frame.add(panel, BorderLayout.NORTH); // Add panel to the top of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center of the frame

        frame.setVisible(true); // Make the frame visible
    }

    // Method to display concatenated name and department
    private void showNameAndDept() {
        List<String> nameAndDeptList = employeeManager.getNameAndDeptList(); // Get name and department list
        tableModel.setRowCount(0); // Clear existing table rows
        nameAndDeptList.forEach(str -> {
            String[] parts = str.split(" - "); // Split the concatenated string
            tableModel.addRow(new Object[]{parts[0], "", parts[1], ""}); // Add name and department to separate columns
        });
    }

    // Method to display average salary
    private void showAverageSalary() {
        double averageSalary = employeeManager.getAverageSalary(); // Get average salary
        tableModel.setRowCount(0); // Clear existing table rows
        tableModel.addRow(new Object[]{"Average Salary", "", "", averageSalary}); // Add average salary to table
    }

    // Method to filter employees by age
    private void filterAge(int ageThreshold) {
        List<Employee> filteredEmployees = employeeManager.getEmployeesAboveAge(ageThreshold); // Get filtered employees
        displayEmployees(filteredEmployees); // Display filtered employees in table
    }

    // Method to sort employees by name
    private void sortByName() {
        List<Employee> sortedEmployees = employeeManager.sortEmployeesByName(); // Get sorted employees by name
        displayEmployees(sortedEmployees); // Display sorted employees in table
    }

    // Method to sort employees by salary
    private void sortBySalary() {
        List<Employee> sortedEmployees = employeeManager.sortEmployeesBySalary(); // Get sorted employees by salary
        displayEmployees(sortedEmployees); // Display sorted employees in table
    }

    // Method to search employees by name
    private void searchByName(String name) {
        List<Employee> searchedEmployees = employeeManager.searchEmployeesByName(name); // Get searched employees
        displayEmployees(searchedEmployees); // Display searched employees in table
    }

    // Method to display a list of employees in the table
    private void displayEmployees(List<Employee> employees) {
        tableModel.setRowCount(0); // Clear existing table rows
        employees.forEach(emp -> tableModel.addRow(new Object[]{
                emp.getName(), emp.getAge(), emp.getDepartment(), emp.getSalary() // Add employee data to table
        }));
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManager employeeManager = new EmployeeManager(); // Initialize EmployeeManager
            new EmployeeManagementGUI(employeeManager); // Initialize and display GUI
        });
    }
}
