# Letter Combinations of a Phone Number (LC 17)

**Problem:** Digits `2-9` map to letters on a phone keypad (`2→abc … 9→wxyz`). Return all letter combinations the digit string could represent.

**Brute force:** Nested loops, one per digit. Impossible when the length is unknown.
**Optimal:** **Backtracking**, one recursion level per digit; at each level loop over that digit's letters.

**Intuition:** The answer is the Cartesian product of the letter sets. Recursion depth = number of digits, branching = 3 or 4 letters.

**Complexity:** Time O(4ⁿ · n) worst case (digits 7 and 9 have 4 letters), Space O(n) stack.

**Edge cases:** Empty input (return `[]`, **not** `[""]`), a single digit, repeated digits, `7` and `9` (4 letters).

**Interview traps**
- **Empty digits → empty list.** Easy to miss.
- Store the mapping in an array indexed by digit (`MAP[digit]`), not a switch.
- Undo each append for the next letter (`deleteCharAt`).
- Iterative alternative: a queue (BFS) that extends each partial string.

**How to explain:** "Each digit contributes a choice among its letters. I recurse digit by digit, trying each letter, and record a string once I've used every digit."
