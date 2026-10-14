# Power Set

**Problem:** Return all subsets (the power set) of a set of `n` elements. There are `2ⁿ` of them.

**Approaches**
1. **Backtracking / take-not-take** (see Subsets I): O(n·2ⁿ), recursion stack O(n).
2. **Bit manipulation (this file):** every integer `mask` from `0` to `2ⁿ - 1` is a unique subset; bit `i` set means "include `a[i]`" → O(n·2ⁿ) time, no recursion.

**Intuition:** A subset is a yes/no decision per element, which is exactly an n-bit binary number. Counting 0…2ⁿ-1 enumerates all subsets once.

**Complexity:** Time O(n · 2ⁿ), Space O(n · 2ⁿ) for the output.

**Edge cases:** Empty set (`[[]]`), single element, `n` up to ~20 (2²⁰ subsets) before memory explodes.

**Interview traps**
- Use `1 << n`, with `int` for `n < 31`. Use `long` if larger (though 2ⁿ results will not fit in memory anyway).
- Don't forget the **empty** subset (mask 0). The GfG variant on strings often excludes it.
- The output order from bitmasks differs from the backtracking order. Both are valid unless the order is specified.
- This is the same as Subsets I. Mention the equivalence.

**How to explain:** "Each subset corresponds to an n-bit mask. I loop mask from 0 to 2ⁿ - 1 and include the elements whose bits are set."
