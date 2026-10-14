# Dynamic Programming - Introduction (Fibonacci)

**Problem:** Compute Fibonacci(n). The simplest problem that shows why DP exists.

**What DP is:** Plain recursion that **remembers answers** to overlapping sub-problems. Use it when (1) the problem breaks into smaller identical sub-problems and (2) those sub-problems repeat.

**The 5-step recipe (use for every DP question):**
1. **State** - what do the parameters mean? (`f(i)` = answer for the first i items)
2. **Recurrence** - how does a state depend on smaller states?
3. **Base cases** - the smallest states you know directly.
4. **Order** - top-down (recursion + memo) or bottom-up (loops).
5. **Space** - keep only the last few rows/values.

**Four ways to write Fibonacci (all in the Java file):**
- Plain recursion - O(2^n), the same sub-problems are recomputed (n=30 makes ~2.7 million calls).
- Memoisation (top-down) - O(n) time, O(n) space + recursion stack.
- Tabulation (bottom-up) - O(n) time, O(n) space, no recursion.
- Two variables - O(n) time, **O(1) space**.

**Edge cases:** n = 0 and n = 1 are base cases; large n overflows `int` (use `long`/modulo).

**Interview traps**
- Do not call plain recursion "DP". DP = recursion + caching.
- Memoisation can hit a stack overflow for deep n; then switch to tabulation.
- Say the state and recurrence out loud before coding.

**How to explain:** "I define the state, write the recurrence, cache results so each state is solved once, and then shrink space to the few previous values I actually need."
