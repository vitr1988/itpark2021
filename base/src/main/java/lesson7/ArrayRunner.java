package lesson7;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayRunner {

    public static void main(String[] args) {
        Integer[] nums = {78, 65, 125, 11};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));
        System.out.println(summa(1, 2));
    }

    public static int summa(int arg1, int arg2) {
        return arg1 + arg2;
    }
}
