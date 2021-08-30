package test.java.com.calculator;

import main.java.com.calculator.Calculation;
import main.java.com.calculator.InvalidInputException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorValidInputTest {
    private String input;
    private long expected;

    public CalculatorValidInputTest(String input, long expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"123", 123},
                {"(add 100 100)", 200},
                {"(add 1000 2147483647)", 2147484647L},
                {"(add 10 (add 3 4))", 17},
                {"(add 3 (add (add 3 3) 3))", 12},
                {"(add 3 (add (add 3 3) (add 3 3)))", 15},
                {"(multiply 100 100)", 10000},
                {"(multiply 1000 2147483647)", 2147483647000L},
                {"(multiply 10 (multiply 3 4))", 120},
                {"(multiply 3 (multiply (multiply 3 3) 3))", 81},
                {"(multiply 3 (multiply (multiply 3 3) (multiply 3 3)))", 243},
                {"(add 10 (multiply 2 3))", 16},
                {"(multiply (add 1 2) 3)", 9},
                {"(multiply 0 (multiply 1 2))", 0},
                {"(multiply 10 (add (multiply 2 3) 8))", 140},
                {"(multiply (add 2 2) (add 2 3))", 20},
                {"(multiply (add (multiply 1 2) (add 3 4)) (multiply 2 2))", 36},
        });
    }

    @Test
    public void main() throws InvalidInputException {
        assertEquals(expected, new Calculation().calculateExpression(input));
    }

}

