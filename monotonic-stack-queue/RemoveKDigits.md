# Remove K Digits (LC 402)

**Problem:** Remove exactly `k` digits from a non-negative number (as a string) to make the **smallest** possible number. No leading zeros in the result (`"0"` if empty).

**Brute force:** Try all `C(n, k)` removals → exponential.
**Optimal (greedy + monotonic stack):** Scan left to right. While `k > 0`, the stack is non-empty, and the **top digit is greater than the current digit**, pop it (removing a larger digit that sits before a smaller one always makes the number smaller). Then push the current digit. After the scan, if `k > 0` remove digits from the **end**. Strip leading zeros → O(n).

**Why it's correct:** The earliest position where a digit is larger than its right neighbour is where removing helps the most, because higher place values matter more. A non-decreasing sequence can't be improved by removal except from the end.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Remove everything (`"10"`, k=2 → `"0"`), leading zeros after removal (`"10200"`, k=1 → `"200"`), already increasing (`"123456"`, k=3 → `"123"`), all equal digits (`"1111"`, k=2 → `"11"`).

**Interview traps**
- **Leftover `k`:** the stack is non-decreasing, so remove from the **end**.
- **Strip leading zeros**, and return `"0"` for an empty result.
- Compare digits as characters (`'0'..'9'` order matches numeric order).
- Don't parse into an integer. The number can have 10⁵ digits.

**How to explain:** "I build the number with a stack. Whenever the new digit is smaller than the one on top, removing the top makes the number smaller, so I pop (using up one removal). Leftover removals come off the end, and I strip leading zeros."
