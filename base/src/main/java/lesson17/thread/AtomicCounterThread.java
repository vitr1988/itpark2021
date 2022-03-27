package lesson17.thread;

import lesson17.AtomicCounter;

public class AtomicCounterThread extends Thread {

    private AtomicCounter counter;
    private int iterations;

    public AtomicCounterThread(AtomicCounter counter, int iterations) {
        this.counter = counter;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i < iterations; i++) {
                counter.incrementAndGet();
            }
            System.out.println(counter.getValue());
        }
    }
}
