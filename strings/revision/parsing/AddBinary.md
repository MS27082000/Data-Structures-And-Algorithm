# Add Binary (LC 67)

**Problem:** Add two binary strings and return the sum as a binary string.

**Approach:** Two pointers from the right ends plus a `carry`. Each step: `sum = carry + bitA + bitB`, append `sum % 2`, new `carry = sum / 2`. Reverse at the end.

**Complexity:** Time O(max(n, m)), Space O(max(n, m)).

**Edge cases:** Different lengths; final carry (`"1" + "1"` → `"10"`); `"0" + "0"`.

**Interview traps:** The loop must also run while `carry > 0`. Don't convert to `int` (strings can be very long).

**Pattern:** "add numbers stored as strings / lists" → right-to-left with a carry. Same shape as Add Two Numbers (linked list).
