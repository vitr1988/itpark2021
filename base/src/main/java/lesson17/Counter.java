package lesson17;

public class Counter {

    private volatile int value;

    public int getValue() {
        return value;
    }

    public synchronized void increment() {
        value++;
//        value = value + 1;
    }

    public int incrementAndGet() {
        value++;
        return value;
    }
}
