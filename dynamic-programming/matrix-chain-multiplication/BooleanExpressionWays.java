/** Evaluate Boolean Expression to True / Boolean Parenthesization (GfG): count the ways to parenthesise "T|F&T^F" so that it evaluates to true */
public class BooleanExpressionWays {

    static final int MOD = 1_000_000_007;

    // Interval DP over operands. For the range i..j (operand positions 0, 2, 4...) and each operator at position k between them, combine the counts
    // of true/false on both sides:
    //   &: T = lT*rT                      ^: T = lT*rF + lF*rT                 |: T = total - (lF*rF)
    // F counts follow from total ways. dp[i][j] = {ways true, ways false}. O(n^3) time, O(n^2) space (n = number of operands)
    static int countWays(String exp) {
        int n = (exp.length() + 1) / 2;
        long[][] t = new long[n][n], f = new long[n][n];
        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(2 * i);
            t[i][i] = ch == 'T' ? 1 : 0;
            f[i][i] = ch == 'F' ? 1 : 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    char op = exp.charAt(2 * k + 1);
                    long lT = t[i][k], lF = f[i][k], rT = t[k + 1][j], rF = f[k + 1][j];
                    long total = (lT + lF) % MOD * ((rT + rF) % MOD) % MOD;
                    long trueWays;
                    if (op == '&') trueWays = lT * rT % MOD;
                    else if (op == '|') trueWays = (total - lF * rF % MOD + MOD) % MOD;
                    else trueWays = (lT * rF + lF * rT) % MOD;
                    t[i][j] = (t[i][j] + trueWays) % MOD;
                    f[i][j] = (f[i][j] + total - trueWays + MOD) % MOD;
                }
            }
        }
        return (int) t[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countWays("T|T&F^T"));       // 4
        System.out.println(countWays("T^F|F"));         // 2
        System.out.println(countWays("T"));             // 1
        System.out.println(countWays("F"));             // 0
        System.out.println(countWays("T&F"));           // 0
        System.out.println(countWays("T^T^T"));         // 2
    }
}
