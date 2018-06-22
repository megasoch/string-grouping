package processors;

import java.util.Map;

/**
 * Интерфейс обработки данных(строки)
 */
public interface DataProcessor {
    Map processData(String data);
}
