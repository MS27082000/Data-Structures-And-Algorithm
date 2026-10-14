# Longest Happy Prefix (LC 1392)

**Problem:** Longest non-empty **proper** prefix of s that is also a suffix of s. Return an empty string if none.

**Intuition:** This is exactly the definition of the KMP LPS value for the whole string: answer length = `lps[n-1]`.

**Brute force:** Try lengths from n-1 down to 1 and compare the prefix with the suffix, O(n^2).
**Optimised:** Build the LPS array, O(n) time and space. (Rolling hash is another O(n) way.)

**Edge cases:** Single character -> empty. No border (`abcd`) -> empty. All same letters (`aaaa` -> `aaa`). The prefix and suffix may overlap (`ababab` -> `abab`).

**Interview traps**
- "Proper" means the whole string is not allowed.
- Overlap is allowed.
- Return the substring, not just the length.

**How to explain:** "The longest border of a string is the last entry of its failure array, so I build it once and read the final value."
