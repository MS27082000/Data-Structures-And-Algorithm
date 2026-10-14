import java.util.Arrays;

/** Find the Repeating and Missing Number: array of size n holds 1..n, one number repeats, one is missing */
public class FindRepeatingAndMissing {

    // Math approach: S - n(n+1)/2 = x - y, S2 - n(n+1)(2n+1)/6 = x^2 - y^2 (x repeating, y missing)
    // Use long to avoid overflow. O(n) time, O(1) space
    static int[] findTwoElement(int[] a) {
        long n = a.length;
        long sum = n * (n + 1) / 2, sumSq = n * (n + 1) * (2 * n + 1) / 6;
        long s = 0, s2 = 0;
        for (int x : a) {
            s += x;
            s2 += (long) x * x;
        }
        long diff = s - sum;                  // x - y
        long sqDiff = s2 - sumSq;             // x^2 - y^2
        long add = sqDiff / diff;             // x + y
        long x = (diff + add) / 2;            // repeating
        long y = x - diff;                    // missing
        return new int[]{(int) x, (int) y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoElement(new int[]{3, 1, 2, 5, 3})));          // [3, 4]
        System.out.println(Arrays.toString(findTwoElement(new int[]{4, 3, 6, 2, 1, 1})));       // [1, 5]
        System.out.println(Arrays.toString(findTwoElement(new int[]{1, 1})));                   // [1, 2]
        System.out.println(Arrays.toString(findTwoElement(new int[]{2, 2})));                   // [2, 1]
    }
}
