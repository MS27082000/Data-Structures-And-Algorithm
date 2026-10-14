import java.util.ArrayList;
import java.util.List;

/** Generate all Binary Strings of length n without consecutive 1s */
public class BinaryStringsNoConsecutiveOnes {

    // At each position: '0' is always allowed; '1' only if the previous char is not '1'. O(n * F(n)) where F is Fibonacci-like
    static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        build(n, new StringBuilder(), result);
        return result;
    }

    private static void build(int n, StringBuilder cur, List<String> result) {
        if (cur.length() == n) {
            result.add(cur.toString());
            return;
        }
        cur.append('0');
        build(n, cur, result);
        cur.deleteCharAt(cur.length() - 1);                       // backtrack
        if (cur.length() == 0 || cur.charAt(cur.length() - 1) != '1') {
            cur.append('1');
            build(n, cur, result);
            cur.deleteCharAt(cur.length() - 1);                   // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(generate(1));        // [0, 1]
        System.out.println(generate(2));        // [00, 01, 10]
        System.out.println(generate(3));        // [000, 001, 010, 100, 101]
        System.out.println(generate(4).size()); // 8
        System.out.println(generate(0));        // [] -> actually [""], the empty string (see note)
    }
}
