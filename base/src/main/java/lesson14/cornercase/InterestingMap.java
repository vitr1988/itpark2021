package lesson14.cornercase;

import java.util.HashMap;
import java.util.Map;

public class InterestingMap {

    public static void main(String[] args) {
        Map<Pair, Value> dictionaryMap = new HashMap<>();
        Pair pair = new Pair("Ключ1", "Атрибут1");
        dictionaryMap.put(pair, new Value("Значение1"));
        dictionaryMap.put(new Pair("Ключ10", "Атрибут10"), new Value("Значение10"));
        dictionaryMap.put(new Pair("Ключ100", "Атрибут100"), new Value("Значение100"));
        pair.setName("Атрибут1.1");
        dictionaryMap.put(new Pair("Ключ1000", "Атрибут1000"), new Value("Значение1000"));
        // и т.д.
        System.out.println(dictionaryMap.get(pair));
        System.out.println(dictionaryMap.get(new Pair("Ключ1", "Атрибут1")));
    }
}
