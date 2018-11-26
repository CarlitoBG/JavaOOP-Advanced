package p07_hack;

import org.junit.Assert;
import org.junit.Test;

public class HackTest {

    @Test
    public void testMathAbsWithValidParamsShouldWorkCorrectly(){
        int actualResult = Math.abs(-35);

        int expectedResult = 35;

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSystemLineSeparatorShouldWorkCorrectly(){
        String actualResult = System.lineSeparator();

        String expectedResult = "\r\n";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMathFloorWithValidParamsShouldWorkCorrectly(){
        double actualResult = Math.floor(3.5);

        double expectedResult = 3;

        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}