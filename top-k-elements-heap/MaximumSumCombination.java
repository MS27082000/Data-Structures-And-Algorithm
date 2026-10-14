import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/** Maximum Sum Combination: given two arrays A and B of size n, return the K largest sums A[i] + B[j] (i, j independent), in descending order */
public class MaximumSumCombination {

    // Sort both arrays DESCENDING: the largest sum is (0, 0). From (i, j) the next candidates are (i+1, j) and (i, j+1).
    // A max-heap holds the frontier; a visited set avoids pushing a pair twice. O(n log n + K log K) time, O(K) space
    static List<Integer> topKSums(int[] a, int[] b, int k) {
        int n = a.length;
        int[] x = a.clone(), y = b.clone();
        Arrays.sort(x);
        Arrays.sort(y);
        reverse(x);
        reverse(y);
        PriorityQueue<int[]> heap = new PriorityQueue<>((p, q) -> Integer.compare(q[0], p[0]));   // {sum, i, j}, max first
        Set<Long> seen = new HashSet<>();
        heap.offer(new int[]{x[0] + y[0], 0, 0});
        seen.add(0L);
        List<Integer> result = new ArrayList<>();
        while (result.size() < k && !heap.isEmpty()) {
            int[] top = heap.poll();
            result.add(top[0]);
            int i = top[1], j = top[2];
            if (i + 1 < n && seen.add((long) (i + 1) * n + j)) heap.offer(new int[]{x[i + 1] + y[j], i + 1, j});
            if (j + 1 < n && seen.add((long) i * n + j + 1)) heap.offer(new int[]{x[i] + y[j + 1], i, j + 1});
        }
        return result;
    }

    private static void reverse(int[] a) {
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
    }

    // Brute force for verification: all n^2 sums, sorted, top K. O(n^2 log n)
    static List<Integer> brute(int[] a, int[] b, int k) {
        List<Integer> all = new ArrayList<>();
        for (int p : a) for (int q : b) all.add(p + q);
        all.sort((u, v) -> Integer.compare(v, u));
        return all.subList(0, Math.min(k, all.size()));
    }

    public static void main(String[] args) {
        System.out.println(topKSums(new int[]{3, 2}, new int[]{1, 4}, 2));                       // [7, 6]
        System.out.println(topKSums(new int[]{1, 4, 2, 3}, new int[]{2, 5, 1, 6}, 4));           // [10, 9, 9, 8]
        System.out.println(topKSums(new int[]{5}, new int[]{7}, 1));                              // [12]
        System.out.println(topKSums(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 9).equals(brute(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 9)));   // true
        System.out.println(topKSums(new int[]{-1, -5, 3}, new int[]{4, -2, 0}, 5).equals(brute(new int[]{-1, -5, 3}, new int[]{4, -2, 0}, 5)));  // true
    }
}
