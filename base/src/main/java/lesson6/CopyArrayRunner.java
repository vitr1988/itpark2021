package lesson6;

import java.util.Arrays;

public class CopyArrayRunner {
    public static void main(String[] args) {
        String[] words = {"Мама", "мыла", "раму"};
        String[] anotherWords = copyArray(words);
        anotherWords[words.length] = "конец";
        System.out.println(Arrays.toString(anotherWords));
        String[] newArrays = Arrays.copyOf(anotherWords, Math.round(anotherWords.length * 1.5f));
        System.out.println(Arrays.toString(newArrays));
        System.out.println("-------------");
        String[] effectiveArray = new String[100];
        int firstIndex = 0;
        System.arraycopy(words, firstIndex, effectiveArray, 5, words.length - firstIndex);
        System.out.println(Arrays.toString(effectiveArray));
    }

    public static String[] copyArray(String[] words) {
        String[] newArray = new String[Math.round(words.length * 1.5f)];
        for (int i = 0; i < words.length; i++) {
            newArray[i] = words[i];
        }
        return newArray;
    }
}
