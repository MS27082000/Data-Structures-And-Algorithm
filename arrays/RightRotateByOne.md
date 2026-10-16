# Right Rotate Array by One

**Problem:** Rotate the array right by 1: `[1,2,3,4,5]` → `[5,1,2,3,4]`. (This is the GfG "Cyclically rotate an array by one" problem.)

**Brute force:** Copy into a new array shifted by one → O(n) time, O(n) space.
**Optimal:** Save `a[n-1]`, shift everything right by one, place the saved value at index 0 → O(n) time, O(1) space.

**Intuition:** Only the last element wraps around, so keep just that in a temp variable.

**Edge cases:** Length 0 or 1 (nothing to do), two elements.

**Interview traps**
- Shift in **decreasing** index order (`a[i] = a[i-1]`, `i` from `n-1` to `1`). Going forward overwrites values and fills the array with copies of one element.
- Store the last element **before** the loop.
- Left vs right: the GfG problem named "left rotate by one" in some sheets expects a right rotation. Check the expected output.

**How to explain:** "Remember the last element, slide the rest one place right starting from the back, put the last one at the front."
