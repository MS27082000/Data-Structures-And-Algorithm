# Rotting Oranges (LC 994)

**Problem:** Grid cells: `0` empty, `1` fresh orange, `2` rotten orange. Every minute each fresh orange 4-adjacent to a rotten one becomes rotten. Return the minutes until no fresh orange remains, or `-1` if impossible.

**Approach (multi-source BFS):** Put **all** rotten oranges into the queue at time 0. Process the queue **level by level**; each level is one minute, rotting the adjacent fresh oranges and enqueuing them. Track the **number of fresh oranges**; if it reaches 0, return the minutes; if the queue empties first, return `-1` → **O(R·C)**.

**Intuition:** Rot spreads simultaneously from many sources, exactly like a BFS that starts with several nodes at distance 0.

**Complexity:** Time O(R·C), Space O(R·C).

**Edge cases:** No fresh oranges (0 minutes, even with no rotten ones), fresh oranges but no rotten (-1), an isolated fresh orange behind empty cells (-1), several rotten sources.

**Interview traps**
- **Start with all rotten oranges in the queue**, not one at a time.
- Increment `minutes` **once per level** and only when something rots (stop the loop when `fresh == 0` to avoid an off-by-one at the end).
- Count the fresh oranges up front to detect unreachable ones.
- Don't BFS from each rotten orange separately.

**How to explain:** "I do a BFS that begins with every rotten orange in the queue. Each BFS level is one minute. When the queue is exhausted, if any fresh orange is left it was unreachable, so -1."
