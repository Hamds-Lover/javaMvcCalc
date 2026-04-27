import javax.swing.SwingUtilities;

public class MainBinary {
    public static void main(String[] args) {
        // Ensure GUI is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            BinaryCalculatorModel model = new BinaryCalculatorModel();
            BinaryCalculatorView view = new BinaryCalculatorView();
            
            // Connect View and Model via Controller
            new BinaryCalculatorController(model, view);
            
            // Make the window visible
            view.setVisible(true);
        });
    }
}
