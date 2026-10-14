# Single Element in a Sorted Array (LC 540)

**Problem:** Sorted array where every element appears exactly twice except one. Find it in O(log n) time and O(1) space.

**Brute force:** Scan comparing neighbours → O(n). Or XOR of everything → O(n).
**Optimal:** Binary search using **index parity**.

**Observation:** Before the single element, pairs start at **even** indices `(0,1), (2,3)…`. After it, they start at **odd** indices. So at an even `mid`: if `a[mid] == a[mid+1]` the pairing is intact, so the single is to the right. Otherwise it's at `mid` or to the left.

**Steps:** Make `mid` even (`if mid is odd, mid--`). If `a[mid] == a[mid+1]` → `low = mid + 2`; else `high = mid`. Return `a[low]`.

**Intuition:** The single element shifts every following pair by one position, flipping the parity of pair starts.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Single element array, single at the first or last index, length 3.

**Interview traps**
- Force `mid` even first, so the comparison is always with `mid + 1`.
- `low = mid + 2`, not `mid + 1` (skip the whole pair).
- `mid + 1` never goes out of range, since the array length is odd and `mid` stays below `high`.
- XOR gives O(n), so say why binary search is needed here.

**How to explain:** "Pairs start on even indices before the odd one out and on odd indices after it. I check the parity of the pair at mid to decide which side holds the single."
