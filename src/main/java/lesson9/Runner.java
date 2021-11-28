package lesson9;

public class Runner {

    private static Runner ME = new Runner();

    public static void main(String[] args) {
        ME.print();
    }

    private void print() {
        System.out.println("Пример");
    }
}
