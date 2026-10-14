# Count Occurrences in a Sorted Array

**Problem:** Count how many times `x` appears in a sorted array.

**Brute force:** Scan and count → O(n).
**Optimal:** `count = upperBound(x) - lowerBound(x)` → O(log n).

**Intuition:** Lower bound is the start of the block of `x`s and upper bound is one past its end. The difference is the block's length. If `x` is absent they coincide, so the count is 0 automatically.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** `x` absent (0), all elements equal `x`, empty array, `x` only once.

**Interview traps**
- No special "not found" check needed. The difference handles it.
- Don't find one occurrence and walk outward. That's O(n) worst case.
- Equivalent: `last - first + 1` from First and Last Occurrence (with a not-found guard).

**How to explain:** "Two binary searches give the start and end of the block of equal values. The count is the difference."
