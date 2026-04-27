import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardCalculatorController implements ActionListener {
    private StandardCalculatorModel model;
    private StandardCalculatorView view;
    
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public StandardCalculatorController(StandardCalculatorModel model, StandardCalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            firstNumber = 0;
            operator = "";
            startNewNumber = true;
            view.clearDisplay();
            return;
        }

        if (command.equals("=")) {
            if (operator.isEmpty()) return;
            try {
                double secondNumber = Double.parseDouble(view.getDisplayText());
                double result = calculate(firstNumber, secondNumber, operator);
                view.setDisplayText(String.valueOf(result));
                startNewNumber = true;
                operator = "";
            } catch (NumberFormatException ex) {
                view.setDisplayText("Error");
            } catch (ArithmeticException ex) {
                view.setDisplayText(ex.getMessage());
            }
            return;
        }

        // If it's an operator (+, -, *, /)
        if ("+-*/".contains(command)) {
            if (!startNewNumber && !operator.isEmpty()) {
                // Calculate intermediate result if user chains operators (e.g., 5+5+)
                try {
                    double current = Double.parseDouble(view.getDisplayText());
                    double result = calculate(firstNumber, current, operator);
                    view.setDisplayText(String.valueOf(result));
                    firstNumber = result;
                } catch (Exception ex) {
                    view.setDisplayText("Error");
                    return;
                }
            } else {
                firstNumber = Double.parseDouble(view.getDisplayText());
            }
            operator = command;
            startNewNumber = true;
            return;
        }

        // Number inputs (handled by appending to display in a real app, 
        // but here we assume the view handles digit entry or we simplify to operator logic only for brevity).
        // NOTE: To make this fully functional with digits, the View needs digit buttons too.
        // Adding digit handling logic assuming the View passes digits or we update display directly.
        // Since the View above only has operators/C/Equals, let's assume the user types in the JTextField 
        // OR we expand the View. For this solution, I will assume the View handles digit typing 
        // and the Controller only handles the math logic triggered by operators/equals.
        
        // Actually, to make it a pure button calculator, we need digit buttons in View.
        // Let's assume the View has digits 0-9 added similarly. 
        // If the command is a digit, we append it.
        if (command.matches("[0-9.]")) {
            if (startNewNumber) {
                view.setDisplayText(command);
                startNewNumber = false;
            } else {
                view.setDisplayText(view.getDisplayText() + command);
            }
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return model.add(a, b);
            case "-": return model.subtract(a, b);
            case "*": return model.multiply(a, b);
            case "/": return model.divide(a, b);
            default: throw new IllegalArgumentException("Unknown operator");
        }
    }
}