# Trapping Rain Water (LC 42)

**Problem:** Given bar heights, how much rain water is trapped between them?

**Core formula:** Water above index `i` = `min(maxLeft(i), maxRight(i)) - height[i]` (never negative).

**Brute force:** For each `i`, scan left and right for the maxes → O(n²), O(1) space.
**Better (prefix/suffix arrays):** Precompute `leftMax[]` and `rightMax[]` → O(n) time, O(n) space.
**Also valid:** Monotonic stack → O(n) time, O(n) space.

**Optimal approach (two pointers):** `left`, `right`, `leftMax`, `rightMax`. Compare `height[left]` and `height[right]`; process the **smaller** side:
- if bar ≥ its max → update the max
- else → `water += max - bar`

then move that pointer.

**Intuition:** If `height[left] < height[right]`, then a wall at least as high as `height[left]` already exists on the right. So the water at `left` depends only on `leftMax`, and we can compute it without knowing the exact `rightMax`.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Fewer than 3 bars, monotonic increasing or decreasing (0 water), all equal, a deep pit in the middle.

**Interview traps**
- Expect to be asked to go from O(n) space → O(1). Walk through brute → prefix arrays → two pointers.
- The smaller-side rule is the thing to justify.
- Don't confuse with Container With Most Water. That one picks two lines, this one fills all gaps.

**How to explain:** "Water at a bar is limited by the shorter of the tallest bars on each side. With two pointers I always process the side with the smaller current height, since that side's max is the true limit there."
