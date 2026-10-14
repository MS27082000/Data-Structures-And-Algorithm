/** Square Root of a Number (LC 69): floor of sqrt(x), without using sqrt() */
public class SquareRoot {

    // Binary search on the answer in [0, x]; compare mid with x / mid to avoid overflow. O(log x), O(1)
    static int mySqrt(int x) {
        if (x < 2) return x;
        int low = 1, high = x / 2, ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {          // mid*mid <= x, without overflow
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));              // 2
        System.out.println(mySqrt(8));              // 2
        System.out.println(mySqrt(0));              // 0
        System.out.println(mySqrt(1));              // 1
        System.out.println(mySqrt(2147395599));     // 46339
        System.out.println(mySqrt(Integer.MAX_VALUE)); // 46340
    }
}
