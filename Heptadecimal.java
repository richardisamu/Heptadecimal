import java.util.ArrayList;
import java.util.Arrays;

public class Heptadecimal {
    String value;

    private static boolean verifyHept(String heptadecimal) {
        ArrayList<Character> digitPool = new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'a', 'b', 'c', 'd', 'e', 'f', 'g'));
        for (int i = 0; i < heptadecimal.length(); i++) {
            if (!digitPool.contains(heptadecimal.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public Heptadecimal(String n) {
        if (!verifyHept(n)) {
            throw new IllegalArgumentException("Invalid heptadecimal number.");
        }
        this.value = n;
    }

    public static int decimalResolve(char d) {
        if (!verifyHept("" + d))
            throw new IllegalArgumentException("Invalid heptadecimal digit.");
        else if (d < 57)
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

    public int decimal() {
        int dec = 0;
        for (int i = 0; i < this.value.length(); i++) {
            dec += Math.pow(17, this.value.length() - (i + 1)) * decimalResolve(this.value.charAt(i));
        }
        return dec;
    }

    public void add(Heptadecimal other) {
        this.value = toHeptadecimal(this.decimal() + other.decimal());
    }

    public void add(int other) {
        this.value = toHeptadecimal(this.decimal() + other);
    }

    public void add(String other) {
        this.value = toHeptadecimal(this.decimal() + new Heptadecimal(other).decimal());
    }

    public void multiply(Heptadecimal other) {
        this.value = toHeptadecimal(this.decimal() * other.decimal());
    }

    public void multiply(double other) {
        this.value = toHeptadecimal((int) (this.decimal() * other));
    }

    public void multiply(String other) {
        this.value = toHeptadecimal(this.decimal() * new Heptadecimal(other).decimal());
    }
}

// testing

void main() {
    // Heptadecimal x = new Heptadecimal(Heptadecimal.toHeptadecimal(20));
    // IO.println(x.decimal());
    // x.multiply(new Heptadecimal(Heptadecimal.toHeptadecimal(2)));
    // IO.println(x.decimal());
    // x.multiply(0.5);
    // IO.println(x.decimal());
    // x.add("10");
    // IO.println(x.decimal());

    // IO.println(Heptadecimal.heptadecimalResolve(7));

    // IO.println(Heptadecimal.toHeptadecimal(345));

    // IO.println(new Heptadecimal("1g").decimal());
}
