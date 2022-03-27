package lesson21;

import lesson21.Calc.Calc;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    private Calc calculator;

    @BeforeClass
    public static void init() {
        System.out.println("Начало выполнения тестов");
    }

    @AfterClass
    public static void destroy() {
        System.out.println("Завершение выполнения тестов");
    }

    @Before
    public void initBeforeTest() {
        calculator = new Calc(27, 3);
    }

    @After
    public void destroyAfterTest() {
        calculator = null;
    }

    @Test
    public void shouldCalculatorCanCalculateSumma() {
        Calc calc = new Calc(10, 15);
        Assert.assertEquals("Проверка выполнения сумма завершилась некорректно", 25, calc.summa());

        Calc calc2 = new Calc(-10, 15);
        Assert.assertEquals(5, calc2.summa());

        Calc calc3 = new Calc(0, 15);
        Assert.assertEquals(15, calc3.summa());

        Assert.assertEquals(30, calculator.summa());
    }

    @Test
    public void shouldCalculatorCanCalculateDivision() {
        Calc calc = new Calc(15, 3);
        Assert.assertEquals(5, calc.division());


        Calc calc3 = new Calc(49, 7);
        Assert.assertEquals(7, calc3.division());

        Assert.assertEquals(9, calculator.division());
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
