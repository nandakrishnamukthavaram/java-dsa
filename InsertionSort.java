public class InsertionSort {
    private static int noOfSwaps = 0;
    private static int noOfComparisons = 0;
    private static boolean isSorted = true;

    private static void multInsertionSort(int noOfTests, int noOfElements) {
        for (int i = 0; i < noOfTests; i++) {
            int nums[] = new int[noOfElements];
            for (int j = 0; j < noOfElements; j++)
                nums[j] = (int) (10 + Math.random() * 90);
            insertionSort(nums);
            if (!isSorted(nums))
                isSorted = false;
        }

    }

    public static void main(String[] args) {
        int noOfTests = 10;
        int noOfElements = 10;
        multInsertionSort(noOfTests, noOfElements);
        if (isSorted)
            System.out.println("All tests passed");
        else
            System.out.println("Some tests failed");
        System.out.println("Avg No of Swaps: " + (noOfSwaps / noOfTests));
        System.out.println("Avg No of Comparisons: " + (noOfComparisons / noOfTests));
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            for (int j = i; j > 0; j--) {
                noOfComparisons++;
                if (nums[j] < nums[j - 1])
                    swap(nums, j, j - 1);
            }

    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
        noOfSwaps++;
    }

    private static boolean isSorted(int[] nums) {
        boolean isSorted = true;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                isSorted = false;
        if (isSorted)
            return true;
        else
            return false;
    }
}
