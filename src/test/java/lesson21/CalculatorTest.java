package lesson21;

import lesson21.Calc.Calc;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void shouldCalculatorCanCalculateSumma() {
        Calc calc = new Calc(10, 15);
        Assert.assertEquals(25, calc.summa());

        Calc calc2 = new Calc(-10, 15);
        Assert.assertEquals(5, calc2.summa());

        Calc calc3 = new Calc(0, 15);
        Assert.assertEquals(15, calc3.summa());
    }

    @Test
    public void shouldCalculatorCanCalculateDivision() {
        Calc calc = new Calc(15, 3);
        Assert.assertEquals(5, calc.division());


        Calc calc3 = new Calc(49, 7);
        Assert.assertEquals(7, calc3.division());
    }

    @Test(expected = ArithmeticException.class)
    public void shouldCalculatorCanCalculateDivisionByZero() {
        Calc calc = new Calc(15, 0);
        calc.division();
//        try {
//            calc.division();
//            Assert.fail();
//        } catch (ArithmeticException e) {
//            Assert.assertTrue(true);
//        }
    }
}
