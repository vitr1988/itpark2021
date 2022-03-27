package lesson17.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagThread extends Thread {

    private AtomicBoolean flag;

    public FlagThread(AtomicBoolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
//        while (!isInterrupted()) {
        while(!flag.get()) {
            System.out.println("Привет из потока " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
