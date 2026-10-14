# Single Number II (LC 137)

**Problem:** Every element appears **three times** except one that appears once. Find it in O(n) time and O(1) space.

**Brute force / better:** Count with a `HashMap` → O(n) time, O(n) space. Sorting also works → O(n log n).
**Optimal 1 (bit counting):** For each of the 32 bit positions, count how many numbers have that bit set. If `count % 3 != 0`, that bit belongs to the single number → O(32·n), O(1) space.
**Optimal 2 (ones / twos):** Two variables act as a **mod-3 counter per bit**:
```
ones = (ones ^ x) & ~twos
twos = (twos ^ x) & ~ones
```
`ones` ends up holding the single number → O(n), O(1) space.

**Intuition:** XOR cancels pairs but not triples. So instead track each bit's count mod 3. Triples contribute multiples of 3, so only the single number's bits leave a remainder.

**Complexity:** Time O(n) (or O(32n)), Space O(1).

**Edge cases:** Negative numbers (the sign bit at position 31 is handled naturally by the bit-counting method), the single value being 0, a one-element array.

**Interview traps**
- Plain XOR **doesn't** work here (three equal values XOR to the value itself).
- In bit counting use a full 32-bit loop and `1 << bit` in `int`, so bit 31 produces a negative result correctly.
- The `ones/twos` method is concise but hard to derive on the spot. Know the bit-counting version well, and mention the other.
- Generalises to "appears k times": count mod k.

**How to explain:** "For each bit position I count how many numbers have it set. Numbers appearing three times add multiples of three, so any leftover (count mod 3) is the single number's bit."
