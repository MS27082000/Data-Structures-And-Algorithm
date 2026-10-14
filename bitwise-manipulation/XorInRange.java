/** XOR of numbers in a given range [L, R], and XOR from 1 to N */
public class XorInRange {

    // XOR of 1..n follows a pattern with period 4: n%4==0 -> n, 1 -> 1, 2 -> n+1, 3 -> 0. O(1)
    static int xorUpTo(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }

    // XOR of L..R = (XOR of 1..R) ^ (XOR of 1..L-1): the common prefix cancels. O(1)
    static int xorInRange(int l, int r) {
        return xorUpTo(r) ^ xorUpTo(l - 1);
    }

    // Brute force for verification. O(R - L)
    static int xorBrute(int l, int r) {
        int x = 0;
        for (int i = l; i <= r; i++) x ^= i;
        return x;
    }

    public static void main(String[] args) {
        System.out.println(xorUpTo(1) + " " + xorUpTo(2) + " " + xorUpTo(3) + " " + xorUpTo(4));   // 1 3 0 4
        System.out.println(xorInRange(3, 5));                      // 2   (3 ^ 4 ^ 5)
        System.out.println(xorInRange(4, 8));                      // 8   (4 ^ 5 ^ 6 ^ 7 ^ 8)
        System.out.println(xorInRange(1, 1));                      // 1
        System.out.println(xorInRange(7, 7));                      // 7
        boolean ok = true;                                         // cross-check every small range against brute force
        for (int l = 1; l <= 60 && ok; l++)
            for (int r = l; r <= 60; r++)
                if (xorInRange(l, r) != xorBrute(l, r)) { ok = false; break; }
        System.out.println(ok);                                    // true
    }
}
