package lv.javaguru.junit.workshop.section2;

public class TaxCalculator {

    public static final double BORDER = 20000;

    public double calculateTax(double income) {
        // Provide implementation after writing tests!

        if (income <= BORDER) {
            return income * 0.25;
        } else {
            return BORDER * 0.25
                    + (income - BORDER) * 0.4;
        }
    }

}
