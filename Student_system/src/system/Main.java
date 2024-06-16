package system;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Start the GUI application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(); // Create the main frame
            mainFrame.setVisible(true); // Make the main frame visible
        });
    }
}
