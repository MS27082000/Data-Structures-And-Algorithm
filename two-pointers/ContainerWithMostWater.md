# Container With Most Water (LC 11)

**Problem:** Given line heights, pick two lines that with the x-axis hold the most water.

**Brute force:** Check every pair, `area = min(h[i],h[j]) * (j-i)` → O(n²).

**Approach:** `left=0`, `right=n-1`. Compute area, update max, then **move the pointer at the shorter line**.

**Intuition (the proof they ask for):** Area is limited by the shorter line. Moving the *taller* line inward can only shrink the width and the height is still capped by the short one, so area cannot improve. Moving the *shorter* one is the only move that might find a taller line. So we safely discard the shorter line.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Two elements, equal heights, heights containing 0, strictly increasing or decreasing array.

**Interview traps**
- Be able to justify **why** you move the shorter side. That is the follow-up question.
- Width is `right - left` (not `+1`).
- Water level = `min` of the two heights, not max.
- Not the same as Trapping Rain Water. Here the bars are just walls and have no thickness.

**How to explain:** "Start with max width. Width only shrinks from here, so to beat the current area I need a taller limiting line. Hence I always move the shorter side."
