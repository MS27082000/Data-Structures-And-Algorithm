import java.util.ArrayDeque;
import java.util.Deque;

/** Minimum Number of Bracket Reversals to make an expression of '{' and '}' balanced (-1 if impossible) */
public class MinimumBracketReversals {

    // Odd length can never be balanced. Cancel matched pairs with a stack (or counters); what remains is "}}}...{{{" : a closes and b opens.
    // Every two closes need one flip, every two opens need one flip; if both a and b are odd, one extra flip.
    // Answer = ceil(a / 2) + ceil(b / 2). O(n) time, O(1) space with counters
    static int countReversals(String s) {
        int n = s.length();
        if (n % 2 != 0) return -1;
        int open = 0, close = 0;                       // open = unmatched '{', close = unmatched '}'
        for (char c : s.toCharArray()) {
            if (c == '{') open++;
            else if (open > 0) open--;                 // this '}' matches an earlier '{'
            else close++;                              // nothing to match: unmatched '}'
        }
        return (close + 1) / 2 + (open + 1) / 2;
    }

    // The same with an explicit stack (easier to explain first)
    static int countReversalsStack(String s) {
        if (s.length() % 2 != 0) return -1;
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '}' && !st.isEmpty() && st.peek() == '{') st.pop();
            else st.push(c);
        }
        int open = 0, close = 0;
        while (!st.isEmpty()) {
            if (st.pop() == '{') open++; else close++;
        }
        return (close + 1) / 2 + (open + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(countReversals("}{{}}{{{") + " " + countReversalsStack("}{{}}{{{"));   // 3
        System.out.println(countReversals("}}}}{{") + " " + countReversalsStack("}}}}{{"));       // 3  (4 unmatched closes -> 2 flips, 2 unmatched opens -> 1 flip)
        System.out.println(countReversals("{{"));                  // 1
        System.out.println(countReversals("{{{{"));                // 2
        System.out.println(countReversals("{{{"));                 // -1
        System.out.println(countReversals("}{"));                  // 2
        System.out.println(countReversals("{}{}"));                // 0
        System.out.println(countReversals(""));                    // 0
    }
}
