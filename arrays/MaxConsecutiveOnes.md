# Maximum Consecutive Ones (LC 485)

**Problem:** Longest run of consecutive 1s in a binary array.

**Brute force:** From each 1, count forward → O(n²) worst case (all ones).
**Optimal:** One pass with a running `count`; reset on 0, update `max` each step.

**Intuition:** A run only grows while we see 1s. A 0 breaks it, so we restart from 0.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** All zeros (0), all ones (n), run at the very end, empty array.

**Interview traps**
- Update `max` **inside** the 1-branch (or after the loop too), otherwise a run ending at the last index is missed.
- Follow-up: Max Consecutive Ones III (flip at most k zeros) → sliding window.

**How to explain:** "Count the current streak of ones, reset on a zero, and keep the best streak seen."
