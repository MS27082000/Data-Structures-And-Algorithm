# Integer to Roman (LC 12)

**LeetCode:** [12](https://leetcode.com/problems/integer-to-roman/)

**Problem:** Convert an integer 1 to 3999 into a Roman numeral.
`1994` → `"MCMXCIV"`

**Symbols:** `I=1 V=5 X=10 L=50 C=100 D=500 M=1000`. Six subtractive forms: `IV=4 IX=9 XL=40 XC=90 CD=400 CM=900`.

**Key idea:** Greedy. Put the subtractive forms *into the table* so the loop needs no special cases. Go from the largest value to the smallest and take each symbol as many times as it fits.

**Table:** `1000 M, 900 CM, 500 D, 400 CD, 100 C, 90 XC, 50 L, 40 XL, 10 X, 9 IX, 5 V, 4 IV, 1 I`

**Dry run (`1994`):**
| value | takes | remaining | output |
|---|---|---|---|
| 1000 | 1 | 994 | M |
| 900 | 1 | 94 | MCM |
| 90 | 1 | 4 | MCMXC |
| 4 | 1 | 0 | MCMXCIV |

**Complexity:** Time O(1) (the output is bounded). Space O(1).

**Edge cases:** `4`, `9`, `40`, `90`, `400`, `900`; the max `3999` → `MMMCMXCIX`.

**Interview traps:** If the table has no `IV`, `IX`..., you output `IIII` or `VIIII`.

**Pattern:** Reverse of [Roman to Integer](../RomanToInteger.md). "Convert with a value table" → greedy from the biggest.
