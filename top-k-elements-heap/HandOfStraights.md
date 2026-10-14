# Hand of Straights (LC 846)

**Problem:** Cards have values. Can you rearrange the whole hand into groups of exactly `groupSize` cards, where each group is `groupSize` **consecutive** values?

**Quick reject:** If `hand.length % groupSize != 0` → `false`.
**Greedy:** The **smallest remaining card must start a group** (nothing smaller is left to be its predecessor). Take it and the next `groupSize − 1` consecutive values, decrementing their counts. If any is missing → `false`. Repeat until the hand is empty.

**Data structure:** A **TreeMap** of `value → count` (sorted access to the smallest key), or a **min-heap of distinct values** plus a `HashMap` of counts → O(n log n).

**Intuition:** There is no choice. The smallest card can only be the start of a group, so greedy is forced and therefore optimal.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** `groupSize = 1` (always true), `groupSize = n`, duplicates (`[1,1,2,2,3,3]` with size 3), a gap in the values.

**Interview traps**
- The **divisibility check** first. It's quick and catches many cases.
- Use **counts**, not a list of individual cards. Remove a key when its count hits 0 so `firstKey()` stays correct.
- With the heap version, **skip a smallest value whose count is already 0** instead of removing it eagerly.
- Same problem as **Divide Array in Sets of K Consecutive Numbers** (LC 1296).

**How to explain:** "The smallest card must begin a group, so I repeatedly take the smallest card and the next consecutive values after it, using counts. If a needed value is missing, it's impossible."
