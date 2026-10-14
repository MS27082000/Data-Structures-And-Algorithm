/** Lemonade Change (LC 860): each lemonade costs $5; customers pay 5, 10 or 20 in order. Can we always give correct change? */
public class LemonadeChange {

    // Track the number of $5 and $10 bills. For $20 prefer 10 + 5 (the 5s are more useful later). O(n), O(1)
    static boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else {                                         // bill == 20, change = 15
                if (tens > 0 && fives > 0) {                 // greedy: use the $10 first, keep the flexible $5s
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));        // true
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));       // false
        System.out.println(lemonadeChange(new int[]{10}));                     // false
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5})); // false
        System.out.println(lemonadeChange(new int[]{}));                       // true
    }
}
