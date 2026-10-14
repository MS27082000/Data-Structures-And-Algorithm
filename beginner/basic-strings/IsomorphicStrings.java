/** Isomorphic Strings (LC 205): can the characters of s be replaced (one-to-one) to get t, keeping the order? */
public class IsomorphicStrings {

    // Two maps: s->t and t->s. Both directions must stay consistent, otherwise two letters could map to the same letter.
    // Arrays of size 256 act as the maps. O(n) time, O(1) space
    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] st = new int[256], ts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (st[a] == 0 && ts[b] == 0) { st[a] = b; ts[b] = a; }        // first time we see both: bind them
            else if (st[a] != b || ts[b] != a) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));        // true
        System.out.println(isIsomorphic("foo", "bar"));        // false  (o cannot map to both a and r)
        System.out.println(isIsomorphic("paper", "title"));    // true
        System.out.println(isIsomorphic("badc", "baba"));      // false  (b and d would both map to b... needs the reverse map)
        System.out.println(isIsomorphic("ab", "aa"));          // false
        System.out.println(isIsomorphic("", ""));              // true
    }
}
