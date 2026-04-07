import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public void showResult(double result) {
        System.out.println("Result: " + result);
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public double getNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public String getOperator() {
        System.out.print("Enter operator (+, -, *, /): ");
        return scanner.next();
    }

    public void showMenu() {
        System.out.println("===== Calculator =====");
    }
}