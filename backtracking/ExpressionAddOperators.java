import java.util.ArrayList;
import java.util.List;

/** Expression Add Operators (LC 282): insert +, -, * between digits so the expression evaluates to target */
public class ExpressionAddOperators {

    // Backtracking that tracks the running value AND the last multiplied operand (to undo it for '*' precedence).
    // O(4^n * n) time, O(n) stack
    static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, target, 0, 0L, 0L, "", res);
        return res;
    }

    private static void dfs(String num, long target, int pos, long eval, long last, String expr, List<String> res) {
        if (pos == num.length()) {
            if (eval == target) res.add(expr);
            return;
        }
        for (int end = pos; end < num.length(); end++) {
            if (end > pos && num.charAt(pos) == '0') break;           // no operands with leading zeros ("05")
            long cur = Long.parseLong(num.substring(pos, end + 1));
            String part = num.substring(pos, end + 1);
            if (pos == 0) {
                dfs(num, target, end + 1, cur, cur, part, res);       // first operand: no operator before it
            } else {
                dfs(num, target, end + 1, eval + cur, cur, expr + "+" + part, res);
                dfs(num, target, end + 1, eval - cur, -cur, expr + "-" + part, res);
                // '*': undo the last term, then add last * cur (multiplication binds tighter)
                dfs(num, target, end + 1, eval - last + last * cur, last * cur, expr + "*" + part, res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(addOperators("123", 6));        // [1+2+3, 1*2*3]
        System.out.println(addOperators("232", 8));        // [2+3*2, 2*3+2]
        System.out.println(addOperators("105", 5));        // [1*0+5, 10-5]
        System.out.println(addOperators("00", 0));         // [0+0, 0-0, 0*0]
        System.out.println(addOperators("3456237490", 9191)); // []
    }
}
