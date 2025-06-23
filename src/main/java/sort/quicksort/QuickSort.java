package sort.quicksort;

public class QuickSort {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * The partition method. It chooses a pivot and rearranges the array interval around it.
     * The smaller elements are moved to the left of the pivot while the larger ones are moved to its right.
     * <br/>
     * Precondition: left < right
     *
     * @param arr   The array to be partitioned
     * @param left  The left boundary of the interval (inclusive)
     * @param right The right boundary of the interval (inclusive)
     * @return The index of the pivot after partitioning
     */
    static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int i = left - 1, j;

        for (j = left; j < right; j++) {
            if (arr[j] <= pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, right);

        return i;
    }

    /**
     * The recursive quicksort method. It takes an array and an interval indicating the part of array to be sorted.
     *
     * @param arr   The array to be sorted in place
     * @param left  The left boundary of the interval (inclusive)
     * @param right The right boundary of the interval (inclusive)
     */
    private static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quicksort(arr, left, pivot - 1);
            quicksort(arr, pivot + 1, right);
        }
    }

    public static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

}
