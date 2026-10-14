/** Recursion theory + "recursion with parameters" vs "functional" recursion, base case, call stack, and the stack-overflow limit */
public class RecursionBasics {

    // 1) The two ingredients: a BASE CASE (stop) and a RECURSIVE CASE that moves toward it
    static void countDown(int n) {
        if (n == 0) { System.out.println("liftoff"); return; }          // base case
        System.out.print(n + " ");
        countDown(n - 1);                                                // smaller problem
    }

    // 2) PARAMETERISED recursion: carry the answer so far in an argument and print/return it at the base case
    static int sumParam(int n, int acc) {
        if (n == 0) return acc;
        return sumParam(n - 1, acc + n);
    }

    // 3) FUNCTIONAL recursion: the answer is built on the way back up the stack
    static int sumFunctional(int n) {
        if (n == 0) return 0;
        return n + sumFunctional(n - 1);
    }

    // 4) Order of work: before the call = going down, after the call = coming back up
    static void downUp(int n) {
        if (n == 0) return;
        System.out.print("down" + n + " ");
        downUp(n - 1);
        System.out.print("up" + n + " ");
    }

    // 5) Two recursive calls => a recursion TREE (Fibonacci). Number of calls explodes: O(2^n)
    static int calls = 0;
    static int fibCalls(int n) {
        calls++;
        return n <= 1 ? n : fibCalls(n - 1) + fibCalls(n - 2);
    }

    public static void main(String[] args) {
        countDown(3);                                        // 3 2 1 liftoff
        System.out.println(sumParam(5, 0));                  // 15
        System.out.println(sumFunctional(5));                // 15
        downUp(3);                                           // down3 down2 down1 up1 up2 up3
        System.out.println();
        fibCalls(10);
        System.out.println(calls);                           // 177
        try {
            sumFunctional(1_000_000);                        // each call uses a stack frame
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError: depth is limited (~10-20 thousand frames); use a loop for deep recursion");
        }
    }
}
