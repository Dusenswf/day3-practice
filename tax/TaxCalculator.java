import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculator {
    public double calculateTax(double income) {
        double tax = 0;
        tax += lowerBracket(income) * 0.1;
        tax += middleBracket(income) * 0.2;
        tax += upperBracket(income) * 0.3;
        return tax;
    }

    private double lowerBracket(double income) {
        return Math.min(income, 30000);
    }

    private double middleBracket(double income) {
        return income > 30000 ? Math.min(income, 100000) - 30000 : 0;
    }

    private double upperBracket(double income) {
        return income > 100000 ? income - 100000 : 0;
    }

    @Test
    public void test_first_quarter () {
        TaxCalculator calc = new TaxCalculator();
        double result = calc.calculateTax(25000);
        double expected = 25000 * 0.1 ;
        assertEquals(expected, result, 0.0001); // 오차 허용 값 0.0001
    }

    @Test
    public void test_second_quarter(){
        TaxCalculator calc = new TaxCalculator();
        double result = calc.calculateTax(30001);
        double expected = 30000 * 0.1 + 1 * 0.2;
        assertEquals(expected, result, 0.0001); // 오차 허용 값 0.0001
    }
}



