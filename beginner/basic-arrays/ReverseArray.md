# Reverse an Array

**Problem:** Reverse the array in place.

**Intuition:** Swap the first and last elements and move inwards.

**Approach / complexity:** Two pointers: O(n) time, O(1) space.

**Edge cases:** Empty, one element, even and odd lengths.

**Interview traps**
- Loop while l < r, not l <= r.
- Allocating a second array breaks the O(1) space goal.

**How to explain:** "Two pointers swap from the ends until they meet in the middle."
