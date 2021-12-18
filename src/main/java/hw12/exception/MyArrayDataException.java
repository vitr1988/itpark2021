package hw12.exception;

public class MyArrayDataException extends NumberFormatException {

    private final int wrongRow;
    private final int wrongColumn;

    public MyArrayDataException(int row, int column, String message) {
        super(String.format("%s. Ошибка произошла на строке %d и в столбце %d", message, row, column));
        this.wrongRow = row;
        this.wrongColumn = column;
    }

    public int getWrongRow() {
        return wrongRow;
    }

    public int getWrongColumn() {
        return wrongColumn;
    }
}
