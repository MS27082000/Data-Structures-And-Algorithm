# Maximum XOR of Two Numbers in an Array (LC 421)

**Problem:** Maximum `nums[i] ^ nums[j]` over all pairs.

**Intuition:** Store every number as a 31-bit path (MSB first) in a binary trie. For each number walk the trie, and at each bit **try to go to the opposite bit** - that sets the bit in the XOR. If the opposite child is missing, take the same bit.

**Brute force:** All pairs, O(n^2).
**Optimised:** O(31 * n) time, O(31 * n) space. Alternative: build the answer bit by bit with a set of prefixes.

**Edge cases:** One element -> 0. Equal elements -> 0. Large values up to 2^31 - 1.

**Interview traps**
- Walk from bit 30 down; a higher bit outweighs all lower bits.
- Insert first, then query (a number may pair with itself, which gives 0 and is harmless).
- Only non-negative inputs are assumed.

**How to explain:** "For each x I look for the number that differs from it in the highest possible bits; the trie finds that greedily in 31 steps."
