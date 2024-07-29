
public class SelectionSort {
    public static void main(String[] args) {
        int nums[] = new int[10];
        for (int i = 0; i < 10; i++)
            nums[i] = (int) (10 + Math.random() * 90);
        System.out.println("Before Sorting:");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
        selectionSort1(nums);
        System.out.println("After Sorting:");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
        isSorted(nums);
    }

    public static void selectionSort1(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int minNumIndex = index;
            for (int i = index; i < nums.length; i++)
                if (nums[i] < nums[minNumIndex])
                    minNumIndex = i;
            if (index != minNumIndex) {
                nums[index] = nums[minNumIndex] ^ nums[index];
                nums[minNumIndex] = nums[minNumIndex] ^ nums[index];
                nums[index] = nums[minNumIndex] ^ nums[index];
            }
        }
    }

    public static void isSorted(int[] nums) {
        boolean isSorted = true;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                isSorted = false;
        if (isSorted)
            System.out.println("Array is sorted!");
        else
            System.out.println("Array is not sorted!");
    }
}
