package lv.javaguru.junit.workshop.section3.taxcalculator;

public class TaxCalculator {

    private TaxRateProvider taxRateProvider;


    public TaxCalculator(TaxRateProvider taxRateProvider) {
        this.taxRateProvider = taxRateProvider;
    }

    public double calculateTax(double income) {
        // Provide implementation after writing tests!
        double taxRate = taxRateProvider.getTaxRate();
        return income * taxRate;
    }

}
