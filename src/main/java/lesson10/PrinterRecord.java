package lesson10;

public record PrinterRecord(String text, String source) {

    public void print() {
        System.out.println(text());
    }
}
