# Next Smaller Element

**Problem:** For each element find the first **strictly smaller** element to its **right**. Output `-1` if none.

**Brute force:** For each index scan right → O(n²).
**Optimal:** Monotonic stack, mirror image of Next Greater Element. Scan **right to left**: pop while `stack.top >= a[i]` (those can't be the answer for `a[i]` or anything to its left), then the top (if any) is the answer; push `a[i]` → O(n).

**Intuition:** The stack holds candidates in increasing order from bottom to top. A candidate larger than or equal to a newer element is useless forever, so discard it.

**Related variants (same skeleton):**
| Variant | Scan direction | Pop condition |
|---|---|---|
| Next greater | right → left | `top <= a[i]` |
| Next smaller | right → left | `top >= a[i]` |
| Previous smaller | left → right | `top >= a[i]` |
| Previous greater | left → right | `top <= a[i]` |

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Increasing array (all -1), equal values (not "smaller"), decreasing array (each answer is its right neighbour), single element.

**Interview traps**
- **Strictness:** equal values must not count. Pop on `>=`.
- Decide whether the stack stores **values** or **indices**. Use indices if you need positions or widths (histogram, subarray problems).
- This and "previous smaller" are the building blocks for Largest Rectangle and Sum of Subarray Minimums.

**How to explain:** "I scan from the right and keep a stack of candidate smaller values. Anything not smaller than the current element is discarded, and what's left on top is the next smaller element."
