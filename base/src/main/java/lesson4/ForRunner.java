package lesson4;

public class ForRunner {

    public static void main(String[] args) {
        int globalCounter;
        for (int counter = globalCounter = 1, value = 123; counter <= 100; counter++, value++) {
            if (counter % 2 == 0) {
                System.out.println("Текущее значение счетчика: " + counter);
                if (counter > 50) {
                    break;
                }
            }
        }
        System.out.println("------");
//        for(;;) {
//            System.out.println(globalCounter++);
//        }
    }
}
