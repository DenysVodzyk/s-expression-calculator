package main.java.com.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputValidation {

    public void validateInput(String expression) throws InvalidInputException {
        if (!isExpressionValid(expression)) {
            throw new InvalidInputException(Constants.INVALID_INPUT_MESSAGE);
        }
    }

    /**
     * Check if passed string consists of valid characters and data types.
     *
     * @param expression - input String expression
     * @return - result of expression validation
     */
    private boolean isExpressionValid(String expression) {
        if (expression == null || expression.isBlank() || expression.equals("add") || expression.equals("multiply")) {
            return false;
        }

        if (isNumber(expression)) {
            return isNumberAnInteger(expression);
        }

        if (!isParenthesisBalanced(expression)) {
            return false;
        }

        return isExpressionFreeOfInvalidCharacters(expression);
    }

    private boolean isExpressionFreeOfInvalidCharacters(String expression) {
        expression = expression.replaceAll("[()]|[0-9]|multiply|add", "");
        return expression.trim().isEmpty();
    }

    private boolean isParenthesisBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push('(');
            } else if (expression.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean isNumberAnInteger(String number) {
        return Long.parseLong(number) <= Integer.MAX_VALUE;
    }

    private boolean isNumber(String number) {
        for (Character c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void validateExpressionInsideParenthesis(String[] expression, int n) throws InvalidInputException {
        if (!isExpressionInsideParenthesisValid(expression, n)) {
            throw new InvalidInputException(Constants.INVALID_INPUT_MESSAGE);
        }
    }


    /**
     * Check expression inside parenthesis.
     *
     * @param expression - String array of expressions inside parentehsis
     * @param n          - number of passed arguments inside parenthesis.
     * @return - result of expression validation
     */
    private boolean isExpressionInsideParenthesisValid(String[] expression, int n) {
        if (expression.length == 0) {
            return false;
        }

        if (!isQuantityOfPassedArgumentsCorrect(expression, n)) {
            return false;
        }

        for (int i = 1; i < expression.length; i++) {
            if (!isNumber(expression[i]) || !isNumberAnInteger(expression[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isQuantityOfPassedArgumentsCorrect(String[] expressionInsideParenthesis, int n) {
        return expressionInsideParenthesis.length == n;
    }
}