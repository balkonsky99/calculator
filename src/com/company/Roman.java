package com.company;

public enum Roman {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);
    private final int value;

    private Roman(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    private static String romanDigit(int n, String one, String five, String ten) throws Exception {

        if (n > 0) {
            return switch (n) {
                case 1 -> one;
                case 2 -> one + one;
                case 3 -> one + one + one;
                case 4 -> one + five;
                case 5 -> five;
                case 6 -> five + one;
                case 7 -> five + one + one;
                case 8 -> five + one + one + one;
                case 9 -> one + ten;
                default -> throw new Exception("Выражение некорректно, т.к. числа должны быть от I до X!");
            };
        }
        return "";
    }

    public static String convert(int num) throws Exception {
        if (num < 0) throw new Exception("Выражение некорректно, т.к. в римской системе нет отрицательных чисел!");
        else if (num == 100) return "C";
        else if (num < 100) {
            String romanOnes = romanDigit(num % 10, "I", "V", "X");
            num /= 10;
            String romanTens = romanDigit(num % 10, "X", "L", "C");
            return romanTens + romanOnes;
        } else throw new Exception("Выражение некорректно, т.к. числа должны быть от I до X!");
    }
}

