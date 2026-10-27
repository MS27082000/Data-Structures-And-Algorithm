# Add Binary (LC 67)

**Problem:** Add two binary strings, return the sum as a binary string.
`("1010", "1011")` → `"10101"`

**Key idea:** School addition. Start at the rightmost digits and move left, carrying as you go. Strings can be too long for `int`/`long`, so never convert.

**Per step:** `sum = carry + bitA + bitB` → write `sum % 2`, new `carry = sum / 2`.

**Dry run (`"11" + "1"`):**
| i | j | bits | sum (with carry) | write | carry |
|---|---|---|---|---|---|
| 1 | 0 | 1 + 1 | 2 | 0 | 1 |
| 0 | - | 1 + carry 1 | 2 | 0 | 1 |
| - | - | carry 1 | 1 | 1 | 0 |
Written `0, 0, 1` → reverse → `"100"`.

**Complexity:** Time O(max(n, m)). Space O(max(n, m)).

**Edge cases:** Different lengths; final carry (`"1" + "1"` → `"10"`); `"0" + "0"` → `"0"`.

**Interview traps**
- Loop condition is `i >= 0 || j >= 0 || carry > 0`. Missing `carry > 0` loses the leading 1.
- Append digits, then `reverse()` once at the end (do not insert at index 0 in a loop).

**Pattern:** "add numbers stored as strings or lists" → right to left with a carry. Same as Add Two Numbers (linked list). Swap `2` for `10` and it works for decimal.
