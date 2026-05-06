package main;

import java.util.Arrays;

public class UseCase17TrainConsist {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC17 - Sort Bogie Names using Arrays.sort()");
        System.out.println("==========================================\n");

        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        for (String b : bogies) {
            System.out.print(b + " | ");
        }

        Arrays.sort(bogies);

        System.out.println("\n\nSorted Bogie Names (Alphabetical):");
        for (String b : bogies) {
            System.out.print(b + " | ");
        }

        System.out.println("\n\nUC17 sorting completed...");
    }
}
