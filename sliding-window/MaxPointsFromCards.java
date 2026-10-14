/** Maximum Points You Can Obtain from Cards (LC 1423): take exactly k cards, each from either the FRONT or the BACK */
public class MaxPointsFromCards {

    // Take i cards from the front and k - i from the back. Start with all k from the front, then move one card at a time
    // from the front to the back. This is a fixed window of size k wrapping around the ends. O(k) time, O(1) space
    static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = 0;
        for (int i = 0; i < k; i++) sum += cardPoints[i];          // all k from the front
        int best = sum;
        for (int i = 1; i <= k; i++) {
            sum += cardPoints[n - i] - cardPoints[k - i];          // add one from the back, drop one from the front
            best = Math.max(best, sum);
        }
        return best;
    }

    // Equivalent view: the cards NOT taken form a contiguous window of size n - k. Maximise the taken = total - min window
    static int maxScoreComplement(int[] cardPoints, int k) {
        int n = cardPoints.length, total = 0, window = 0, minWindow;
        for (int x : cardPoints) total += x;
        int size = n - k;
        if (size == 0) return total;
        for (int i = 0; i < size; i++) window += cardPoints[i];
        minWindow = window;
        for (int i = size; i < n; i++) {
            window += cardPoints[i] - cardPoints[i - size];
            minWindow = Math.min(minWindow, window);
        }
        return total - minWindow;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));            // 12
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));                        // 4
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));            // 55 (take all)
        System.out.println(maxScore(new int[]{100, 40, 17, 9, 73, 75}, 3));         // 248
        System.out.println(maxScoreComplement(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));  // 12
        System.out.println(maxScoreComplement(new int[]{100, 40, 17, 9, 73, 75}, 3)); // 248
    }
}
