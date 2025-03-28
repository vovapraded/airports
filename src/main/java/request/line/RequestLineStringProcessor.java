package request.line;

import java.util.*;

public class RequestLineStringProcessor extends RequestLineProcessor {


    public RequestLineStringProcessor(Map<String, Integer> map) {
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
