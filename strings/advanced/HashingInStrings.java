/** Hashing in Strings (theory): polynomial rolling hash, O(1) substring hash after O(n) preprocessing, and the collision issue */
public class HashingInStrings {

    static final long MOD = 1_000_000_007L;
    static final long BASE = 131;                          // a prime-ish base larger than the alphabet size

    // prefix[i] = hash of s[0..i); pow[i] = BASE^i. hash(s[l..r)) = prefix[r] - prefix[l] * pow[r - l]   (mod MOD)
    static long[] prefix(String s) {
        long[] p = new long[s.length() + 1];
        for (int i = 0; i < s.length(); i++) p[i + 1] = (p[i] * BASE + s.charAt(i)) % MOD;
        return p;
    }

    static long[] powers(int n) {
        long[] pw = new long[n + 1];
        pw[0] = 1;
        for (int i = 1; i <= n; i++) pw[i] = pw[i - 1] * BASE % MOD;
        return pw;
    }

    static long substringHash(long[] prefix, long[] pw, int l, int r) {          // [l, r)
        return ((prefix[r] - prefix[l] * pw[r - l]) % MOD + MOD) % MOD;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        long[] p = prefix(s), pw = powers(s.length());
        // "abra" appears at 0 and 7: equal substrings have equal hashes
        System.out.println(substringHash(p, pw, 0, 4) == substringHash(p, pw, 7, 11));    // true
        System.out.println(substringHash(p, pw, 0, 4) == substringHash(p, pw, 1, 5));      // false  ("abra" vs "brac")
        // hash of a whole string equals prefix[n]
        System.out.println(substringHash(p, pw, 0, s.length()) == p[s.length()]);          // true
        // palindrome check with hashes: compare hash(s) with hash(reverse(s))
        String t = "racecar", rt = new StringBuilder(t).reverse().toString();
        System.out.println(prefix(t)[t.length()] == prefix(rt)[rt.length()]);              // true
        System.out.println(prefix("abc")[3] == prefix("acb")[3]);                          // false (order matters in a polynomial hash)
    }
}
