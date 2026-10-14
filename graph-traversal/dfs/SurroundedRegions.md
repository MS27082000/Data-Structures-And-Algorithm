# Surrounded Regions (LC 130)

**Problem:** A board of `'X'` and `'O'`. Capture every region of `'O'`s that is **completely surrounded** by `'X'` (does not touch the border) by flipping it to `'X'`.

**Brute force:** For each `'O'` region check whether it touches the border → O((R·C)²) in the worst case.
**Optimal (border-first, 3 steps):**
1. From every **border `'O'`**, DFS and mark the whole connected region with a temporary letter (`'S'` = safe).
2. Remaining `'O'`s are surrounded → flip them to `'X'`.
3. Turn the `'S'` marks back into `'O'`.
→ **O(R·C)** time, O(R·C) stack.

**Intuition:** An `'O'` region survives exactly when it is connected to the border. Mark the survivors first, then everything else can be captured.

**Complexity:** Time O(R·C), Space O(R·C) recursion worst case.

**Edge cases:** All `'X'`, all `'O'` (nothing captured, all touch the border), a single cell, an `'O'` region touching the border only at a corner.

**Interview traps**
- Use a **temporary marker**, not a boolean array, so the restore pass is trivial.
- Don't start the flip pass before **all** borders are processed.
- **Diagonal** `'O'`s are not connected.
- Same idea as [Number of Enclaves](NumberOfEnclaves.md).

**How to explain:** "I first protect every 'O' region connected to the border by marking it, then I flip all the unmarked 'O's to 'X' and unmark the protected ones."
