import java.util.ArrayDeque;
import java.util.Deque;

/** Balanced Parentheses / Valid Parentheses (LC 20): brackets ()[]{} must close in the correct order */
public class BalancedParentheses {

    // Push openers; on a closer, the top must be its matching opener. O(n) time, O(n) space
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;               // closer with nothing to match
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) return false;
            }
        }
        return stack.isEmpty();                                   // leftover openers mean unbalanced
    }

    // Variant: push the EXPECTED closer instead (shorter code)
    static boolean isValidExpected(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));            // true
        System.out.println(isValid("([{}])"));            // true
        System.out.println(isValid("(]"));                // false
        System.out.println(isValid("([)]"));              // false (wrong order)
        System.out.println(isValid("(("));                // false (leftover openers)
        System.out.println(isValid("]"));                 // false (closer with an empty stack)
        System.out.println(isValid(""));                  // true
        System.out.println(isValidExpected("{[()]}"));    // true
        System.out.println(isValidExpected("{[(])}"));    // false
    }
}
