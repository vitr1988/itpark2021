package hw12;

public class MatrixRunner {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 4);
        matrix.print();
        System.out.println("Результат суммирования элементов матрицы равен " + matrix.sum());
    }
}
