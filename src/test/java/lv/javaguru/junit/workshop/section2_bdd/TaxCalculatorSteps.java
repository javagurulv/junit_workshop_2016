package lv.javaguru.junit.workshop.section2_bdd;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TaxCalculatorSteps {

    private TaxCalculatorBDD taxCalculator = new TaxCalculatorBDD();

    private double income;


    @When("^income equal (\\d+)$")
    public void income_equal(double income) {
        this.income = income;
    }

    @Then("^tax should be equal (\\d+)$")
    public void tax_should_be_equal(double tax) {
        double realTax = taxCalculator.calculateTax(income);
        assertThat(realTax, equalTo(tax));
    }

}
