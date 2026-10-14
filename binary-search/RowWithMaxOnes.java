/** Find the Row with Maximum 1's: each row of the binary matrix is sorted (0s then 1s). Returns the row index (smallest on ties), -1 if no 1 exists */
public class RowWithMaxOnes {

    // In each row, lower bound of 1 gives the count of ones = cols - firstOneIndex. O(m log n), O(1)
    static int rowWithMaxOnes(int[][] m) {
        int best = -1, maxOnes = 0;
        for (int i = 0; i < m.length; i++) {
            int ones = m[i].length - firstOne(m[i]);
            if (ones > maxOnes) {                    // strict > keeps the smallest row index on ties
                maxOnes = ones;
                best = i;
            }
        }
        return best;
    }

    private static int firstOne(int[] row) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] >= 1) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(rowWithMaxOnes(new int[][]{{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}}));  // 2
        System.out.println(rowWithMaxOnes(new int[][]{{0, 0}, {0, 0}}));                                          // -1
        System.out.println(rowWithMaxOnes(new int[][]{{0, 1}, {0, 1}}));                                          // 0 (tie => smallest)
        System.out.println(rowWithMaxOnes(new int[][]{{1}}));                                                     // 0
    }
}
