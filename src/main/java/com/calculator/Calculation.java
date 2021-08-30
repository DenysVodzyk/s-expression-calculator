package main.java.com.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private InputValidation inputValidation;
    /*
      allowedNumberOfArguments represents the number of passed arguments inside parenthesis.
      By default, 3 arguments are allowed (function, expression, expression), but it can be changed or deleted
      to allow any number of arguments.
     */
    private int allowedNumberOfArguments;

    public Calculation() {
        this.inputValidation = new InputValidation();
        this.allowedNumberOfArguments = 3;
    }

    /**
     * Calculates passed expression
     *
     * @param expression - input String expression
     * @return - result of expression evaluation
     * @throws InvalidInputException - thrown in case of invalid input
     */
    public long calculateExpression(String expression) throws InvalidInputException {
        inputValidation.validateInput(expression);

        // StringBuilder is used to avoid memory allocation for String each time we modify an expression.
        StringBuilder functionBuilder = new StringBuilder(expression);

        while (functionBuilder.indexOf("(") != -1) {
            int startIndex = functionBuilder.lastIndexOf("(");
            int endIndex = startIndex + functionBuilder.substring(startIndex).indexOf(")") + 1;
            StringBuilder expressionBuilder = new StringBuilder(functionBuilder.substring(startIndex, endIndex));

            // Fetching numbers from StringBuilder inside parenthesis
            List<Long> numbersFromExpression = fetchNumbersFromExpression(expressionBuilder.toString());
            long resultOfExpression = -1;

            if (expressionBuilder.substring(1, expressionBuilder.indexOf(" ")).equals("add")) {
                resultOfExpression = add(numbersFromExpression);
            } else if (expressionBuilder.substring(1, expressionBuilder.indexOf(" ")).equals("multiply")) {
                resultOfExpression = multiply(numbersFromExpression);
            }
            functionBuilder.replace(startIndex, endIndex, String.valueOf(resultOfExpression));
        }
        return Long.parseLong(functionBuilder.toString());
    }

    /**
     * Fetch numbers from expression inside parenthesis. Ignore mathematical operation
     *
     * @param expression - expression inside parenthesis
     * @return - list of numbers inside parenthesis
     * @throws InvalidInputException - thrown in case of invalid input
     */
    private List<Long> fetchNumbersFromExpression(String expression) throws InvalidInputException {
        List<Long> numbers = new ArrayList<>();
        String[] expressionArray = expression.replaceAll("[^0-9]+", " ").split(" ");

        inputValidation.validateExpressionInsideParenthesis(expressionArray, allowedNumberOfArguments);

        for (int i = 1; i < expressionArray.length; i++) {
            numbers.add(Long.parseLong(expressionArray[i]));
        }
        return numbers;
    }

    private long multiply(List<Long> numbers) {
        long output = 1;
        for (long number : numbers) {
            output *= number;
        }
        return output;
    }

    private long add(List<Long> numbers) {
        long output = 0;
        for (long number : numbers) {
            output += number;
        }
        return output;
    }
}