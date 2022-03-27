package lesson17.thread;

import lesson17.Counter;

public class CounterThread extends Thread {

    private Counter counter;
    private int iterations;

    public CounterThread(Counter counter, int iterations) {
        this.counter = counter;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
            System.out.println(counter.getValue());
        }
    }
}
