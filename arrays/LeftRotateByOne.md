# Left Rotate Array by One

**Problem:** Rotate the array left by 1: `[1,2,3,4,5]` → `[2,3,4,5,1]`.

**Brute force:** Copy into a new array shifted by one → O(n) time, O(n) space.
**Optimal:** Save `a[0]`, shift everything left by one, place the saved value at the end → O(n) time, O(1) space.

**Intuition:** Only the first element wraps around, so keep just that in a temp variable.

**Edge cases:** Length 0 or 1 (nothing to do), two elements.

**Interview traps**
- Shift in increasing index order (`a[i-1] = a[i]`). The reverse order overwrites values.
- Don't forget to store the first element **before** the loop.

**How to explain:** "Remember the first element, slide the rest one place left, put the first one at the end."
