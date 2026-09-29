package Exam1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TollCalculatorTest {
    @ParameterizedTest
    @CsvFileSource(resources="/Exam1.csv",numLinesToSkip = 1)
    public void testTollCalculator(String testCaseName, double weight, boolean isEV, boolean isCarpool, String result, String testCoverage){
        TollCalculator toll = new TollCalculator();

        // test exception cases (case 1 and 2)
        if (result.equalsIgnoreCase("IllegalArgumentException")) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> toll.calculateDiscount(weight, isEV, isCarpool),
                    "Case " + testCaseName + " should have thrown. TCI covered: " + testCoverage);
        }
        // test rest of cases
        else {
            double expected = Double.parseDouble(result);
            double actual = toll.calculateDiscount(weight, isEV, isCarpool);
            Assertions.assertEquals(expected, actual, 0.0001,
                    "Case " + testCaseName + " failed. TCI covered: " + testCoverage);
        }
    }
}
