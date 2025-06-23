package sort.quicksort;

public class KthSmallest {

    /**
     * The recursive quicksort method for finding the k-th smallest element.
     *
     * @param arr   The array for search
     * @param left  The left boundary of the interval (inclusive)
     * @param right The right boundary of the interval (inclusive)
     * @param k     0-based index
     */
    private static void quicksort(int[] arr, int left, int right, int k) {
        if (left == right) {
            return;
        }

        int pivot = QuickSort.partition(arr, left, right);
        if (k == pivot) {
            return;
        }

        if (k < pivot) {
            quicksort(arr, left, pivot - 1, k);
        } else {
            quicksort(arr, pivot + 1, right, k);
        }
    }

    /**
     * Find the k-th smallest element in an array.
     *
     * @param arr The array for search
     * @param k   1-based index
     * @return The k-th smallest element
     */
    public static int findKthSmallest(int[] arr, int k) {
        // covert the 1-based index to 0-based for simplicity
        quicksort(arr, 0, arr.length - 1, k - 1);
        return arr[k - 1];
    }

}
