package main;

public class UseCase20TrainConsist {

    static boolean searchBogie(String[] arr, String key) {

        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Bogie list is empty. Cannot perform search.");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("==========================================\n");

        String[] bogies = {"BG101","BG205","BG309"};

        String searchId = "BG205";

        try {
            boolean found = searchBogie(bogies, searchId);

            System.out.println("Searching for Bogie ID: " + searchId);
            System.out.println("Bogie Found: " + found);

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 search validation completed...");
    }
}
