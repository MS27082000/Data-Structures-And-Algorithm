/** String to Integer (atoi) (LC 8) */
public class StringToInteger {

    // 1) skip leading spaces  2) optional sign  3) read digits  4) stop at first non-digit  5) clamp to int range
    // O(n) time, O(1) space
    static int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // overflow check BEFORE multiplying: result * 10 + digit must stay <= Integer.MAX_VALUE
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));                    // 42
        System.out.println(myAtoi("   -042"));               // -42
        System.out.println(myAtoi("1337c0d3"));              // 1337
        System.out.println(myAtoi("0-1"));                   // 0
        System.out.println(myAtoi("words and 987"));         // 0
        System.out.println(myAtoi("-91283472332"));          // -2147483648
        System.out.println(myAtoi("2147483648"));            // 2147483647
        System.out.println(myAtoi("-2147483648"));           // -2147483648
        System.out.println(myAtoi(""));                      // 0
        System.out.println(myAtoi("+-12"));                  // 0
    }
}
