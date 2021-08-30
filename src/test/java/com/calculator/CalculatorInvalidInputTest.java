package test.java.com.calculator;

import main.java.com.calculator.Calculation;
import main.java.com.calculator.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class CalculatorInvalidInputTest {
    private String input;
    private Class<Throwable> expected;

    public CalculatorInvalidInputTest(String input, Class<Throwable> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, InvalidInputException.class},
                {"", InvalidInputException.class},
                {"add", InvalidInputException.class},
                {"(add 1 2 3)", InvalidInputException.class},
                {"(add 1 2 ()", InvalidInputException.class},
                {"(add 1 2.2)", InvalidInputException.class},
                {"(add 1 2 (multiply 2 2 3))", InvalidInputException.class},
                {"multiply", InvalidInputException.class},
                {"multiply ()", InvalidInputException.class},
                {"(multiply 2 (multiply 3333333333 4))", InvalidInputException.class},
                {"(multiply (multiply))", InvalidInputException.class},
                {"(multiply ())", InvalidInputException.class},
                {"delete (2 3)", InvalidInputException.class},
                {"12312312312312", InvalidInputException.class},
        });
    }

    @Test
    public void main() {
        assertThrows(expected, ()-> new Calculation().calculateExpression(input));
    }
}