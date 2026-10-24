/**
 * Maximum Points You Can Obtain from Cards (LC 1423).
 *
 * There are n cards in a row. In one move you take the FIRST or the LAST card. You must take exactly k cards.
 * Return the maximum total points.
 *
 * Key observation:
 *   After k moves, you have taken some i cards from the FRONT and (k - i) cards from the BACK, for some i in 0..k.
 *   So there are only k + 1 possible choices:
 *       k front + 0 back,  (k-1) front + 1 back,  ...,  1 front + (k-1) back,  0 front + k back
 *   We try all of them and keep the best sum.
 *
 * Why this is a sliding window:
 *   Imagine the array as a circle (the end is next to the start). The k cards you take are one window of
 *   size k that wraps around the ends. Moving from one choice to the next slides this window by one card.
 *
 * Time O(k), space O(1).
 */
public class MaxPointsFromCards {

    // Approach 1: slide the window of size k over the ends.
    static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Choice 1: take all k cards from the FRONT.
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int maxScore = sum;

        // Move to the next choice, one step at a time: take one LESS card from the front, one MORE from the back.
        //   step i = 1: give back cardPoints[k - 1] (the last front card), take cardPoints[n - 1] (the last card)
        //   step i = 2: give back cardPoints[k - 2],                         take cardPoints[n - 2]
        //   ...
        //   step i = k: give back cardPoints[0],                             take cardPoints[n - k]
        for (int i = 1; i <= k; i++) {
            sum -= cardPoints[k - i];     // remove the front card that is no longer taken
            sum += cardPoints[n - i];     // add the next card from the back
            maxScore = Math.max(maxScore, sum);
        }
        return maxScore;
    }

    // Approach 2 (same answer, different view): the cards you do NOT take form one contiguous block in the middle,
    // of size n - k. Score = total - (sum of that block), so we want the block with the MINIMUM sum.
    // This is a classic fixed-size sliding window of size n - k.
    static int maxScoreComplement(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Step 1: total sum of all cards
        int totalSum = 0;
        for (int val : cardPoints) {
            totalSum += val;
        }

        // Edge case: taking all cards
        if (k == n) {
            return totalSum;
        }

        // Step 2: size of the middle window that stays behind
        int windowSize = n - k;

        int windowSum = 0;
        int minWindowSum = Integer.MAX_VALUE;
        int left = 0;

        // Step 3: slide the window and keep the minimum sum
        for (int right = 0; right < n; right++) {
            windowSum += cardPoints[right];                  // add the card on the right

            if (right - left + 1 == windowSize) {            // the window has reached its size
                minWindowSum = Math.min(minWindowSum, windowSum);
                windowSum -= cardPoints[left];               // drop the card on the left
                left++;
            }
        }

        // Step 4: answer
        return totalSum - minWindowSum;
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
