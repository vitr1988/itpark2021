package lesson16.concurrency;

public class ThreadRunner {

    public static void main(String[] args) throws Exception {
//        System.gc();
        Thread.currentThread().setPriority(8);
        int a = 15;
        int b = 20;
        Thread printerThread1 = new PrinterThread("Первый поток printer", "Привет, мир", 5);
        Thread.State state = printerThread1.getState();
        Thread printerThread2 = new PrinterThread("Добро пожаловать!", 1, true);
        printerThread1.start();
//        printerThread1.join();
        printerThread2.start();
//        printerThread2.join();
        new Thread(() -> print(Thread.currentThread().getName() + ":" + summa(a, b))).start();
        System.out.println(Thread.currentThread().getName());

//        Thread.sleep(60 * 1000);
    }

    private static int summa(int a, int b) {
        return a + b;
    }

    private static void print(Object ob) {
        System.out.println(ob);
    }
}
