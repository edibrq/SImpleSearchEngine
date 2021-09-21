package search;

import java.util.*;

public class AnySearchStrategy extends SearchStrategy {
    @Override
    List<String> search(String query, Map<String, List<Integer>> invertIndex, List<String> data) {
        List<String> stringsSet = new ArrayList<>();

        for (String word : Arrays.asList(query.split(" "))) {
            if (invertIndex.containsKey(word)) {
                for (Integer index : invertIndex.get(word)) {
                    stringsSet.add(data.get(index));
                }
            }
        }
        return new ArrayList<>(stringsSet);
    }
}
