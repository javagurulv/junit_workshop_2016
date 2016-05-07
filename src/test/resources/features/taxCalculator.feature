Feature: Tax Calculator BDD example

    Scenario: ZERO Income
        When income equal 0
        Then tax should be equal 0

    Scenario: Income up to 20000
        When income equal 10000
        Then tax should be equal 2500

    Scenario: Income equal 20000
        When income equal 20000
        Then tax should be equal 5000

