# Single Number III (LC 260)

**Problem:** Every element appears **twice** except **two** elements that appear once. Find those two, in O(n) time and O(1) extra space.

**Brute force / better:** `HashMap` counts → O(n) time, O(n) space.
**Optimal:**
1. XOR everything: `xor = a ^ b` (pairs cancel).
2. `a != b`, so `xor` has at least one set bit. Take the **lowest set bit**: `diff = xor & -xor`. At this position `a` and `b` have **different** bits.
3. Split all numbers into two groups by whether `(x & diff) != 0`. XOR each group separately.
4. Each group contains one unique number plus complete pairs, so each group's XOR is one answer.

**Intuition:** Pairs always land in the same group (equal numbers have equal bits), while the two unique numbers are forced into different groups by the differing bit. The problem reduces to two copies of Single Number I.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Negative numbers, `0` as one of the answers, `Integer.MIN_VALUE` (`xor & -xor` still works), exactly two elements.

**Interview traps**
- Any set bit of `xor` works. `xor & -xor` is the cheapest to get.
- The two answers can come out in **either order**.
- Don't compare `== 1`: use `!= 0` for the mask test.
- Know the progression: Single Number I → II → III.

**How to explain:** "XOR of all numbers is a ^ b. I pick a bit where a and b differ, split the array by that bit, and XOR within each group. Each group's XOR is one of the two numbers."
