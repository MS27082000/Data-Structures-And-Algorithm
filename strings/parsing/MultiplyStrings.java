/** Multiply Strings (LC 43): multiply two non-negative numbers given as strings. */
public class MultiplyStrings {

    // digit i of num1 * digit j of num2 lands at positions i + j and i + j + 1. O(n * m) time, O(n + m) space
    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length(), m = num2.length();
        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j + 1];
                res[i + j + 1] = prod % 10;
                res[i + j] += prod / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d : res) {
            if (sb.length() == 0 && d == 0) continue; // skip leading zeros
            sb.append(d);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));        // 6
        System.out.println(multiply("123", "456"));    // 56088
        System.out.println(multiply("0", "9999"));     // 0
        System.out.println(multiply("99", "99"));      // 9801
    }
}
