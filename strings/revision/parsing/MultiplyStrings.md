# Multiply Strings (LC 43)

**Problem:** Multiply two non-negative integers given as strings, without converting them to numbers.

**Approach:** The product has at most `n + m` digits. Use an `int[n + m]`. Multiplying digit `i` of `num1` by digit `j` of `num2` adds to position `i + j + 1` (the ones place), and the carry goes to `i + j`. Skip leading zeros when building the result.

**Complexity:** Time O(n · m), Space O(n + m).

**Edge cases:** Either number is `"0"` → `"0"`; leading zeros in the result array.

**Interview traps:** Add the existing `res[i + j + 1]` into `prod` before splitting into digit and carry.

**Pattern:** Long multiplication by hand, with an array indexed by digit position.
