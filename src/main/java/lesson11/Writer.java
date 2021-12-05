package lesson11;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Writer {

    public void write(PrintStream oos, String str) throws IOException {
        oos.write(str.getBytes(StandardCharsets.UTF_8));
    }
}
