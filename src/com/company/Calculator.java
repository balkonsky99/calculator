package com.company;

public class Calculator {

    private int sum(int num1, int num2) {
        return num1 + num2;
    }

    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int calculate(int num1, int num2, char operation) throws Exception {
        if ((0 < num1 && num1 <= 10) && (0 < num2 && num2 <= 10)) {
            switch (operation) {
                case '+': return sum(num1, num2);
                case '-': return subtract(num1, num2);
                case '*': return multiply(num1, num2);
                case '/': return divide(num1, num2);
            }
            throw new Exception("Выражение некорректно, т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        else throw new Exception("Выражение некорректно, т.к. числа должны быть от 1 до 10!");

    }
}