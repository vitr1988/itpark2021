package lesson22;

import lesson21.CalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AverageServiceTest.class, CalculatorTest.class})
public class MathematicSuite {
}
