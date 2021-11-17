package lesson6;

import java.util.Arrays;

public class MatrixRunner {

    public static void main(String[] args) {
        int size = 9;
        int[][] matrix = new int[size][size];
        fillFigure(matrix);
//        System.out.println(Arrays.deepToString(matrix));
        printFigure(matrix);
    }

    public static void fillFigure(int[][] array) {
        for (int i = 0; i < array.length; i++) {// перебор строк таблицы
            for (int j = 0; j < array[i].length; j++) { // перебор столбцов таблицы
                if (i == j || j == array[i].length - i - 1) {
                    array[i][j] = 1;
                }
            }
        }
    }

    public static void printFigure(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
