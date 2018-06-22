package processors;

import java.util.*;

/**
 * Реализация преобразования данных(строки) в требуемую структуру данных(Map<Character, List<String>>)
 */
public class MapDataProcessor implements DataProcessor {
    @Override
    public Map processData(String data) {
        //Используем TreeMap для сортировки по первой букве слова
        Map<Character, List<String>> processedData = new TreeMap<>();

        //Заполняем Map
        String[] words = data.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            Character firstLetter = words[i].charAt(0);
            processedData.putIfAbsent(firstLetter, new ArrayList<>());
            processedData.get(firstLetter).add(words[i]);
        }

        //Сортируем слова внутри групп
        processedData.entrySet()
                .stream()
                .forEach(e -> e.getValue().sort((String o1, String o2) -> {
                    int lengthDiff = o2.length() - o1.length();
                    return lengthDiff != 0 ? lengthDiff : o1.compareTo(o2);
                }));
        return processedData;
    }

}
