/** Count and Say (LC 38): term 1 = "1"; each next term describes the previous one by runs ("21" -> one 2, one 1 -> "1211") */
public class CountAndSay {

    // Build term by term, run-length encoding the previous term. O(total length of all terms) time and space; lengths grow ~30% per term
    static String countAndSay(int n) {
        String cur = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
            while (j < cur.length()) {
                char d = cur.charAt(j);
                int k = j;
                while (k < cur.length() && cur.charAt(k) == d) k++;       // end of the run
                next.append(k - j).append(d);                             // count then digit
                j = k;
            }
            cur = next.toString();
        }
        return cur;
    }

    // Recursive definition, same result
    static String countAndSayRec(int n) {
        if (n == 1) return "1";
        String prev = countAndSayRec(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= prev.length(); i++) {
            if (i < prev.length() && prev.charAt(i) == prev.charAt(i - 1)) count++;
            else { sb.append(count).append(prev.charAt(i - 1)); count = 1; }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) System.out.println(i + " -> " + countAndSay(i));
        // 1 -> 1 | 2 -> 11 | 3 -> 21 | 4 -> 1211 | 5 -> 111221 | 6 -> 312211
        System.out.println(countAndSayRec(4));                  // 1211
        System.out.println(countAndSay(10));                    // 13211311123113112211
        System.out.println(countAndSay(30).length());           // 4462
    }
}
