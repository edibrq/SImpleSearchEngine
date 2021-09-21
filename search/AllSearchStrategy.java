package search;

import java.util.*;

public class AllSearchStrategy extends SearchStrategy {
    @Override
    List<String> search(String query, Map<String, List<Integer>> invertIndex, List<String> data) {
        ArrayList<String> result = new ArrayList<>();
        Set<Integer> linesWithWords = new HashSet<>();
        for (String word : Arrays.asList(query.split(" "))) {
            if (invertIndex.containsKey(word.toLowerCase(Locale.ROOT))) {
                for (Integer i : invertIndex.get(word)) {
                    linesWithWords.add(i);
                }
                //linesWithWords.addAll(invertIndex.get(word));
            } else if (invertIndex.containsKey(word)) {
                linesWithWords.addAll(invertIndex.get(word));
            }
        }
        for (Integer index : linesWithWords) {
            if (data.get(index).contains(query)) {
                result.add(data.get(index));
            }
        }
        return result;
    }
}
