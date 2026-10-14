import java.util.ArrayList;
import java.util.List;

/** Generate Parentheses (LC 22): all well-formed strings with n pairs */
public class GenerateParentheses {

    // Add '(' while open < n; add ')' only while close < open. Result count = Catalan number. O(4^n / sqrt(n))
    static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private static void build(int n, int open, int close, StringBuilder cur, List<String> res) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }
        if (open < n) {
            cur.append('(');
            build(n, open + 1, close, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {                      // never close more than we've opened
            cur.append(')');
            build(n, open, close + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));            // [()]
        System.out.println(generateParenthesis(2));            // [(()), ()()]
        System.out.println(generateParenthesis(3));            // [((())), (()()), (())(), ()(()), ()()()]
        System.out.println(generateParenthesis(4).size());     // 14
    }
}
