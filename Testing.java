public class Testing {
    void main() {
        Heptadecimal x = new Heptadecimal(Heptadecimal.toHeptadecimal(20));
        // IO.println(x.decimal());
        // x.multiply(new Heptadecimal(Heptadecimal.toHeptadecimal(2)));
        // IO.println(x.decimal());
        // x.multiply(0.5);
        // IO.println(x.decimal());
        // x.add("10");
        // IO.println(x.decimal());

        // IO.println(Heptadecimal.heptadecimalResolve(7));

        // IO.println(Heptadecimal.toHeptadecimal(345));

        // IO.println(new Heptadecimal("GG").decimal());
        // for (int i = 0; i < 100; i++) {
        //     Heptadecimal y = new Heptadecimal(Heptadecimal.toHeptadecimal(i));
        //     IO.println(y.value + " = " + y.decimal());
        // }

        Heptadecimal y = new Heptadecimal(Heptadecimal.toHeptadecimal(13));
        IO.println(Heptadecimal.add(x, y).decimal);
    }

}
