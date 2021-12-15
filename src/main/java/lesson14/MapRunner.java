package lesson14;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MapRunner {
    public static void main(String[] args) {
        Map<Integer, String> regions = new LinkedHashMap<>();
        regions.put(77, "Москва");
        regions.put(63, "Самара");
        regions.put(64, "Саратов2");
        regions.put(16, "Казань");
        regions.put(78, "Санкт-Петербург");
        String searchValue = "Ростов-на-Дону";
        regions.put(61, searchValue);
        regions.putIfAbsent(64, "Саратов");
        int key = 71;
        regions.put(key, null);
        regions.put(null, null);
        System.out.println(regions);
        System.out.println(regions.get(77));
        if (regions.containsKey(key)) {
//        if (regions.get(71) != null) {
            System.out.println(regions.get(key));
        }
        System.out.println(regions.size());
        System.out.println(regions.keySet());
        System.out.println(regions.values());

        System.out.println(regions.containsValue("Самара"));

        System.out.println(getKeyByValue(regions, searchValue));

    }

    private static Integer getKeyByValue(Map<Integer, String> regions, String searchValue) {
        for (Map.Entry<Integer, String> entry : regions.entrySet()) {
            if (Objects.equals(searchValue, entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Ключа по значению " + searchValue + " не найдено!");
    }
}
