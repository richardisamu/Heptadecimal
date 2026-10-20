import java.util.ArrayList;
import java.util.Arrays;

public class Heptadecimal {
    String value;
    ArrayList<Character> digitPool = new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'a', 'b', 'c', 'd', 'e', 'f', 'g'));

    public Heptadecimal(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (!digitPool.contains(n.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        this.value = n;
    }

    public static int decimalResolve(char d) {
        if (d < 57)
            return d - 48;
        else if (d <= 90)
            return d - 55;
        else
            return d - 87;
    }

    public static char heptadecimalResolve(int d){
        if (d > 16)
            throw new IllegalArgumentException();
        else if (d < 10)
            return (char) (d + 48);
        else if (d >= 0)
            return (char) (d + 55);
        else
            throw new IllegalArgumentException();
    }

    private static String heptResRecurs(int d, int exp){
        if (exp == 0)
            return "" + d;
        return "" + d/(int)Math.pow(17, exp) + heptResRecurs(d%(int)Math.pow(17, exp), exp-1);
    }

    public static String toHeptadecimal(int d) {
        int heptExp = 0;
        for (int i = 1; d / Math.pow(17, i) > 1; i++)
            heptExp += 1;
        return "" + heptResRecurs(d, heptExp);
    }

    public int decimal() {
        int dec = 0;
        for (int i = 0; i < this.value.length(); i++) {
            dec += Math.pow(17, this.value.length() - (i + 1)) * decimalResolve(this.value.charAt(i));
        }
        return dec;
    }

}

void main() {
    // Heptadecimal x = new Heptadecimal("1g");
    // IO.println(x.decimal());

    // IO.println(Heptadecimal.heptadecimalResolve(13));
    
    IO.println(Heptadecimal.toHeptadecimal(19));
}
