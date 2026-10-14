# Swap Two Numbers (without a temporary variable)

**Problem:** Swap two integers `a` and `b` without a third variable.

**Standard:** `int t = a; a = b; b = t;`. Clear, safe, and what you should write in real code.

**Without a temp:**
1. **XOR swap:** `a ^= b; b ^= a; a ^= b;`
   - After step 1: `a = a ^ b`. Step 2: `b = b ^ (a ^ b) = a`. Step 3: `a = (a ^ b) ^ a = b`.
2. **Arithmetic swap:** `a = a + b; b = a - b; a = a - b;`. This can overflow in other languages, but in Java the wrap-around still gives the right result.

**Intuition (XOR):** `x ^ x = 0` and `x ^ 0 = x`, so XOR-ing with the same value twice restores the original.

**Complexity:** Time O(1), Space O(1).

**Edge cases:** `a == b` (fine), **the same variable/slot** (`swap(a[i], a[i])` zeroes the value!), negatives, `MAX_VALUE` (arithmetic overflow).

**Interview traps**
- **XOR-swapping a memory location with itself sets it to 0.** Guard `i == j` when swapping array elements.
- Java is **pass-by-value**, so a method `swap(int a, int b)` can't swap the caller's variables. Use an array, a wrapper, or just do it inline.
- The XOR / arithmetic tricks are slower than a temp variable on modern CPUs, since they create dependencies. Say that this is for knowledge, not for production.

**How to explain:** "XOR three times: `a ^= b; b ^= a; a ^= b`. Because x ^ x is 0, the values exchange without a temporary. I guard the same-location case."
