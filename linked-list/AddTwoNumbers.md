# Add Two Numbers (LC 2)

**Problem:** Two non-negative numbers stored as linked lists with digits in **reverse order** (units digit first). Return their sum as a list in the same format.

**Brute force:** Convert both lists to integers, add, convert back. Fails for long lists (overflow beyond `long`).
**Optimal:** Add digit by digit like school addition, carrying over → O(max(m, n)) time.

**Approach:** Loop `while (l1 != null || l2 != null || carry != 0)`: `sum = carry + l1.val + l2.val` (use 0 for a missing list). Append `sum % 10`, set `carry = sum / 10`.

**Intuition:** Reverse order is a gift. The units digits are at the heads, which is the order in which addition proceeds.

**Complexity:** Time O(max(m, n)), Space O(1) extra (the result list is output).

**Edge cases:** Different lengths, a final carry (`5 + 5 = 10` → `0->1`), both `0`, long inputs (`9999 + 99`).

**Interview traps**
- Include **`|| carry != 0`** in the loop condition so a final carry creates a new node.
- A dummy head avoids a special case for the first node.
- If the digits were in **forward** order (Add Two Numbers II, LC 445) use stacks or reverse both lists first.
- Don't convert to integers (overflow).

**How to explain:** "I add the two lists digit by digit with a carry, creating a node for each result digit, and keep going while either list or a carry remains."
