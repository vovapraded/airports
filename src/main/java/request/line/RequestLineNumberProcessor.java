package request.line;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class RequestLineNumberProcessor extends RequestLineProcessor {

        public RequestLineNumberProcessor(Map<String, Integer> map) {
            super(map);
        }

        @Override
        public List<Integer> processRequest(String request) {
            return findByPrefix(request);
        }

    public List<Integer> findByPrefix(String prefix) {
        List<Pair<Double, Integer>> matches = new ArrayList<>();

        for (int i = lowerBound(sortedKeys, prefix); i < sortedKeys.size(); i++) {
            String keyString = sortedKeys.get(i);
            if (keyString.startsWith(prefix)) {
                double number = Double.parseDouble(keyString);
                matches.add(new ImmutablePair<>(number, map.get(keyString)));
            } else {
                break;
            }
        }

        return matches.stream()
                .sorted(Comparator.comparing(Pair::getKey))
                .map(Pair::getValue)
                .collect(Collectors.toList());
    }



}


