import java.util.Arrays;

/**
 * Find the Repeating and Missing Number.
 * The array has size n and should hold 1..n, but one number appears TWICE and one number is MISSING.
 *
 * Let x = repeating number, y = missing number.
 *   (actual sum)     - (expected sum)     = x - y
 *   (actual squares) - (expected squares) = x^2 - y^2 = (x - y)(x + y)
 * Divide the second by the first to get x + y. Then solve for x and y.
 */
public class FindRepeatingAndMissing {

    // MAIN APPROACH: sum and sum of squares. Time O(n), space O(1).
    static int[] findTwoElement(int[] arr) {
        long n = arr.length;

        // sums if the array were perfect (1..n)
        long expected = n * (n + 1) / 2;
        long expectedSquares = n * (n + 1) * (2 * n + 1) / 6;

        // sums of the actual array
        long actual = 0;
        long actualSquares = 0;
        for (int x : arr) {
            actual += x;
            actualSquares += (long) x * x;          // long, because squares overflow int
        }

        long diff = actual - expected;                  // x - y
        long squaresDiff = actualSquares - expectedSquares; // x^2 - y^2
        long sum = squaresDiff / diff;                  // x + y

        long repeating = (sum + diff) / 2;              // x
        long missing = repeating - diff;                // y

        return new int[]{(int) repeating, (int) missing};
    }

    // ANOTHER APPROACH: frequency array. Time O(n), space O(n).
    static int[] findTwoElementUsingFrequency(int[] arr) {
        int n = arr.length;
        int[] frequency = new int[n + 1];       // frequency[v] = how many times v appears (index 0 unused)

        for (int x : arr) {
            frequency[x]++;
        }

        int repeating = -1;
        int missing = -1;
        for (int v = 1; v <= n; v++) {
            if (frequency[v] == 2) {
                repeating = v;                  // appears twice
            } else if (frequency[v] == 0) {
                missing = v;                    // never appears
            }
        }
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[][] tests = {{3, 1, 2, 5, 3}, {4, 3, 6, 2, 1, 1}, {1, 1}, {2, 2}};
        for (int[] t : tests) {
            System.out.println(Arrays.toString(findTwoElement(t)) + "  " + Arrays.toString(findTwoElementUsingFrequency(t)));
        }
        // [3, 4] [1, 5] [1, 2] [2, 1]   (both approaches give the same result)
    }
}
