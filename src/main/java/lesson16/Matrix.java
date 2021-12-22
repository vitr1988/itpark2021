package lesson16;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;

public class Matrix {

    private int[][] matrix;

    public Matrix(int size) {
        this.matrix = new int[size][size];
        fillUp();
    }

    private void fillUp() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = new Random().nextInt();
            }
        }
    }

    public Matrix sum(Matrix m) {
//        Matrix result = new Matrix(this.matrix.length);
//        for (int i = 0; i < this.matrix.length; i++) {
//            for (int j = 0; j < this.matrix[i].length; j++) {
//                result.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
//            }
//        }
//        return result;
        return iterateAndApplyAction(this, m, Integer::sum);
    }

    public Matrix subtract(Matrix m) {
//        Matrix result = new Matrix(this.matrix.length);
//        for (int i = 0; i < this.matrix.length; i++) {
//            for (int j = 0; j < this.matrix[i].length; j++) {
//                result.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
//            }
//        }
//        return result;
        return iterateAndApplyAction(this, m, (i, j) -> i - j);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                result += this.matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

    private static Matrix iterateAndApplyAction(Matrix a, Matrix b, BiFunction<Integer, Integer, Integer> biFunction) {
        Matrix result = new Matrix(a.matrix.length);
        for (int i = 0; i < a.matrix.length; i++) {
            for (int j = 0; j < a.matrix[i].length; j++) {
                result.matrix[i][j] = biFunction.apply(a.matrix[i][j], b.matrix[i][j]);
            }
        }
        return result;
    }
}
