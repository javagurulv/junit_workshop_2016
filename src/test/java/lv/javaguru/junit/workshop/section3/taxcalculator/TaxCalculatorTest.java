package lv.javaguru.junit.workshop.section3.taxcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaxCalculatorTest {

    @Test
    public void whenTaxRateEqual0_25() {

        TaxRateProvider taxRateProvider = mock(TaxRateProvider.class);
        doReturn(0.25).when(taxRateProvider).getTaxRate();

        assertEquals(taxRateProvider.getTaxRate(), 0.25, 0.001);

        TaxCalculator taxCalculator = new TaxCalculator(taxRateProvider);

        double tax = taxCalculator.calculateTax(10000.0);
        assertEquals(tax, 2500.0, 0.001);
    }


}