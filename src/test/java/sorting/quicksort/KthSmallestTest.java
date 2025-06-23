package sorting.quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestTest {

    private void assertCorrect(int[] arr, int k) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int expected = arr[k - 1];
        int actual = KthSmallest.findKthSmallest(arrCopy, k);
        assertEquals(expected, actual);
    }

    @Test
    void testSortedArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        assertCorrect(arr, 4);
        assertCorrect(arr, 1);
        assertCorrect(arr, arr.length);
    }

    @Test
    void testReverseArray() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        assertCorrect(arr, 4);
        assertCorrect(arr, 1);
        assertCorrect(arr, arr.length);
    }

    @Test
    void testRandomArray() {
        int[] arr = new int[]{4, 2, 7, 1, 9, 3};
        assertCorrect(arr, 3);
        assertCorrect(arr, 1);
        assertCorrect(arr, arr.length);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = new int[]{5, 1, 3, 3, 2, 5};
        assertCorrect(arr, 4);
        assertCorrect(arr, 1);
        assertCorrect(arr, arr.length);
    }

    @Test
    void testSingleElement() {
        int[] arr = new int[]{42};
        assertCorrect(arr, 1);
    }

    @Test
    void testLargeRandomArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() - 0.5) * 10000);
        }
        assertCorrect(arr, 699);
        assertCorrect(arr, 1);
        assertCorrect(arr, arr.length);
    }

}
