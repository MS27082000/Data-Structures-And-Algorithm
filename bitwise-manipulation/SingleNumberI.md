# Single Number I (LC 136)

**Problem:** Every element appears **twice** except one. Find the single one in O(n) time and O(1) extra space.

**Brute force:** Count each element with nested loops → O(n²).
**Better:** `HashMap`/`HashSet` of counts → O(n) time, O(n) space. Or sort and compare neighbours → O(n log n).
**Optimal:** **XOR all elements** → O(n) time, O(1) space.

**Intuition:** `x ^ x = 0`, `x ^ 0 = x`, and XOR is commutative and associative. So all pairs cancel regardless of order and only the single number remains.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** One element, negatives, zero as the single number, the single element at any position.

**Interview traps**
- This only works for **"appears twice"** (even counts). For "three times" see Single Number II.
- The HashSet solution is a fine first answer, but the question's whole point is the O(1) space XOR.
- Don't use sum tricks (`2*sum(set) - sum(all)`). That needs extra space and can overflow.

**How to explain:** "XOR is its own inverse, so XOR-ing the whole array cancels every pair and leaves the unique number."
