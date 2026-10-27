# Palindromic Substrings (LC 647)

**Problem:** Count how many substrings of `s` are palindromes.

**Approach:** Expand around every centre. There are `2n - 1` centres: each character (odd length) and each gap between characters (even length). Each successful expansion is one palindrome.

**Complexity:** Time O(n²), Space O(1).

**Edge cases:** All same characters (`"aaa"` → 6); single character.

**Interview traps:** Forgetting the even-length centres. Count every expansion step, not just the final one.

**Pattern:** "palindromic substring" → expand around centre. Same as Longest Palindromic Substring (in `strings/`), but count instead of track the max.
