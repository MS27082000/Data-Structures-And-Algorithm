# Climbing Stairs (LC 70)

**Problem:** You can climb 1 or 2 steps at a time. How many distinct ways to reach step n?

**Intuition:** To stand on step n you came from n-1 (one step) or n-2 (two steps). So `ways(n) = ways(n-1) + ways(n-2)` - Fibonacci in disguise.

**Brute force:** Recursion, O(2^n).
**Optimised:** Bottom-up with two variables, O(n) time, O(1) space. (Matrix power / formula gives O(log n) but is rarely needed.)

**Edge cases:** n = 1 -> 1, n = 2 -> 2. Max constraint n = 45 fits in `int` (1836311903).

**Interview traps**
- Base cases: ways(1) = 1, ways(2) = 2 (not 0 and 1 shifted wrongly).
- If asked "steps 1, 2, 3" or "k steps", the recurrence sums the last k terms.

**How to explain:** "Last move was a 1-step or a 2-step, so ways(n) = ways(n-1) + ways(n-2). I only need the last two values."
