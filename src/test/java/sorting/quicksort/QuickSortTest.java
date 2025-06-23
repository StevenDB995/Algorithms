package sorting.quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    private void assertSorted(int[] actual) {
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);
        QuickSort.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSortedArray() {
        assertSorted(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void testReverseArray() {
        assertSorted(new int[]{5, 4, 3, 2, 1});
    }

    @Test
    void testRandomArray() {
        assertSorted(new int[]{4, 2, 7, 1, 9, 3});
    }

    @Test
    void testArrayWithDuplicates() {
        assertSorted(new int[]{5, 1, 3, 3, 2, 5});
    }

    @Test
    void testSingleElement() {
        assertSorted(new int[]{42});
    }

    @Test
    void testEmptyArray() {
        assertSorted(new int[]{});
    }

    @Test
    void testLargeRandomArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() - 0.5) * 10000);
        }
        assertSorted(arr);
    }

}
