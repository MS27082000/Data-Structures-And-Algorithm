# Minimum Cost to Connect Sticks (LC 1167)

**Problem:** Joining two sticks of lengths `x` and `y` costs `x + y` and produces a stick of length `x + y`. Connect all sticks into one with the **minimum total cost**.

**Brute force:** Try all joining orders → exponential.
**Optimal (greedy, Huffman-style):** Put all lengths in a **min-heap**. Repeatedly **extract the two smallest**, add their sum to the cost, and **push the sum back**. Stop when one stick remains → **O(n log n)**.

**Why smallest first:** Every time a stick is part of a merge, its length is paid again. Merging the two shortest sticks first means the **longest sticks are re-paid the fewest times**. This is exactly how **Huffman coding** builds an optimal prefix tree.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** One stick (cost 0), empty input, equal lengths, **large values**: the total can exceed `int`, so use `long`.

**Interview traps**
- Push the **merged stick back** into the heap.
- Use `long` for sums and costs.
- Not the same as "connect in the given order" (that's an interval-DP problem).
- Recognise the family: Huffman coding, Merge Files, Minimum Cost to Merge Stones with `k = 2` (different).

**How to explain:** "Each merge adds the sum of two sticks to the cost, and longer sticks get paid again each time they're merged. So I always merge the two shortest sticks, using a min-heap to find them."
