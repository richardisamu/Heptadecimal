import java.util.ArrayList;
import java.util.Arrays;

public class Heptadecimal {
    String value;
    int decimal;

    private static boolean verifyHept(String heptadecimal) {
        ArrayList<Character> digitPool = new ArrayList<Character>(
                Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'a',
                        'b', 'c', 'd', 'e', 'f', 'g'));
        for (int i = 0; i < heptadecimal.length(); i++)
            if (!digitPool.contains(heptadecimal.charAt(i)))
                return false;
        return true;
    }

    private void update(String s) {
        this.value = s;
        this.decimal = this.asDecimal();
    }

    public Heptadecimal(String n) {
        if (!verifyHept(n)) {
            throw new IllegalArgumentException("Invalid heptadecimal number.");
        }
        update(n);
    }

    public static int decimalResolve(char d) {
        if (!verifyHept("" + d))
            throw new IllegalArgumentException("Invalid heptadecimal digit.");
        else if (d < 58)
            return d - 48;
        else if (d <= 90)
            return d - 55;
        else
            return d - 87;
    }

    public static char heptadecimalResolve(int decimal) {
        if (decimal > 16)
            throw new IllegalArgumentException("Decimal numbers greater than 16 are not supported.");
        else if (decimal >= 10)
            return (char) (decimal + 55);
        else if (decimal >= 0)
            return (char) (decimal + 48);
        else
            throw new IllegalArgumentException("Negative numbers are not supported.");
    }

    public static String toHeptadecimal(int decimal) {
        if (decimal < 0)
            throw new IllegalArgumentException("Negative numbers are not supported.");
        if (decimal < 17)
            return "" + heptadecimalResolve(decimal);
        return "" + toHeptadecimal(decimal / 17) + heptadecimalResolve(decimal % 17);
    }

    public static int toDecimal(Heptadecimal heptadecimal) {
        return heptadecimal.asDecimal();
    }

    public static int toDecimal(String heptadecimal) {
        if (!verifyHept(heptadecimal))
            throw new IllegalArgumentException("Invalid heptadecimal number.");
        int dec = 0;
        for (int i = 1; i <= heptadecimal.length(); i++) {
            dec += Math.pow(17, heptadecimal.length() - i) * decimalResolve(heptadecimal.charAt(i - 1));
        }
        return dec;
    }

    private int asDecimal() { // Needs checking/fixing (negative numbers, Zählvariable, Argumente)
        int dec = 0;
        for (int i = 1; i <= this.value.length(); i++) {
            dec += Math.pow(17, this.value.length() - i) * decimalResolve(this.value.charAt(i - 1));
        }
        return dec;
    }

    public void add(Heptadecimal other) {
        update(toHeptadecimal(this.asDecimal() + other.asDecimal()));
    }

    public void add(int other) {
        update(toHeptadecimal(this.asDecimal() + other));
    }

    public void add(String other) {
        update(toHeptadecimal(this.asDecimal() + new Heptadecimal(other).asDecimal()));
    }

    public void subtract(Heptadecimal other) {
        update(toHeptadecimal(this.asDecimal() - other.asDecimal()));
    }

    public void subtract(int other) {
        update(toHeptadecimal(this.asDecimal() - other));
    }

    public void subtract(String other) {
        update(toHeptadecimal(this.asDecimal() - new Heptadecimal(other).asDecimal()));
    }

    public void multiply(Heptadecimal other) {
        update(toHeptadecimal(this.asDecimal() * other.asDecimal()));
    }

    public void multiply(double other) {
        update(toHeptadecimal((int) (this.asDecimal() * other)));
    }

    public void multiply(String other) {
        update(toHeptadecimal(this.asDecimal() * new Heptadecimal(other).asDecimal()));
    }

    public void divide(Heptadecimal other) {
        update(toHeptadecimal(this.asDecimal() / other.asDecimal()));
    }

    public void divide(double other) {
        update(toHeptadecimal((int) (this.asDecimal() / other)));
    }

    public void divide(String other) {
        update(toHeptadecimal(this.asDecimal() / new Heptadecimal(other).asDecimal()));
    }

    public static Heptadecimal add(Heptadecimal a, Heptadecimal b) {
        return new Heptadecimal(toHeptadecimal(a.asDecimal() + b.asDecimal()));
    }

    public static Heptadecimal subtract(Heptadecimal a, Heptadecimal b) {
        return new Heptadecimal(toHeptadecimal(a.asDecimal() - b.asDecimal()));
    }

    public static Heptadecimal multiply(Heptadecimal a, Heptadecimal b) {
        return new Heptadecimal(toHeptadecimal(a.asDecimal() * b.asDecimal()));
    }

    public static Heptadecimal divide(Heptadecimal a, Heptadecimal b) {
        return new Heptadecimal(toHeptadecimal(a.asDecimal() / b.asDecimal()));
    }
}
