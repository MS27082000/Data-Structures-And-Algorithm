import java.util.*;

/** Minimum Remove to Make Valid Parentheses (LC 1249). */
public class MinRemoveToMakeValid {

    // Stack of indices of unmatched '('; mark unmatched ')' directly. O(n) time, O(n) space
    static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                if (stack.isEmpty()) sb.setCharAt(i, '*');   // unmatched ')'
                else stack.pop();
            }
        }
        while (!stack.isEmpty()) sb.setCharAt(stack.pop(), '*'); // unmatched '('

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') res.append(sb.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)")); // lee(t(c)o)de
        System.out.println(minRemoveToMakeValid("a)b(c)d"));       // ab(c)d
        System.out.println(minRemoveToMakeValid("))(("));          // (empty)
    }
}
