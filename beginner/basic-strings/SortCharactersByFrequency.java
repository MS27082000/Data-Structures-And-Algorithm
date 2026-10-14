import java.util.ArrayList;
import java.util.List;

/** Sort Characters by Frequency (LC 451): most frequent characters first (ties in any order) */
public class SortCharactersByFrequency {

    // Bucket sort: count each character, then put it in bucket[count]. Read the buckets from the highest count down. O(n) time, O(n) space
    // (a max-heap on counts also works in O(n log k))
    static String frequencySort(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) count[c]++;
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) buckets.add(new ArrayList<>());
        for (int c = 0; c < 256; c++) if (count[c] > 0) buckets.get(count[c]).add((char) c);
        StringBuilder sb = new StringBuilder();
        for (int f = s.length(); f >= 1; f--) {
            for (char c : buckets.get(f)) for (int k = 0; k < f; k++) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));         // eert   ("eetr" is also accepted)
        System.out.println(frequencySort("cccaaa"));       // aaaccc ("cccaaa" is also accepted)
        System.out.println(frequencySort("Aabb"));         // bbAa   (case-sensitive: 'A' and 'a' differ)
        System.out.println(frequencySort("a"));            // a
        System.out.println("[" + frequencySort("") + "]"); // []
    }
}
