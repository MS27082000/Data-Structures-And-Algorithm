import java.util.*;

/** Group Anagrams (LC 49): group strings that are anagrams of each other. */
public class GroupAnagrams {

    // Sorted string is the same for all anagrams, so use it as the map key. O(n * k log k)
    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            map.computeIfAbsent(new String(arr), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Faster key: 26 letter counts joined as a string. O(n * k)
    static List<List<String>> groupAnagramsCount(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;
            StringBuilder key = new StringBuilder();
            for (int c : count) key.append(c).append('#');
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(in));       // [[eat, tea, ate], [bat], [tan, nat]] (order may vary)
        System.out.println(groupAnagramsCount(in));
        System.out.println(groupAnagrams(new String[]{""}));  // [[]]
    }
}
