public class ArraySearch {

    public static void main(String[] args) {
        int nums[] = new int[10000];
        for (int i = 0; i < 10000; i++)
            nums[i] = i + 1;
        for (int target = 10000; target >= 0; target--) {
            int linearSearchresult = linearSearch(nums, target);
            if (linearSearchresult != -1)
                System.out.println("Element found at index: " + linearSearchresult);
            else
                System.out.println("Element not found!");
            int binarySearchresult = binarySearch(nums, target);
            if (binarySearchresult != -1)
                System.out.println("Element found at index: " + binarySearchresult + "\n\n");
            else
                System.out.println("Element not found!\n\n");
        }
    }

    public static int linearSearch(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++, count++)
            if (nums[i] == target) {
                System.out.println("In Linear Search\nAfter " + count + " Iterations");
                return i;
            }
        System.out.println("In Linear Search\nAfter " + count + " Iterations");
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid,
                count = 0;

        while (start < end) {
            mid = (start + end) / 2;
            count++;
            if (nums[mid] == target || count > 10000) {
                System.out.println("In Binary Search\nAfter " + count + " Iterations");
                return mid;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        System.out.println("In Binary Search\nAfter " + count + " Iterations");
        return -1;
    }
}