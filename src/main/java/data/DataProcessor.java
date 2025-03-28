package data;

import exception.ValidationException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для обработки CSV-файлов.
 */
public class DataProcessor {

    /**
     * Считывает CSV-файл и извлекает значения из указанного столбца.
     *
     * @param file         CSV-файл для чтения.
     * @param columnNumber Номер столбца (начиная с 1), из которого нужно извлечь данные.
     * @throws IOException              если произошла ошибка при чтении файла.
     * @throws IllegalArgumentException если указанный столбец выходит за границы строки.
     */
    public Data readCsv(File file, int columnNumber) throws IOException {
        HashMap<String, Integer> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                int lineIndex = Integer.parseInt(columns[0]);
                if (columnNumber < 1 || columnNumber > columns.length) {
                    throw new ValidationException("Invalid column number: " + columnNumber);
                }
                result.put(handleValue(columns[columnNumber - 1]), lineIndex);
            }
        }
        return new Data(result);
    }
    private String handleValue(String value) {
        return value.trim().replace("\"","");
    }
}
