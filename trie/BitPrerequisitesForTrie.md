# Bit Prerequisites for Trie Problems

**Topic:** The bit skills needed before the XOR-trie problems.

**Key ideas**
- Bit i of x: `(x >> i) & 1` (bit 0 = least significant).
- A number is a **path of bits, most significant bit first** - exactly like a word is a path of letters in a trie.
- `a ^ b` has a 1 wherever the bits differ. To make an XOR big, make the **highest** bits differ first (a high bit is worth more than all lower bits together).
- For non-negative `int`, bits 30..0 are enough (bit 31 is the sign).

**Brute force for max XOR:** All pairs, O(n^2). The trie reduces it to O(31 * n).

**Edge cases:** Value 0 (all-zero path). Negative numbers (bit 31 set) - the LeetCode problems use non-negative values. `x ^ x = 0`.

**Interview traps**
- Walk from the **top** bit down, never from bit 0.
- Use 31 levels, not 32, for non-negative ints (or handle the sign bit separately).

**How to explain:** "I store each number as a 31-step 0/1 path. For XOR I greedily go to the opposite bit at each level, because a higher differing bit beats any combination of lower bits."
