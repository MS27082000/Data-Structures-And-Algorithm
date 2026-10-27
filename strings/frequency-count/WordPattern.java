import java.util.*;

/** Word Pattern (LC 290): does s follow the same pattern as the letters in pattern? (bijection) */
public class WordPattern {

    // Map each pattern char to a word, and each word to a pattern char. O(n) time and space
    static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(w)) return false;
            if (wordToChar.containsKey(w) && wordToChar.get(w) != c) return false;
            charToWord.put(c, w);
            wordToChar.put(w, c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));  // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println(wordPattern("abba", "dog dog dog dog"));  // false
    }
}
