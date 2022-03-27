package lesson11.exception;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticRunner {

    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
        System.out.println("Введите 2 числа, которые будут разделены друг на друга:");
        Scanner scanner = new Scanner(System.in);
        int num1;
        try {
            System.out.println("Введите сперва первое :");
            num1 = scanner.nextInt();
        } catch (Throwable exc) {
            num1 = 11;
            scanner.next();
        }
        int num2;
        try {
            System.out.println("Введите и второе :");
            num2 = scanner.nextInt();
            int result = divide(num1, num2);
            System.out.println("Результат деления: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println("Во время деления произошла ошибка");
//        } catch (InputMismatchException e) {
//            System.out.println("Некорректный ввод пользователя");
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Некорректный ввод пользователя");
        } catch (RuntimeException e) {
            System.out.println("Ошибки во время работы программы");
        } catch (Exception e) {
            System.out.println("Ошибки во время работы программы");
        } finally {

        }
        //
        System.out.println("Hello, world!");
    }


    public static int divide(int a, int b) throws CloneNotSupportedException {
        return new Calculator().divide(a, b);
    }

}
