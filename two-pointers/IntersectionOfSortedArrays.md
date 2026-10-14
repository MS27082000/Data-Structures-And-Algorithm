# Intersection of Two Sorted Arrays (LC 350 style)

**Problem:** Return the common elements of two sorted arrays. Duplicates appear as many times as they appear in **both** (min of the counts).

**Brute force:** For each element of `a`, search `b` (with a visited marker) → O(n·m).
**Better:** HashMap of counts → O(n+m) time, O(min(n,m)) space. Good when the arrays are **unsorted**.
**Optimal for sorted input:** Two pointers → O(n+m) time, O(1) extra space.

**Steps:** `a[i] < b[j]` → `i++`; `a[i] > b[j]` → `j++`; equal → add, `i++`, `j++`.

**Intuition:** Sortedness means the smaller front element can never match anything later in the other array, so it is safe to skip.

**Complexity:** Time O(n+m), Space O(1) extra.

**Edge cases:** No common elements, one empty array, heavy duplicates (`[1,1,1]` and `[1,1]` → `[1,1]`).

**Interview traps**
- Clarify whether the result should be **distinct** or keep multiplicity. For distinct, skip repeats when adding.
- Follow-ups (LC 350): if one array is much smaller, use a hashmap on the smaller; if arrays are on disk, use sorted merge or chunking.
- Move **both** pointers on a match.

**How to explain:** "Two pointers walk both sorted arrays. I advance whichever is smaller, and when they match I record it and advance both."
