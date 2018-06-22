import data.DataProvider;
import data.HardcodedDataProvider;
import printers.ConsolePrinter;
import printers.DataPrinter;
import processors.DataProcessor;
import processors.MapDataProcessor;

/**
 * Класс приложения
 */
public class Application {
    public void run() {
        DataProvider provider = new HardcodedDataProvider();
        DataProcessor processor = new MapDataProcessor();
        DataPrinter printer = new ConsolePrinter();
        printer.print(processor.processData(provider.getData()));
    }
}
