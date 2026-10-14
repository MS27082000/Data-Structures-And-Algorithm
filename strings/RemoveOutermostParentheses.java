/** Remove Outermost Parentheses (LC 1021): remove the outer pair of every primitive valid group */
public class RemoveOutermostParentheses {

    // Track depth: skip '(' that opens at depth 0 and ')' that closes back to depth 0. O(n) time, O(n) output
    static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) sb.append(c);     // not an outermost '('
                depth++;
            } else {
                depth--;
                if (depth > 0) sb.append(c);     // not an outermost ')'
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));            // ()()()
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));    // ()()()()(())
        System.out.println(removeOuterParentheses("()()"));                  // (empty)
        System.out.println(removeOuterParentheses("((()))"));                // (())
    }
}
