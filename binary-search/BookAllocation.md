# Book Allocation Problem

**Problem:** `n` books with page counts (sorted by order on the shelf), `m` students. Allocate **contiguous** books so every student gets at least one book. Minimise the **maximum** pages any student reads.

**Brute force:** Try all ways to split into m contiguous groups → exponential (or DP O(n²·m)).
**Optimal:** **Binary search on the answer** (max pages) in `[max(pages), sum(pages)]` → O(n log sum).

**Feasibility check:** Greedily assign books to the current student until the next book would exceed the limit, then move to the next student. Feasible if students needed `<= m`.

**Intuition:** A higher limit never needs more students, which is monotonic. We want the smallest feasible limit.

**Complexity:** Time O(n log sum), Space O(1).

**Edge cases:** `m > n` → -1 (can't give every student a book), `m = 1` (sum), `m = n` (max), one book.

**Interview traps**
- Return -1 when `m > n`.
- Low bound `max(pages)`: a student must be able to take the thickest book.
- Contiguity means no reordering or skipping.
- Identical template to Painter's Partition and Split Array Largest Sum.

**How to explain:** "I binary search the maximum pages per student. I greedily simulate the allocation for a limit and see whether m students are enough."
