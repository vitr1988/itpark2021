package lesson16;

public class MatrixRunner {
    public static void main(String[] args) {
        Matrix matrixA = new Matrix(2);
        Matrix matrixB = new Matrix(2);
        System.out.println(matrixA.sum(matrixB));
        System.out.println(matrixA.subtract(matrixB));
    }
}
