# Check if the Array is Sorted

**Problem:** Is the array non-decreasing?

**Intuition:** It is sorted exactly when no neighbouring pair is out of order.

**Approach / complexity:** O(n) time, O(1) space; stop at the first descent.

**Edge cases:** Empty and single-element arrays are sorted. Equal neighbours are allowed.

**Interview traps**
- Use arr[i] < arr[i-1] as the failure test so duplicates pass.
- Clarify ascending versus descending.

**How to explain:** "I compare each element with the previous one and fail on the first decrease."
