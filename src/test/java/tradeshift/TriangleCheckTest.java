package tradeshift;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;


public class TriangleCheckTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void mainTestHelpWithAbbreviation() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {"-h"});
    }

    @Test
    public void mainTestHelp() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {"-help"});
    }

    @Test
    public void mainTestWrongParametersNumber0() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {});
    }

    @Test
    public void mainTestWrongParametersNumber1() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {"20"});
    }

    @Test
    public void mainTestWrongParametersNumber2() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {"20", "15"});
    }

    @Test
    public void mainTestWrongParametersNumber4() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {"20", "15", "12", "8"});
    }

    @Test
    public void mainTestWrongParametersType() {
        exit.expectSystemExitWithStatus(1);
        TriangleCheck.main(new String[] {"20.74", "15", "12,45"});
    }

    @Test
    public void mainTestWithIntParameters() {
        TriangleCheck.main(new String[] {"5", "10", "10"});
    }

    @Test(expected = IllegalStateException.class)
    public void mainTestWithIntParametersWrongValues() {
        TriangleCheck.main(new String[] {"5", "10", "-10"});
    }

    @Test
    public void mainTestWithDoubleParameters() {
        TriangleCheck.main(new String[] {"8", "7.23", "5.75"});
    }

    @Test(expected = IllegalStateException.class)
    public void mainTestWithDoubleParametersWrongValues() {
        TriangleCheck.main(new String[] {"5", "10", "-10.23"});
    }

    @Test
    public void convertStringToIntTestWithSuccess() {
        assertIntConversion(0, "0");
        assertIntConversion(1, "1");
        assertIntConversion(22, "22");
        assertIntConversion(1000, "1000");
        assertIntConversion(-10, "-10");
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToIntTestBlank() {
        TriangleCheck.convertStringToInt("");
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToIntTestNull() {
        TriangleCheck.convertStringToInt(null);
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToIntTestWrongNumber() {
        TriangleCheck.convertStringToInt("10.7");
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToIntTestString() {
        TriangleCheck.convertStringToInt("caio");
    }

    @Test
    public void convertStringToDoubleTestWithSuccess() {
        assertDoubleConversion(0, "0");
        assertDoubleConversion(1, "1");
        assertDoubleConversion(22, "22");
        assertDoubleConversion(1000, "1000");
        assertDoubleConversion(-10, "-10");
        assertDoubleConversion(1.0001, "1.0001");
        assertDoubleConversion(22.22, "22.22");
        assertDoubleConversion(1000.1, "1000.1");
        assertDoubleConversion(-10.74, "-10.74");
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToDoubleTestBlank() {
        TriangleCheck.convertStringToDouble("");
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToDoubleTestNull() {
        TriangleCheck.convertStringToDouble(null);
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToDoubleTestWrongNumber() {
        TriangleCheck.convertStringToInt("10,7");
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToDoubleTestString() {
        TriangleCheck.convertStringToInt("caio");
    }

    private void assertIntConversion(int expectedResult, String inputString) {
        assertEquals(expectedResult, TriangleCheck.convertStringToInt(inputString));
    }

    private void assertDoubleConversion(double expectedResult, String inputString) {
        assertEquals(expectedResult, TriangleCheck.convertStringToDouble(inputString), 0);
    }
}
