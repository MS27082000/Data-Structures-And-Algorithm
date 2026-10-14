# Target Sum (LC 494)

**Problem:** Put + or - before each number. Count expressions that equal `target`.

**Intuition:** Let P = numbers with +, N = numbers with -. `P - N = target`, `P + N = total` -> `P = (total + target) / 2`. Count subsets with sum P.

**Brute force:** 2^n sign combinations (DFS).
**Optimised:** O(n * P) time, O(P) space.

**Edge cases:** `|target| > total`, odd `(total + target)` -> 0. Zeros: each zero can take + or -, doubling the count.

**Interview traps**
- Negative targets work the same way (symmetry).
- Check parity and range first.

**How to explain:** "The signs split numbers into a plus group and a minus group; their sums give one equation for the plus group, which is a subset count."
