package input.request;

import java.util.*;

public class RequestStringProcessor extends RequestProcessor {


    public RequestStringProcessor(Map<String, Integer> map) {
        super(map);
    }

    @Override
    public List<Integer> processRequest(String request) {
        return findByPrefix(request);
    }

    public List<Integer> findByPrefix(String prefix) {
        int start = lowerBound(sortedKeys, prefix);

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < sortedKeys.size(); i++) {
            String key = sortedKeys.get(i);
            if (key.startsWith(prefix)) {
                result.add(map.get(key));
            } else {
                break;
            }
        }
        return result;
    }


}
