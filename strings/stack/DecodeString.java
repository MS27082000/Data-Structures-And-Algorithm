import java.util.*;

/** Decode String (LC 394): k[encoded] means encoded repeated k times. */
public class DecodeString {

    // Two stacks: counts and the string built before each '['. O(output) time and space
    static String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> prev = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(k);
                prev.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder tmp = prev.pop();
                int times = counts.pop();
                for (int i = 0; i < times; i++) tmp.append(cur);
                cur = tmp;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));    // aaabcbc
        System.out.println(decodeString("3[a2[c]]"));     // accaccacc
        System.out.println(decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println(decodeString("10[a]"));        // aaaaaaaaaa
    }
}
