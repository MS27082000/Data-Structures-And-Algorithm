# Multiply Strings (LC 43)

**Problem:** Multiply two non-negative integers given as strings. Do not convert them to numbers.
`("123", "456")` → `"56088"`

**Key idea:** Do long multiplication by hand, but with a digit array. A number with `n` digits times one with `m` digits has at most `n + m` digits, so use `int[n + m]`.

**Position rule:** digit `i` of `num1` × digit `j` of `num2` affects two cells:
- `i + j + 1` → the ones digit of the product (add to what is already there)
- `i + j` → the carry

**Dry run (`"12" × "34"`, array size 4):**
| i (num1) | j (num2) | product + res[i+j+1] | res after |
|---|---|---|---|
| 1 (2) | 1 (4) | 8 | [0,0,0,8] |
| 1 (2) | 0 (3) | 6 + 0 | [0,0,6,8] |
| 0 (1) | 1 (4) | 4 + 6 = 10 | [0,1,0,8] |
| 0 (1) | 0 (3) | 3 + 1 = 4 | [0,4,0,8] |
Remove leading zero → `"408"`.

**Complexity:** Time O(n · m). Space O(n + m).

**Edge cases:** Either input `"0"` → `"0"` (check first); result array has leading zeros to skip.

**Interview traps**
- Add the existing `res[i + j + 1]` before splitting into digit and carry.
- Go **right to left** on both strings.
- Do not use `Integer.parseInt` or `BigInteger`; that is the whole point of the question.

**Pattern:** "arithmetic on big numbers" → digit array with position rules.
