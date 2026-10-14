# Recursion Theory and Concepts with Parameters

**Problem:** Understand how a function calling itself works.

**Intuition:** Every recursion needs a BASE CASE (when to stop) and a RECURSIVE CASE that makes the problem smaller. Calls pile up on the call stack and return in reverse order. Work done before the call happens on the way down; work done after happens on the way back up.

**Approach / complexity:** PARAMETERISED recursion carries the partial answer in an argument. FUNCTIONAL recursion builds the answer on return. Two recursive calls form a recursion tree (Fibonacci is O(2^n)). Time = number of calls times work per call; space = depth of the stack.

**Edge cases:** n = 0 or empty input, negative input, very deep recursion (StackOverflowError at roughly 10-20 thousand frames in Java).

**Interview traps**
- A missing or unreachable base case gives infinite recursion.
- Use a loop or an explicit stack when the depth can be large.
- Overlapping calls (Fibonacci) call for memoisation.

**How to explain:** "A recursive solution reduces the problem to a smaller copy of itself and stops at a base case; the call stack remembers where to continue."
