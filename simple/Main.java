import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StandardCalculatorModel model = new StandardCalculatorModel();
            StandardCalculatorView view = new StandardCalculatorView();
            new StandardCalculatorController(model, view);
            view.setVisible(true);
        });
    }
}