package lesson6;

public class SummaArrayRunner {
    public static void main(String[] args) {
        int[] indexes = new int[] {1, 17, 28, -15, 0, 33};
        int result = 0;
        for (int index: indexes) {
            result += index;
        }
        System.out.println(result);
    }
}
