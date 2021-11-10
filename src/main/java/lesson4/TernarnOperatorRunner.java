package lesson4;

public class TernarnOperatorRunner {

    public static void main(String[] args) {
        System.out.println(abs(25));
        System.out.println(abs(-13));
    }

    public static int abs(int value) {
        return value >= 0 ? value : -value;
    }
}
