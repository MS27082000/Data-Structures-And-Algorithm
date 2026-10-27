/** Reverse Vowels of a String (LC 345). */
public class ReverseVowels {

    // Two pointers: swap vowels from both ends. O(n) time, O(n) space for the char array
    static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !isVowel(arr[left])) left++;
            while (left < right && !isVowel(arr[right])) right--;
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
        return new String(arr);
    }

    static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));     // holle
        System.out.println(reverseVowels("leetcode"));  // leotcede
        System.out.println(reverseVowels("aA"));        // Aa
        System.out.println(reverseVowels("xyz"));       // xyz
    }
}
