package lesson10;

public class AnalogPrinterRecord {

    private final String text;
    private final String source;

    public AnalogPrinterRecord(String text, String source) {
        this.text = text;
        this.source = source;
    }

    public String text() {
        return text;
    }

    public String source() {
        return source;
    }

    public void print() {
        System.out.println(text());
    }
}
