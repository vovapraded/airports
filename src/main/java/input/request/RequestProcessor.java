package input.request;


import java.util.*;

public abstract class RequestProcessor {
    protected final Map<String, Integer> map;
    protected final List<String> sortedKeys;

    public RequestProcessor(Map<String, Integer> map) {
        this.map = map;
        this.sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(this.sortedKeys);
    }

    /**
     * Обрабатывает запрос и возвращает результат в виде списка значений.
     *
     * @param request строка запроса (например, префикс или диапазон)
     * @return список значений из map, подходящих под запрос
     */
    public abstract List<Integer> processRequest(String request);
    protected static int lowerBound(List<String> keys, String prefix) {
        int left = 0, right = keys.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (keys.get(mid).compareTo(prefix) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
