# Check if a String is a Palindrome (Recursive)

**Problem:** Check palindrome-ness recursively.

**Intuition:** If the two end characters differ it is not a palindrome; otherwise check the inside.

**Approach / complexity:** O(n) time, O(n) stack.

**Edge cases:** Empty string, single character.

**Interview traps**
- Base case l >= r returns true.
- Pass indices rather than substrings.

**How to explain:** "Compare the ends, then recurse inwards."
