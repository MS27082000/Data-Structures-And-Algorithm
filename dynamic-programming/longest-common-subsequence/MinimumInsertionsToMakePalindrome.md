# Minimum Insertions to Make a String Palindrome (LC 1312)

**Problem:** Fewest characters to insert so the string becomes a palindrome.

**Intuition:** Keep the longest palindromic subsequence untouched; every other character needs a mirror inserted. Answer = `n - LPS`. (Minimum **deletions** to make a palindrome is the same number.)

**Brute force:** Try all insertion positions.
**Optimised:** O(n^2) time, O(n) space.

**Edge cases:** Already a palindrome -> 0. All distinct -> n-1.

**Interview traps**
- Same value for insertions and deletions - explain the symmetry.
- Do not confuse with minimum cuts.

**How to explain:** "Characters outside the longest palindromic subsequence are unmatched, and each needs one inserted partner."
