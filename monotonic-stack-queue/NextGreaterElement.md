# Next Greater Element (LC 496)

**Problem:** `nums1` is a subset of `nums2` (distinct values). For each `x` in `nums1`, find the first greater element to the **right** of `x` in `nums2`, or `-1`.

**Brute force:** For each `x`, locate it in `nums2` and scan right → O(n·m).
**Optimal:** A **monotonic (decreasing) stack** over `nums2`. For each incoming `x`, while the stack top is smaller, `x` is **the next greater element** of that top, so record it in a map and pop. Push `x`. Elements left on the stack have no greater element (-1). Then answer `nums1` from the map → O(n + m).

**General version (every index):** Scan **right to left**; pop stack elements `<= a[i]`; the top (if any) is the answer; push `a[i]`.

**Intuition:** An element that is smaller than a newcomer can never be the "next greater" for anything before the newcomer, so it can be removed. The stack stays decreasing from bottom to top.

**Complexity:** Time O(n + m), Space O(n). Each element is pushed and popped at most once.

**Edge cases:** Strictly decreasing array (all -1), duplicates in the generic version (use `<=` when popping for *strictly* greater), single element.

**Interview traps**
- In the left-to-right form, the **popped** element gets the answer. In the right-to-left form, the **top** is the answer.
- "Greater" is strict, so pop on `<=` in the right-to-left version.
- Pattern family: Next Smaller, Previous Greater, Stock Span, Daily Temperatures, Histogram.

**How to explain:** "I keep a stack of elements still waiting for a greater one, in decreasing order. Each new element resolves every smaller waiting element, which I pop, and then waits itself."
