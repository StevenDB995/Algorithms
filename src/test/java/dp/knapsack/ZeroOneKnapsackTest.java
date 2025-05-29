package dp.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroOneKnapsackTest {

    @Test
    void testSimpleCase() {
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        int cap = 5;
        int expected = 22;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testAllItemsFit() {
        int[] weights = {1, 2, 3};
        int[] values = {10, 20, 30};
        int cap = 10;
        int expected = 60;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testOnlyOneItemFits() {
        int[] weights = {5, 6, 1};
        int[] values = {10, 20, 50};
        int cap = 1;
        int expected = 50;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testZeroCapacity() {
        int[] weights = {1, 2, 3};
        int[] values = {5, 10, 15};
        int cap = 0;
        int expected = 0;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testExactFit() {
        int[] weights = {5, 4, 6};
        int[] values = {10, 40, 30};
        int cap = 9;
        int expected = 50;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testGreedyFails() {
        int[] weights = {3, 2, 2};
        int[] values = {20, 14, 16};
        int cap = 4;
        int expected = 30;
        // Best greedy = 20 (w=3) + 0 = 20
        // Best DP = 14+16 = 30 (w=2+2)
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testDuplicateItems() {
        int[] weights = {1, 1, 1, 1};
        int[] values = {10, 10, 10, 10};
        int cap = 2;
        int expected = 20;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testHighValueHeavyItemIgnored() {
        int[] weights = {1, 3, 5};
        int[] values = {10, 20, 1000};
        int cap = 4;
        int expected = 30;
        // Best is 1+3 = 10+20 = 30
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testSingleItem() {
        int[] weights = {7};
        int[] values = {42};
        int cap = 10;
        int expected = 42;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

    @Test
    void testSingleItemTooHeavy() {
        int[] weights = {15};
        int[] values = {100};
        int cap = 10;
        int expected = 0;
        assertEquals(expected, ZeroOneKnapsack.knapsack(weights, values, cap));
        assertEquals(expected, ZeroOneKnapsack.knapsack_1D(weights, values, cap));
    }

}
