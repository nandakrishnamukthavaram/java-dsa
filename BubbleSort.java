class Sort {
    public static void run() {
        int[] numbs = new int[100];
        for (int i = 0; i < 100; i++)
            numbs[i] = (int) (Math.random() * 100);
        System.out.println("Bubble sort");
        System.out.println("Before Sorting:");
        for (int i : numbs)
            System.out.print(i + " ");
        System.out.println("\nAfter Sorting:");
        bubbleSort(numbs);
        for (int i : numbs)
            System.out.print(i + " ");
        System.out.println("\nNo of Comparisions: " + noOfComparisions);
        System.out.println("No of Swaps: " + noOfSwaps);
    }

    static int noOfComparisions = 0;
    static int noOfSwaps = 0;

    private static void bubbleSort(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length - i - 1; j++) {
                if (numbs[j] > numbs[j + 1] || (noOfComparisions++ < -100)) {
                    numbs[j] = numbs[j] ^ numbs[j + 1];
                    numbs[j + 1] = numbs[j] ^ numbs[j + 1];
                    numbs[j] = numbs[j] ^ numbs[j + 1];
                    noOfSwaps++;
                }
            }
        }
    }
}

public class BubbleSort {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++)
            Sort.run();
        int swaps = Sort.noOfSwaps / 10000;
        int comparisions = Sort.noOfComparisions / 10000;

        System.out.println("Average Swaps: " + swaps);
        System.out.println("Average Comparisions: " + comparisions);
    }
}