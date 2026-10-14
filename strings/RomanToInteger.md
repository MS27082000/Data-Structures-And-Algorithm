# Roman to Integer (LC 13)

**Problem:** Convert a Roman numeral (`I V X L C D M`) to an integer (1 to 3999).

**Brute force:** Handle the six subtractive pairs (`IV, IX, XL, XC, CD, CM`) with explicit string matching → O(n), but verbose.
**Optimal:** Map each symbol to its value and scan left to right: if the **current is smaller than the next**, subtract it; otherwise add it → O(n) time, O(1) space.

**Intuition:** Subtractive notation places a smaller symbol before a larger one (`IV` = 5 - 1). So a symbol that is smaller than its right neighbour contributes negatively.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `"IV"`, `"IX"`, `"MCMXCIV"` (1994), `"MMMCMXCIX"` (3999), a single symbol.

**Interview traps**
- Guard `i + 1 < n` before reading the next symbol.
- Alternative: scan **right to left**, subtracting when the current value is less than the previous one. Be ready to explain it.
- Follow-up: Integer to Roman (greedy with a value table, largest first).

**How to explain:** "Add the value of each symbol, except when it is smaller than the next symbol, in which case I subtract it. That handles IV, IX, XL and so on."
