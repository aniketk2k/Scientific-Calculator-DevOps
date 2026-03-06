package calculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testSquareRoot() {
        assertEquals(5.0, App.sqRoot(25), 0.001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, App.factorial(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeFactorial() {
        App.factorial(-1);
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, App.naturalLog(1), 0.001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, App.power(2,3), 0.001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLargeFactorial(){
	App.factorial(21);
    }
}
