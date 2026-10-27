# Integer to Roman (LC 12)

**Problem:** Convert an integer (1 to 3999) to a Roman numeral.

**Approach:** Greedy with a table that already includes the subtractive pairs `CM, CD, XC, XL, IX, IV`. Go from the biggest value to the smallest and append the symbol while the number is at least that value.

**Complexity:** Time O(1) (bounded output), Space O(1).

**Edge cases:** 4, 9, 40, 90, 400, 900; 3999 is the max.

**Interview traps:** Missing the subtractive pairs in the table gives `IIII` instead of `IV`.

**Pattern:** Reverse of [Roman to Integer](../../RomanToInteger.md).
