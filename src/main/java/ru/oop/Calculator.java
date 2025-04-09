package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int num) {
        return num - x;
    }

    public int divide(int num) {
        return num / x;
    }

    public int sumAllOperation(int num) {
       int sumResult = sum(num);
       int multiplyResult = multiply(num);
       int minusResult = minus(num);
       int divideResult = divide(num);
       return sumResult + multiplyResult + minusResult + divideResult;
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);

        int minusResult = Calculator.minus(20);
        System.out.println(minusResult);

        Calculator divide = new Calculator();
        int divideResult = divide.divide(10);
        System.out.println(divideResult);

        Calculator operation = new Calculator();
        int sumAllOperationResult = operation.sumAllOperation(100);
        System.out.println(sumAllOperationResult);
    }
}

