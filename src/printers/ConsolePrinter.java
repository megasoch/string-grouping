package printers;

import java.util.*;

/**
 * Реализация вывода(консоль)
 */
public class ConsolePrinter implements DataPrinter {
    @Override
    public void print(Object object) {
        Map<Character, List<String>> data = (TreeMap<Character, List<String>>) object;
        List<String> letterGroups = new ArrayList<>();
        data.entrySet().forEach(e -> {
            // Проверяем что в группе больше одного элемента
            if (e.getValue().size() > 1) {
                String group = e.getKey() + "=[" + String.join(", ", e.getValue()) + "]";
                letterGroups.add(group);
            }
        });
        System.out.println("[" + String.join(", ", letterGroups) + "]");
    }
}
