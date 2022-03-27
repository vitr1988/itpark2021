package lesson6;

import java.util.Arrays;

public class ModifyArrayRunner {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] anotherDigits = new int[digits.length + 1];
//        int[] anotherDigits = digits;
        for (int index = 0; index < anotherDigits.length; index++) {
            anotherDigits[index] += 10;
        }
        System.out.println(Arrays.toString(anotherDigits));
        System.out.println("------------");
        System.out.println(Arrays.toString(digits));

    }
}
