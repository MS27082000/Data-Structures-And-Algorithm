# Trapping Rain Water (LC 42), Monotonic Stack Approach

> The Striver sheet lists this problem under **Stack / Queues**. The O(1)-space two-pointer solution is already in [two-pointers/TrappingRainWater](../two-pointers/TrappingRainWater.md). This note covers the **stack** way.

**Problem:** Given bar heights, compute how much rain water is trapped.

**Approaches**
- Brute force: per bar, max-left and max-right → O(n²).
- Prefix/suffix max arrays → O(n) time, O(n) space.
- Two pointers → O(n) time, **O(1) space** (best).
- **Monotonic stack (this file)** → O(n) time, O(n) space. Computes water **layer by layer (horizontally)**.

**Stack algorithm:** Keep indices of bars with decreasing heights. When a taller bar `i` arrives, repeatedly pop `bottom` (a valley). If the stack still has a `left` wall:
`width = i − left − 1`, `height = min(h[i], h[left]) − h[bottom]`, `water += width × height`.

**Intuition:** A popped bar is the floor of a basin whose left wall is the new stack top and right wall is the current bar. The water in that layer is a rectangle.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Fewer than 3 bars, monotonic increasing/decreasing (0), a single deep pit (`[3,0,3]` → 3), plateaus (equal heights).

**Interview traps**
- If the stack is empty after popping `bottom`, there's **no left wall**. Break without adding water.
- Use `min(h[i], h[left]) − h[bottom]` for the height, not the full wall height (previous layers were already counted).
- Equal heights: `>` (strict) pops nothing for equal bars, which is fine since width is accounted for later.
- Prefer the two-pointer version if the interviewer asks for O(1) space.

**How to explain:** "I keep a decreasing stack of bars. When a taller bar comes, each popped bar is a valley between the new bar and the bar below it on the stack, and I add the horizontal layer of water over that valley."
