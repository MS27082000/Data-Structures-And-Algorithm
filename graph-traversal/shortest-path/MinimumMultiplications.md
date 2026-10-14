# Minimum Multiplications to Reach End

**Problem:** Start with `start`. In one step multiply the current value by **any** number from `arr[]` and take the result **modulo 100000**. Fewest steps to reach `end`, or `-1`.

**Approach:** An **implicit graph**: the nodes are the values `0..99999` (the modulus bounds the state space) and each multiplier gives an edge. Every step costs 1, so run **BFS** from `start` with a `steps[]` array of size 100000 (initialised to `-1`) → **O(100000 · |arr|)**.

**Intuition:** The modulus keeps the number of states small, so exhaustive BFS is cheap. BFS guarantees the first arrival at `end` uses the fewest steps.

**Complexity:** Time O(100000 · |arr|), Space O(100000).

**Edge cases:** `start == end` (0 steps), unreachable `end` (-1), a multiplier of 1 (self-loop, ignored by visited), multiplication overflow.

**Interview traps**
- Multiply in **`long`**: `99999 × 99999` overflows `int`.
- Return 0 immediately when `start == end`.
- Terminate when the queue empties (visited ensures this).
- Recognise "state space is small → BFS on states" (also: Open the Lock, Minimum Genetic Mutation, Sliding Puzzle).

**How to explain:** "I treat each value modulo 100000 as a node and multiplying by an array element as an edge. Since each step costs one, BFS from the start finds the minimum number of multiplications to reach the end."
