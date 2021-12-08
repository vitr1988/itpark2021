package lesson12;

public class ExceptionRunner {

    public static void main(String[] args) {
        boolean succeeded = false;
        try {
            System.out.println(divide(5, 0));
            succeeded = true;
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
            succeeded = false;
        } finally {
            System.out.println(succeeded ? "Выполнение операции завершено успешно" : "Выполнение операции завершено неуспешно");
        }
    }

    private static int divide(int i, int i1) {
        return i / i1;
    }
}
