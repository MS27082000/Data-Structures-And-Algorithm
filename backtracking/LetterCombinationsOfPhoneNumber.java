import java.util.ArrayList;
import java.util.List;

/** Letter Combinations of a Phone Number (LC 17) */
public class LetterCombinationsOfPhoneNumber {

    private static final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // One level of recursion per digit, branching on that digit's letters. O(4^n * n) time, O(n) stack
    static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;      // "" -> [] (not [""])
        build(0, digits, new StringBuilder(), res);
        return res;
    }

    private static void build(int index, String digits, StringBuilder cur, List<String> res) {
        if (index == digits.length()) {
            res.add(cur.toString());
            return;
        }
        for (char c : MAP[digits.charAt(index) - '0'].toCharArray()) {
            cur.append(c);
            build(index + 1, digits, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));        // [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(letterCombinations(""));          // []
        System.out.println(letterCombinations("2"));         // [a, b, c]
        System.out.println(letterCombinations("79").size()); // 16 (4 * 4)
    }
}
