package lv.javaguru.junit.workshop.section1;

public class NumberOverturn {

    public static int invertNumber(int number) {
        int invertedNumber = 0;
        while(number != 0) {
            int lastDigit = getLastDigit(number);
            number = reduceNumberBy10(number);
            invertedNumber = addDigit(invertedNumber, lastDigit);
        }
        return invertedNumber;
    }

    private static int getLastDigit(int number) {
        return number % 10;
    }

    private static int reduceNumberBy10(int number) {
        return number / 10;
    }

    private static int addDigit(int invertedNumber, int lastDigit) {
        return invertedNumber * 10 + lastDigit;
    }

}
