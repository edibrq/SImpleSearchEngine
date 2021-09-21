package search;

import java.util.*;

public class MenuHolder {
    private ArrayList<String> data;
    private Map<String, List<Integer>> invertedIndex;
    private SearchStrategy strategy;

    private void initInvertIndex() {
        invertedIndex = new HashMap<>();
        int lineCount = 0;
        for (String str : data) {
            String[] words = str.split(" ");
            for (String word : words) {
                if (!invertedIndex.containsKey(word.toLowerCase(Locale.ROOT))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(lineCount);
                    invertedIndex.put(word.toLowerCase(Locale.ROOT), list);
                } else {
                    invertedIndex.get(word.toLowerCase(Locale.ROOT)).add(lineCount);
                }
            }
            lineCount++;
        }
    }

    public static void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private ArrayList<String> search(String query) {
        ArrayList<String> searchResult = new ArrayList<>();
        if (invertedIndex.containsKey(query)) {
            List<Integer> lines = invertedIndex.get(query);
            for (int index : lines) {
                searchResult.add(data.get(index));
            }
        }
        return searchResult;
    }

    public void printAllPeople() {
        System.out.println("=== List of people ===");
        data.stream().forEach(System.out::println);
        System.out.println();
    }

    public void findPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        List<String> searchResult = strategy.search(query, invertedIndex, data);
        if (!searchResult.isEmpty()) {
            for (String result : searchResult) {
                System.out.println(result);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    public MenuHolder(ArrayList<String> data) {
        this.data = data;
        initInvertIndex();
        System.out.println(invertedIndex);
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }
}
