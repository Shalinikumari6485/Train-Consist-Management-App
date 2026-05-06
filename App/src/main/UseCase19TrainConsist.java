package main;

import java.util.Arrays;

public class UseCase19TrainConsist {

    static boolean binarySearch(String[] arr, String key) {

        if (arr.length == 0) return false;

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int result = arr[mid].compareTo(key);

            if (result == 0) {
                return true;
            }
            else if (result < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("==========================================\n");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchId = "BG309";

        System.out.println("Searching for Bogie ID: " + searchId);

        boolean found = binarySearch(bogieIds, searchId);

        System.out.println("Bogie Found: " + found);

        System.out.println("\nUC19 searching completed...");
    }
}
