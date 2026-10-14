# Longest Palindromic Substring (LC 5)

**Problem:** Return the longest palindromic substring of `s`.

**Brute force:** Check every substring → O(n³).
**Better:** DP table `dp[i][j]` = whether `s[i..j]` is a palindrome → O(n²) time, O(n²) space.
**Optimal for interviews:** **Expand around centre** → O(n²) time, O(1) space.
**Fastest:** Manacher's algorithm → O(n). Mention it; rarely required to code.

**Approach:** Every palindrome has a centre: a character (odd length) or a gap between two characters (even length). For each of the `2n - 1` centres, expand outward while characters match and keep the longest.

**Start index:** For length `len` around centre `i`: `start = i - (len - 1) / 2`.

**Intuition:** A palindrome is symmetric, so growing outward from its centre is the natural check, and it needs no extra memory.

**Complexity:** Time O(n²), Space O(1).

**Edge cases:** Single character, two equal characters (`"bb"`), no palindrome longer than 1, whole string a palindrome, multiple answers (any is accepted).

**Interview traps**
- Don't forget the **even-length** centres (`expand(i, i+1)`).
- `expand` returns `right - left - 1` (the loop overshoots by one on each side).
- Reversing the string and finding the longest common substring works but needs a check for mismatched indices.
- Don't confuse with Longest Palindromic **Subsequence** (DP).

**How to explain:** "For each possible centre, odd and even, I expand while the two sides match and track the longest. O(n²) time with no extra space."
