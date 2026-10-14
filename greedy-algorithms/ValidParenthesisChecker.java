/** Valid Parenthesis String (LC 678): '*' can be '(' , ')' or empty. Is the string valid? */
public class ValidParenthesisChecker {

    // Track the RANGE [lo, hi] of possible open-bracket counts. '(' => both +1, ')' => both -1, '*' => lo-1, hi+1.
    // hi < 0 means too many ')' even if every '*' were '('; lo never drops below 0. O(n) time, O(1) space
    static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                lo--;
                hi--;
            } else {                                   // '*'
                lo--;
                hi++;
            }
            if (hi < 0) return false;                  // an unmatched ')' that no '*' can fix
            lo = Math.max(lo, 0);                      // we can't have fewer than 0 open brackets
        }
        return lo == 0;                                // zero opens must be a possible outcome
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));          // true
        System.out.println(checkValidString("(*)"));         // true
        System.out.println(checkValidString("(*))"));        // true
        System.out.println(checkValidString("(()"));         // false
        System.out.println(checkValidString(")("));          // false
        System.out.println(checkValidString("*"));           // true
        System.out.println(checkValidString("(((**"));       // false
        System.out.println(checkValidString("(((**)))"));    // true (both '*' treated as empty)
        System.out.println(checkValidString(""));            // true
    }
}
