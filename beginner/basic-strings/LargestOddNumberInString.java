/** Largest Odd Number in a String (LC 1903): the largest-valued odd number that is a substring of the digit string ("" if none) */
public class LargestOddNumberInString {

    // A number is odd iff its LAST digit is odd. The longest prefix ending at the rightmost odd digit is the largest odd substring.
    // Scan from the right. O(n) time, O(1) space
    static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (((num.charAt(i) - '0') & 1) == 1) return num.substring(0, i + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));         // 5
        System.out.println("[" + largestOddNumber("4206") + "]");   // []
        System.out.println(largestOddNumber("35427"));      // 35427
        System.out.println(largestOddNumber("2468135"));     // 2468135
        System.out.println(largestOddNumber("8420"));        // (empty)  - prints a blank line
        System.out.println(largestOddNumber("1000"));        // 1
    }
}
