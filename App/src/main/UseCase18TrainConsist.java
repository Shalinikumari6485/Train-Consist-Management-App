package main;

public class UseCase18TrainConsist {

    static boolean linearSearch(String[] arr, String key) {

        for (String item : arr) {
            if (item.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("==========================================\n");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = linearSearch(bogieIds, searchId);

        System.out.println("\n\nSearching for Bogie ID: " + searchId);
        System.out.println("Bogie Found: " + found);

        System.out.println("\nUC18 searching completed...");
    }
}