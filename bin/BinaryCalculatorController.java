import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryCalculatorController implements ActionListener {
    private BinaryCalculatorModel model;
    private BinaryCalculatorView view;
    
    private String firstNumber = "";
    private String operator = "";
    private boolean startNewNumber = true;

    public BinaryCalculatorController(BinaryCalculatorModel model, BinaryCalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            firstNumber = "";
            operator = "";
            startNewNumber = true;
            view.clearDisplay();
            return;
        }

        if (command.equals("=")) {
            if (operator.isEmpty() || firstNumber.isEmpty()) return;
            try {
                String secondNumber = view.getDisplayText();
                if (secondNumber.isEmpty()) return;
                
                String result = calculate(firstNumber, secondNumber, operator);
                view.setDisplayText(result);
                startNewNumber = true;
                operator = "";
            } catch (NumberFormatException ex) {
                view.setDisplayText("Invalid Binary");
            } catch (ArithmeticException ex) {
                view.setDisplayText(ex.getMessage());
            }
            return;
        }

        if ("+-*/".contains(command)) {
            if (!startNewNumber) {
                firstNumber = view.getDisplayText();
            } else if (firstNumber.isEmpty()) {
                firstNumber = view.getDisplayText();
            }
            operator = command;
            startNewNumber = true;
            return;
        }

        // Handle 0 and 1
        if (command.equals("0") || command.equals("1")) {
            if (startNewNumber) {
                view.setDisplayText(command);
                startNewNumber = false;
            } else {
                view.setDisplayText(view.getDisplayText() + command);
            }
        }
    }

    private String calculate(String a, String b, String op) {
        switch (op) {
            case "+": return model.add(a, b);
            case "-": return model.subtract(a, b);
            case "*": return model.multiply(a, b);
            case "/": return model.divide(a, b);
            default: throw new IllegalArgumentException("Unknown operator");
        }
    }
}
