package lesson2;

public class FirstProgram {

    int arg1, arg2;

    public static void main(String[] args) {
        System.out.println("Привет, мир123!");

        long summa = summa(3, 5);
        System.out.println(summa);
        long otherSumma = summa(5, 5);
        System.out.println(otherSumma);
        long yetAnotherSumma = summa(2, 18);
        System.out.println(yetAnotherSumma);

        long resultOfMinus = minus(2, 18);
        System.out.println(resultOfMinus);

        long result = multiplyAndSumma(5);
        System.out.println(result);
    }

    /**
     * Метод будет складывать два аргумента и возвращать результат этой операции
     *
     * @param arg1 первый аргумент
     * @param arg2 второй аргумент
     * @return результат сложения двух чисел
     */
    public static long summa(int arg1, int arg2) {
         /* В этой переменной будет храниться результат сложения двух чисел
         Результат вычисления должен быть совместим по типу с аргументами,
         над которыми осуществляется операция сложения
         Еще одна строка */
        int result = arg1 + arg2;
        return result;
    }

    public static long minus(int arg1, int arg2) {
        return arg1 - arg2;
    }

    public static long multiplyAndSumma(int arg1) {
        int result = 3 * arg1 + 15;
        result = result - 38;
        return result;
    }
}
