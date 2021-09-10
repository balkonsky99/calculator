package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            Parser input = new Parser();
            int[] componentsOfExpression = input.getComponentsOfExpression();
            int num1 = componentsOfExpression[0];
            int num2 = componentsOfExpression[1];
            char operation = (char)componentsOfExpression[2];

            Calculator expression = new Calculator();
            int result = expression.calculate(num1, num2, operation);

            if (input.isRoman) {
                String romanResult = Roman.convert(result);
                System.out.println(romanResult);
            }
            else System.out.println(result);
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }

    }
}
