# The Celebrity Problem

**Problem:** In a party of `n` people, `M[i][j] = 1` means person `i` knows person `j`. A **celebrity** is known by everyone else and knows nobody. Find the celebrity, or return -1.

**Brute force:** For every person check their row (knows nobody) and column (known by all) → O(n²).
**Stack approach:** Push everyone. Pop two, `a` and `b`: if `a` knows `b`, `a` can't be the celebrity (discard `a`, keep `b`); otherwise discard `b`. Continue until one is left, then verify → O(n) comparisons.
**Optimal (two pointers, O(1) space):** `a = 0`, `b = n−1`. If `M[a][b] == 1` → `a++`, else `b--`. After `n − 1` comparisons one candidate remains. **Verify it** in O(n).

**Intuition:** One question about a pair always eliminates exactly one person: if `a` knows `b`, `a` isn't a celebrity; if `a` doesn't know `b`, `b` isn't one (everyone must know the celebrity).

**Complexity:** Time O(n) (about 3n matrix lookups), Space O(1).

**Edge cases:** Nobody is a celebrity (-1), everyone knows each other, `n = 1` (that person is trivially the celebrity), two people who know each other.

**Interview traps**
- **The verification pass is mandatory.** The elimination gives *a* candidate, not a guarantee.
- Skip the candidate's own cell (`M[i][i]` is 0 or ignored).
- Verify both directions: the candidate knows nobody (`M[c][i] == 0`) and everybody knows them (`M[i][c] == 1`).
- At most one celebrity can exist.

**How to explain:** "Comparing any two people eliminates one of them as a celebrity, so n − 1 comparisons leave one candidate. I then check that this person knows nobody and is known by everyone."
