# First Unique Character in a String (LC 387)

**Problem:** Return the index of the first character that appears exactly once, or -1.

**Approach:** Two passes. First pass counts every letter. Second pass walks the string in order and returns the first index whose count is 1.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** No unique character → -1; single character → 0.

**Interview traps:** Do the second pass over the **string**, not over the count array, or you lose the original order.

**Pattern:** "first / earliest with a property" → count first, then scan in original order.
