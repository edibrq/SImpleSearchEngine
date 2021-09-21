package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> dataset = new ArrayList<>();
        if (args[0].equals("--data") && args[1] != null) {
            File file = new File(args[1]);
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (scanner.hasNext()) {
                dataset.add(scanner.nextLine());
            }
        } else {
            System.out.println("Nothing to read");
        }

        Scanner scanner = new Scanner(System.in); //save it please
        MenuHolder holder = new MenuHolder(dataset);
        while (true) {
            MenuHolder.showMenu();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String query = scanner.nextLine();
                    holder.setStrategy(SearchStrategyFactory.buildStrategy(query));
                    holder.findPerson();
                    break;
                case 2:
                    holder.printAllPeople();
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }

    }
}
