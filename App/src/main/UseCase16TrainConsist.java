package main;

public class UseCase16TrainConsist {

    static int[] bubbleSort(int[] arr) {

        int[] a = arr.clone(); // original array safe rahe

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j] > a[j + 1]) {
                    // swap
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("==========================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        int[] sorted = bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : sorted) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }
}
