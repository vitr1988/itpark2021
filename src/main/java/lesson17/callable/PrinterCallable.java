package lesson17.callable;

import java.util.concurrent.Callable;

public class PrinterCallable implements Callable<Void> {

    private String str;

    public PrinterCallable(String str) {
        this.str = str;
    }

    @Override
    public Void call() throws Exception {
        System.out.println(str);
        return null;
    }
}
