# How Many Times Has a Sorted Array Been Rotated

**Problem:** A sorted (ascending) array of distinct values was rotated right some number of times. Find that count.

**Key fact:** The rotation count equals the **index of the minimum element**. (`[4,5,6,7,0,1,2,3]` → min `0` at index 4 → rotated 4 times.)

**Brute force:** Find the minimum by scanning → O(n).
**Optimal:** Same as Find Minimum in Rotated Sorted Array, but return the **index** `low` → O(log n).

**Intuition:** Each right rotation moves the last element to the front. After `k` rotations the original first element (the minimum) sits at index `k`.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Not rotated (0), rotated `n` times (same as 0), one element, two elements.

**Interview traps**
- Return the **index**, not the value.
- With duplicates the count is ambiguous, so ask whether elements are distinct.
- Don't forget: a rotation by `n` equals no rotation, so the answer is in `[0, n-1]`.

**How to explain:** "The number of rotations is where the smallest element sits, so I binary search for the minimum's index."
