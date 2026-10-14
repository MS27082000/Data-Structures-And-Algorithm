# Fruit Into Baskets (LC 904)

**Problem:** Trees in a row with fruit types. You have **two baskets**, each holding one type (unlimited quantity). Starting anywhere, pick one fruit from each tree moving right; you stop when a tree's fruit doesn't fit. Maximise the fruit picked.

**Rephrased:** The **longest subarray with at most 2 distinct values**.

**Brute force:** Every start, extend while ≤ 2 types → O(n²).
**Optimal:** Sliding window with a frequency map. Add `fruits[right]`; while the map has more than 2 keys, remove from the left (**delete the key when its count hits 0**) → O(n), O(1) (at most 3 keys).

**Intuition:** It's "Longest Substring with At Most K Distinct Characters" with `K = 2`. Recognising the disguised problem is the whole question.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Single tree, only one type, exactly two types (whole array), empty array.

**Interview traps**
- **Remove the key from the map at count 0**, or `size()` overcounts the distinct types.
- Start by restating the problem in plain terms: "longest subarray with at most two distinct values."
- Fixed 2 baskets can use two variables, but a map generalises to K.

**How to explain:** "I keep a window with at most two fruit types. When a third type enters, I shrink from the left until only two remain, tracking the longest window."
