package lesson11.exception;

import lesson11.Car;

public class Calculator {

    private Car car;

    public int division(int m, int n) throws CloneNotSupportedException {
        car = (Car) new Car().clone();
        return m / n;
    }

    public int divide(int a, int b) {
        try {
            return a / b;
//        } catch (ArithmeticException exception) {
//            exception.printStackTrace();
        } finally {
            System.out.println("a = " + a + ", b = " + b);
            return 123;
        }
//        return -100;
    }
}
