/** Integer to Roman (LC 12). */
public class IntegerToRoman {

    // Greedy: take the biggest symbol (including 900, 400, 90, 40, 9, 4) that fits. O(1) time
    static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));  // MMMDCCXLIX
        System.out.println(intToRoman(58));    // LVIII
        System.out.println(intToRoman(1994));  // MCMXCIV
        System.out.println(intToRoman(4));     // IV
    }
}
