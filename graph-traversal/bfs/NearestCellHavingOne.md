# Distance of the Nearest Cell having 1 (and 01 Matrix, LC 542)

**Problem:** For every cell, find the distance (4-directional steps) to the **nearest cell containing 1**. (LC 542 asks the same for the nearest **0**.)

**Brute force:** BFS from every cell → O((R·C)²).
**Optimal (multi-source BFS):** Put **every target cell** (all 1s) in the queue with distance 0 and expand outwards. The first time a cell is reached is its shortest distance → **O(R·C)**.

**Intuition:** Reverse the search. Instead of "from each cell look for the nearest target", spread **from all targets at once**; each cell is claimed by its closest target.

**Complexity:** Time O(R·C), Space O(R·C).

**Edge cases:** No target cell anywhere (distances stay unreached/-1), all cells are targets (all 0), a single cell.

**Interview traps**
- Initialise `dist = -1` for non-targets: it doubles as the **visited** marker.
- Use the target value as a **parameter** so one function covers "nearest 1" and "nearest 0".
- Never run a BFS per cell. That is the common TLE.
- Same trick: [Rotting Oranges](RottenOranges.md), walls and gates, shortest bridge.

**How to explain:** "I start a BFS from all the target cells at once with distance zero. Each cell's first visit gives its nearest target, so one linear pass fills the whole matrix."
