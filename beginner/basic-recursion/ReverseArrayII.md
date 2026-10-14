# Reverse an Array (Recursive)

**Problem:** Reverse an array using recursion.

**Intuition:** Swap arr[l] and arr[r], then recurse on (l+1, r-1).

**Approach / complexity:** O(n) time, O(n) stack, in place.

**Edge cases:** Empty array, one element.

**Interview traps**
- Base case l >= r.

**How to explain:** "Swap the ends and reverse the middle."
