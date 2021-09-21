package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class SearchStrategy {
   abstract List<String> search(String query, Map<String, List<Integer>> invertIndex, List<String> data);
}
