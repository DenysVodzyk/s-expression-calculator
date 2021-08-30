package main.java.com.calculator;

public class Calculator {
    public static void main(String[] args) {

        try {

            if (args.length != 1) {
                throw new InvalidInputException(Constants.INVALID_INPUT_MESSAGE);
            }
            Calculation calculation = new Calculation();
            long result = calculation.calculateExpression(args[0]);
            System.out.println(result);

        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}

