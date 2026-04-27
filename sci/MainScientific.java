import javax.swing.SwingUtilities;

public class MainScientific {
    public static void main(String[] args) {
        // Ensure GUI is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            ScientificCalculatorModel model = new ScientificCalculatorModel();
            ScientificCalculatorView view = new ScientificCalculatorView();
            
            // Connect View and Model via Controller
            new ScientificCalculatorController(model, view);
            
            // Make the window visible
            view.setVisible(true);
        });
    }
}