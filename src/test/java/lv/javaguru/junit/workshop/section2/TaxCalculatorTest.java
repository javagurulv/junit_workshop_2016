package lv.javaguru.junit.workshop.section2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator = new TaxCalculator();


    private void checkTax(double income,
                          double expectedTax) {
        double realTax = taxCalculator.calculateTax(income);
        assertEquals(realTax, expectedTax, 0.001);
    }

    @Test
    public void whenIncomeEqualZero() {
        checkTax(0.0, 0.0);
    }

    @Test
    public void whenIncomeEqual10000() {
        checkTax(10000.0, 2500.0);

    }

    @Test
    public void whenIncomeEqual20000() {
        checkTax(20000.0, 5000.0);
    }

    @Test
    public void whenIncomeMoreThen20000() {
        checkTax(21000.0, 5400.0);
    }

}