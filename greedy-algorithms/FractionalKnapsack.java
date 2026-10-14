import java.util.Arrays;

/** Fractional Knapsack: items may be split. Maximise the total value that fits in capacity W */
public class FractionalKnapsack {

    // Sort items by value / weight (best ratio first), take whole items, then a fraction of the last one.
    // O(n log n) time, O(n) space
    static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Double.compare((double) values[b] / weights[b], (double) values[a] / weights[a]));

        double total = 0;
        int remaining = capacity;
        for (int idx : order) {
            if (remaining == 0) break;
            if (weights[idx] <= remaining) {
                total += values[idx];                              // take the whole item
                remaining -= weights[idx];
            } else {
                total += (double) values[idx] * remaining / weights[idx];   // take only a fraction
                remaining = 0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(fractionalKnapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));   // 240.0
        System.out.println(fractionalKnapsack(new int[]{500}, new int[]{30}, 10));                   // 166.66666666666666
        System.out.println(fractionalKnapsack(new int[]{10, 20}, new int[]{5, 5}, 100));             // 30.0 (everything fits)
        System.out.println(fractionalKnapsack(new int[]{10, 20}, new int[]{5, 5}, 0));               // 0.0
        System.out.println(fractionalKnapsack(new int[]{100, 60}, new int[]{20, 10}, 25));           // 135.0
    }
}
