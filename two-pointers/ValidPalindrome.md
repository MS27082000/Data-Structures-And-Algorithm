# Valid Palindrome (LC 125)

**Problem:** Ignoring case and non-alphanumeric characters, is the string a palindrome?

**Brute force:** Build a cleaned lowercase string, reverse it, compare → O(n) time, **O(n) space**.

**Approach:** Two pointers from both ends. Skip characters that aren't letters/digits, then compare lowercased characters. Mismatch → false.

**Intuition:** A palindrome mirrors around its centre, so compare outside-in. Skipping junk on the fly removes the need for a cleaned copy → O(1) space.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty or only-symbol string (`" "`, `".,"`) → `true`; digits and letters mixed (`"0P"` → false); uppercase vs lowercase.

**Interview traps**
- Use `Character.isLetterOrDigit`, not just `isLetter`, or digits are dropped.
- Keep `left < right` inside the inner skip loops, or you go out of bounds on all-symbol strings.
- Compare `toLowerCase` on both sides.

**How to explain:** "Two pointers moving inward, skipping non-alphanumerics, comparing case-insensitively. No extra string, so O(1) space."
