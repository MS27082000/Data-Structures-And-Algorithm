import java.util.Arrays;

/** Candy (LC 135): each child needs at least 1 candy; a child with a higher rating than a neighbour must get more
 *  candy than that neighbour. Minimise the total. */
public class Candy {

    // Two passes: left-to-right enforces "more than the left neighbour", right-to-left enforces "more than the right".
    // Take the max of both. O(n) time, O(n) space
    static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        int total = 0;
        for (int c : candies) total += c;
        return total;
    }

    // O(1)-space version: walk up/down slopes. Peak counts as part of the longer of its two slopes
    static int candyConstantSpace(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int total = 1, up = 0, down = 0, peak = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                total += 1 + up;
            } else if (ratings[i] == ratings[i - 1]) {
                up = down = peak = 0;
                total += 1;
            } else {
                up = 0;
                down++;
                total += 1 + down;
                if (peak >= down) total--;               // the peak already has enough candy for this slope
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));                       // 5
        System.out.println(candy(new int[]{1, 2, 2}));                       // 4
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));                 // 7
        System.out.println(candy(new int[]{5}));                             // 1
        System.out.println(candy(new int[]{3, 3, 3}));                       // 3
        System.out.println(candy(new int[]{5, 4, 3, 2, 1}));                 // 15
        System.out.println(candyConstantSpace(new int[]{1, 3, 2, 2, 1}));    // 7
        System.out.println(candyConstantSpace(new int[]{1, 0, 2}));          // 5
        System.out.println(candyConstantSpace(new int[]{5, 4, 3, 2, 1}));    // 15
    }
}
