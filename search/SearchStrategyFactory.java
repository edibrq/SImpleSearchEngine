package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchStrategyFactory {
   private SearchStrategyFactory() { }

    public static SearchStrategy buildStrategy(String query) {
        switch (query) {
            case "ALL":
                return new AllSearchStrategy();
            case "ANY":
                return new AnySearchStrategy();
            case "NONE":
                return new NoneSearchStrategy();
            default:
                return new SearchStrategy() {
                    @Override
                    List<String> search(String query, Map<String, List<Integer>> invertedIndex, List<String> data) {
                        return new ArrayList<>();
                    }
                };
        }
    }
}
