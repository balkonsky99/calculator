package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parser {

    boolean isRoman = false;

    private int[] extractDataOfOperation (String str) throws Exception {
        int[] array = {0, 0};
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '+', '-', '*', '/' -> {
                    array[0] = i;
                    array[1] = str.charAt(i);
                    count++;
                }
            }
        }
        if (count == 1) return array;
        else if (count == 0) throw new Exception("Выражение некорректно, т.к. строка не является математической операцией!");
        else throw new Exception("Выражение некорректно, т.к. формат математической операции не удовлетворяет заданию - два операнда (от 1 до 10) и один оператор (+, -, /, *)");
    }

    private boolean isNumeric(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkForRoman(String s) {
        try {
            int check = Roman.valueOf(s.toUpperCase()).toInt();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int[] getComponentsOfExpression() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String dataOfConsole = buffer.readLine().replaceAll("\\s+","");
        int[] operation = extractDataOfOperation(dataOfConsole);

        String num1 = dataOfConsole.substring(0, operation[0]);
        String num2 = dataOfConsole.substring(operation[0] + 1, dataOfConsole.length());
        int[] componentsOfExpression = {0, 0, 0};

        if (isNumeric(num1) && isNumeric(num2)) {
            componentsOfExpression[0] = Integer.parseInt(num1);
            componentsOfExpression[1] = Integer.parseInt(num2);
        }

        else if (checkForRoman(num1) && checkForRoman(num2)){
            componentsOfExpression[0] = Roman.valueOf(num1.toUpperCase()).toInt();
            componentsOfExpression[1] = Roman.valueOf(num2.toUpperCase()).toInt();
            isRoman = true;
        }
        else if (isNumeric(num1) && checkForRoman(num2) || isNumeric(num2) && checkForRoman(num1))
            throw new Exception("Выражение некорректно, т.к. используются одновременно разные системы счисления!");
        else if (!isNumeric(num1) && !checkForRoman(num2) || !isNumeric(num2) && !checkForRoman(num1))
            throw new Exception("Выражение некорректно, т.к. формат математической операции не удовлетворяет заданию - два операнда (от 1 до 10) и один оператор (+, -, /, *)");

        componentsOfExpression[2] = operation[1];
            return componentsOfExpression;
    }
}
