/** Roman to Integer (LC 13) */
public class RomanToInteger {

    private static int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Bad roman digit: " + c);
        }
    }

    // If a symbol is smaller than the next one, subtract it (IV = 4), otherwise add. O(n) time, O(1) space
    static int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = value(s.charAt(i));
            if (i + 1 < s.length() && cur < value(s.charAt(i + 1))) total -= cur;
            else total += cur;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));        // 3
        System.out.println(romanToInt("LVIII"));      // 58
        System.out.println(romanToInt("MCMXCIV"));    // 1994
        System.out.println(romanToInt("IV"));         // 4
        System.out.println(romanToInt("MMMCMXCIX"));  // 3999
    }
}
