package lesson14;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapRunner {
    public static void main(String[] args) {
        Map<String, String> words = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        words.put("yellow", "жёлтый");
        words.put("red", "красный");
        words.put("green", "зеленый");
        words.put("black", "черный");
        System.out.println(words);
    }
}
