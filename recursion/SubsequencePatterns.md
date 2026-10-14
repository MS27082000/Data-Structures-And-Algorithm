# Learn All Patterns of Subsequences (Theory)

A **subsequence** keeps the original order but may skip elements (not necessarily contiguous). An array of `n` elements has **2ⁿ** subsequences.

## The core pattern: Take / Not Take
At each index make two recursive calls:
1. **Take** `a[index]` (add it to the current list), recurse on `index + 1`.
2. **Not take**, recurse on `index + 1`.
At `index == n` you have made a decision for every element, so the current list is one subsequence.

```
f(index, current):
    if index == n: record current; return
    add a[index]; f(index+1)      // take
    remove a[index]; f(index+1)   // not take (after undoing the take)
```

## Variants built from this one pattern
| Goal | Change |
|---|---|
| Print all subsequences | Record at the base case |
| Subsequences with sum K | Track `remaining`, check at the base case |
| **Exists** such a subsequence | Make the function return `boolean`, stop at the first `true` |
| **Count** such subsequences | Make the function return `int`, add the two branches |
| Only one answer | Return as soon as one is found |

**Complexity:** Time O(n · 2ⁿ) (copying each result), Space O(n) recursion stack.

**Interview traps**
- **Copy** the list when recording (`new ArrayList<>(current)`). Otherwise all results end up empty.
- **Undo** the take before the not-take branch (backtracking).
- Order of the output depends on whether you take first or not-take first.
- With duplicates in the input and "unique" results, sort and skip duplicates (Subsets II).
- If you need only a count and the sums are small, memoise (index, remaining) to get DP.

**How to explain:** "For every element I either pick it or skip it, which forms a binary recursion tree of depth n with 2ⁿ leaves. Each leaf is one subsequence."
