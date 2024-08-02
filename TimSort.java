import java.sql.Date;

public class TimSort {
    private static final int RUN = 32;

    public static void timSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                try {
                    merge(arr, left, mid, right);
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < len2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++)
            arr[i] = (int) (10 + Math.random() * 90);
        // System.out.println("Original Array: " + Arrays.toString(arr));
        long start = new Date(0).getTime();
        timSort(arr);
        long end = new Date(0).getTime();
        System.out.println("Time Taken : " + (end - start) + "ms");
        isSorted(arr);
        // System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // mokshagna kokkula
    public static void isSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                isSorted = false;
        if (isSorted)
            System.out.println("Array is sorted!");
        else
            System.out.println("Array is not sorted!");
    }

}