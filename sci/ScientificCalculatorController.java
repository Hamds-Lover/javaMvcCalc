import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculatorController implements ActionListener {
    private ScientificCalculatorModel model;
    private ScientificCalculatorView view;

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    private boolean isUnaryOperationPending = false;
    private String pendingUnaryOp = "";

    public ScientificCalculatorController(ScientificCalculatorModel model, ScientificCalculatorView view) {
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
            isUnaryOperationPending = false;
            view.clearDisplay();
            return;
        }

        // Unary Operations (Sin, Cos, Tan, Log, Sqrt)
        if ("sin cos tan log sqrt".contains(command)) {
            try {
                double current = Double.parseDouble(view.getDisplayText());
                double result = applyUnary(current, command);
                view.setDisplayText(String.valueOf(result));
                startNewNumber = true; // Result becomes the new starting number
            } catch (NumberFormatException | ArithmeticException ex) {
                view.setDisplayText("Error");
            }
            return;
        }

        if (command.equals("^")) {
            handleOperator(command);
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
            } catch (Exception ex) {
                view.setDisplayText("Error");
            }
            return;
        }

        // Binary Operators (+, -, *, /)
        if ("+-*/".contains(command)) {
            handleOperator(command);
            return;
        }

        // Numbers and Decimal
        if (command.matches("[0-9.]")) {
            if (startNewNumber) {
                view.setDisplayText(command);
                startNewNumber = false;
            } else {
                view.setDisplayText(view.getDisplayText() + command);
            }
        }
    }

    private void handleOperator(String op) {
        if (!startNewNumber) {
            firstNumber = Double.parseDouble(view.getDisplayText());
        }
        operator = op;
        startNewNumber = true;
    }

    private double applyUnary(double a, String op) {
        switch (op) {
            case "sin": return model.sin(a);
            case "cos": return model.cos(a);
            case "tan": return model.tan(a);
            case "log": return model.log(a);
            case "sqrt": return model.sqrt(a);
            default: throw new IllegalArgumentException("Unknown unary op");
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return model.add(a, b);
            case "-": return model.subtract(a, b);
            case "*": return model.multiply(a, b);
            case "/": return model.divide(a, b);
            case "^": return model.power(a, b);
            default: throw new IllegalArgumentException("Unknown operator");
        }
    }
}