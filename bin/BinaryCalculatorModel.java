public class BinaryCalculatorModel {
    // Converts decimal to binary string
    public String toBinary(long num) {
        return Long.toBinaryString(num);
    }

    // Converts binary string to decimal long
    public long toDecimal(String binary) throws NumberFormatException {
        return Long.parseLong(binary, 2);
    }

    public String add(String aBin, String bBin) {
        long a = toDecimal(aBin);
        long b = toDecimal(bBin);
        return toBinary(a + b);
    }

    public String subtract(String aBin, String bBin) {
        long a = toDecimal(aBin);
        long b = toDecimal(bBin);
        return toBinary(a - b);
    }

    public String multiply(String aBin, String bBin) {
        long a = toDecimal(aBin);
        long b = toDecimal(bBin);
        return toBinary(a * b);
    }

    public String divide(String aBin, String bBin) {
        long a = toDecimal(aBin);
        long b = toDecimal(bBin);
        if (b == 0) throw new ArithmeticException("Division by zero!");
        return toBinary(a / b);
    }
}
