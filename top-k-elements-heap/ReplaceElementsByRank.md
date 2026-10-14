# Replace Elements by Their Rank

**Problem:** Replace each element by its **rank**: the smallest value gets rank 1, the next distinct value rank 2, and so on. **Equal values share a rank.** (Also called coordinate compression.)

**Brute force:** For each element count the distinct smaller values → O(n²).
**Heap approach:** Put `(value, index)` pairs into a min-heap. Poll them in ascending order; **increase the rank only when the value changes**, and write the rank at each element's original index → O(n log n) time, O(n) space.
**Sort + map:** Sort a copy, assign ranks to distinct values in a `HashMap`, then look up every element → O(n log n).

**Intuition:** Sorted order exposes ranks directly. Remembering the original index lets the result go back to its original position.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** All equal (all rank 1), negatives, an empty array, already sorted.

**Interview traps**
- **Equal values must get the same rank**, and the next distinct value gets the next integer (no gaps), unlike "competition ranking" (1, 2, 2, 4).
- Carry the **original index** with each value, or the result can't be placed back.
- Compare values with `!=` (or `equals` for `Integer` objects), not reference equality on boxed values > 127.
- Coordinate compression is a common preprocessing step for Fenwick trees and offline queries.

**How to explain:** "I process the values in ascending order using a heap or a sort, bump the rank each time the value changes, and write the rank back to the element's original position."
