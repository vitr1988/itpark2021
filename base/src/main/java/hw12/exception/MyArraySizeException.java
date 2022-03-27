package hw12.exception;

import static hw12.Matrix.*;

public class MyArraySizeException extends RuntimeException {

    private final int wrongRows;
    private final int wrongColumns;

    public MyArraySizeException(int wrongRows, int wrongColumns, String message) {
        super(String.format("%s. Количество строк в матрице ожидалось равным %d, а количество колонок, равным %d", message, ROWS, COLUMNS));
        this.wrongRows = wrongRows;
        this.wrongColumns = wrongColumns;
    }

    public int getWrongRows() {
        return wrongRows;
    }

    public int getWrongColumns() {
        return wrongColumns;
    }
}
