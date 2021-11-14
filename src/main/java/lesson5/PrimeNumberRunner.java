package lesson5;

import java.util.Scanner;

public class PrimeNumberRunner {

    public static void main(String[] args) {
        System.out.println("Please enter digit");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int limit = scanner.nextInt();
        printPrimeNumbers(limit);
    }

    public static void printPrimeNumbers(int threshold) {
        if (threshold <= 2) {
            System.out.println("Ожидается ввод числе, больших 2");
        }

        for (int i = 2; i < threshold; i++) {
            if (isPrime(i)) {
                System.out.println("Текущее значение " + i + " является простым");
            }
        }
    }

    public static boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer div(int arg1, int arg2) {
        if (arg2 == 0) {
            return null;
        }
        return arg1 / arg2;
    }
}
