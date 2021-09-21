package search;

import java.util.*;

public class NoneSearchStrategy extends SearchStrategy {
    @Override
    List<String> search(String query, Map<String, List<Integer>> invertIndex, List<String> data) {
        Set<Integer> indexSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String word : Arrays.asList(query.split(" "))) {
           if (invertIndex.containsKey(word.toLowerCase(Locale.ROOT))) {
               indexSet.addAll(invertIndex.get(word));
           }
       }
        for (int i = 0; i < data.size(); i++) {
           if (!indexSet.contains(i)) {
                result.add(data.get(i));
           }
        }
        return result;
    }
}
