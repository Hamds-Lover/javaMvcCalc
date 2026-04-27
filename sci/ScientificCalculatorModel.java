public class ScientificCalculatorModel {
    public double add(double a, double b) { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }

    // Scientific Operations
    public double sin(double a) { return Math.sin(Math.toRadians(a)); } // Assuming degrees input
    public double cos(double a) { return Math.cos(Math.toRadians(a)); }
    public double tan(double a) { return Math.tan(Math.toRadians(a)); }
    public double log(double a) { 
        if (a <= 0) throw new ArithmeticException("Log of non-positive number");
        return Math.log10(a); 
    }
    public double sqrt(double a) { 
        if (a < 0) throw new ArithmeticException("Square root of negative number");
        return Math.sqrt(a); 
    }
    public double power(double base, double exp) { return Math.pow(base, exp); }
}