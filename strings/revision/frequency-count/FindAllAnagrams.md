# Find All Anagrams in a String (LC 438)

**Problem:** Return all start indices of substrings of `s` that are anagrams of `p`.

**Brute force:** Check every substring of length `|p|` with an anagram check → O(n · k).

**Approach:** Fixed-size sliding window of length `|p|`. Keep one 26-array: start with `+1` for each letter in `p`; subtract for the letter entering the window, add back for the letter leaving. All zeros means anagram.

**Complexity:** Time O(26 · n) ≈ O(n), Space O(1).

**Edge cases:** `s` shorter than `p` → empty list; overlapping matches (`"abab"`, `"ab"` → 0,1,2).

**Interview traps**
- Only check once the window is full (`i >= k - 1`).
- Drop the left char at `i - k`, not `i - k + 1`.

**Pattern:** "anagram inside a longer string" → fixed window + frequency array. Same idea as Permutation in String.
