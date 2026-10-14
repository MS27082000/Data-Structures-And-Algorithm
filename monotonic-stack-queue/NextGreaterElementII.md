# Next Greater Element II (LC 503)

**Problem:** A **circular** array: after the last element comes the first again. For each element find the next greater element, searching circularly. `-1` if none.

**Brute force:** For each index scan up to `n − 1` elements circularly → O(n²).
**Optimal:** Same monotonic stack as Next Greater Element, but **traverse the array twice** (indices `2n − 1` down to `0`, using `i % n`) to simulate the wrap-around. Record answers only for the real indices `i < n` → O(n) time, O(n) space.

**Intuition:** Doubling the array (conceptually) lets every element see the elements that come before it as "to its right". The stack, built from the right, already contains candidates from the wrapped part when we reach the real elements.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** All equal (all -1), the maximum element (always -1), a single element, descending array (`[5,4,3,2,1]` → `[-1,5,5,5,5]`).

**Interview traps**
- Use **`i % n`**, not an actual copy of the array (saves memory).
- Pop with `<=` so equal values don't count as greater.
- Fill `res[i]` **only when `i < n`**.
- The maximum has no greater element even after wrapping, so it stays -1.

**How to explain:** "I run the right-to-left next-greater scan over the array twice, as if it were doubled. The second pass preloads the stack with the wrapped-around elements, so each element finds its circular answer."
