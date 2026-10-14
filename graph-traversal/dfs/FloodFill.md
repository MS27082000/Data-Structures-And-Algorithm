# Flood Fill Algorithm (LC 733)

**Problem:** An image is a grid of colours. Starting at `(sr, sc)`, recolour the **connected region** (4-directionally) of the same original colour to `newColor`.

**Approach:** DFS (or BFS) from `(sr, sc)`. Visit neighbours whose colour equals the **original** colour, recolouring each as you go. The recolouring acts as the visited marker → **O(R·C)** time.

**Intuition:** It is the "paint bucket" tool: spread to every touching cell with the same colour.

**Complexity:** Time O(R·C), Space O(R·C) recursion worst case.

**Edge cases:** `newColor` equals the original colour, the start cell isolated, the whole image the same colour, a single pixel.

**Interview traps**
- **If `original == newColor`, return immediately.** Otherwise the recolouring never changes the cell, the "visited" check never triggers, and the recursion is **infinite**.
- Capture the **original** colour before changing anything.
- Compare against the original colour (not the new one) when deciding to spread.
- Only 4 directions unless told otherwise.

**How to explain:** "I remember the starting colour and DFS to every 4-connected neighbour that has it, recolouring as I go. Recolouring is also my visited marker, so I first return early when the new colour is the same as the old one."
