# Minimum Bit Flips to Convert Number (LC 2220)

**Problem:** The minimum number of bit flips to turn `start` into `goal`.

**Brute force:** Compare the two numbers bit by bit (32 iterations) and count differences → O(32).
**Optimal:** `start ^ goal` has a **1 exactly where the bits differ**. The answer is the number of set bits in that XOR (the **Hamming distance**). Count them with Kernighan's loop, or `Integer.bitCount(start ^ goal)`.

**Intuition:** Each differing position needs exactly one flip, and no other position needs any.

**Complexity:** Time O(k) (k = differing bits), Space O(1).

**Edge cases:** Equal numbers (0), `0` vs `MAX_VALUE` (31), negatives (`-1` vs `0` → 32), numbers with different bit lengths (leading zeros count as bits).

**Interview traps**
- It is **XOR then popcount**. A very common two-step pattern (Hamming Distance, LC 461, is identical).
- Don't forget about leading zeros: `3` (011) vs `4` (100) differ in 3 bits, not 1.
- For negatives, the 32-bit representation is used.

**How to explain:** "XOR the two numbers so differing bits become 1, then count the set bits. Each set bit is a flip I must make."
