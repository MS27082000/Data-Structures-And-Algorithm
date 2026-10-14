# Valid Palindrome II (LC 680)

**Problem:** Can the string become a palindrome after deleting **at most one** character?

**Brute force:** Try deleting each character and check palindrome → O(n²) time.

**Approach:** Two pointers inward. On the first mismatch, we must delete one of the two characters: check `s[left+1..right]` or `s[left..right-1]`. If either is a palindrome → true.

**Intuition:** Until the first mismatch nothing needs fixing. At the mismatch the deletion must be `s[left]` or `s[right]`, so only 2 options, each checked in O(n). Total stays linear.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Already a palindrome; length 1; mismatch at the very ends (`"abca"`); `"deeee"` where deleting the *right* side is needed (so trying only one side is wrong).

**Interview traps**
- You must try **both** sides, not just one.
- Only one deletion is allowed, so don't recurse again after the helper check. The helper is a plain palindrome check.

**How to explain:** "I walk inward; at the first mismatch I branch into skip-left or skip-right and run a normal palindrome check on the rest. Only one branch point, so O(n)."
