# Subsets I (LC 78)

**Problem:** Given an array of **distinct** integers, return all possible subsets.

**Brute force / alternatives:** Bitmask over `2ⁿ` masks (see Power Set), or the "add each element to all existing subsets" iterative method. All O(n·2ⁿ).
**Backtracking (this file):** At each call, the current `path` **is** a valid subset, so record it. Then try adding each later element, recurse, and remove it.

**Intuition:** Moving `start` forward guarantees each subset is built in one canonical order (no permutations of the same set).

**Complexity:** Time O(n · 2ⁿ), Space O(n) stack (plus the output).

**Edge cases:** Empty array (`[[]]`), single element, `n` up to 10 on LeetCode.

**Interview traps**
- **Record a copy** (`new ArrayList<>(path)`), not the reference.
- Record at **every** node, not only at the leaves.
- Recurse with `i + 1`, not `start + 1`. Otherwise you get duplicates.
- Undo with `remove(size - 1)`, not `remove(element)`, which would call the wrong overload for `List<Integer>`.

**How to explain:** "Every node in the recursion tree is a subset. I add one later element at a time, recurse, and remove it again, so all 2ⁿ subsets are visited once."
