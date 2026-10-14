# Basic Hashing

**Idea:** Pre-store information (usually counts) so that each later query takes O(1) instead of an O(n) scan.

**Problems it solves**
- "How many times does x appear?" for many queries.
- Highest / lowest frequency element.
- Character frequency (anagrams, first unique char, etc.).

**Brute force:** For each query scan the array → O(n) per query, O(n·q) total.
**Hashing:** One pass to build frequencies → O(n), then O(1) per query.

**Which structure?**
| Data | Use | Why |
|---|---|---|
| Lowercase letters | `int[26]` | Direct indexing (`c - 'a'`), fastest |
| Any ASCII | `int[256]` | Same idea |
| Large or sparse ints | `HashMap` | An array of size max-value won't fit |
| Large numbers, collisions | `HashMap` / `TreeMap` | TreeMap if sorted keys are needed (O(log n)) |

**Complexity:** Build O(n); lookup O(1) average, O(n) worst case on collisions; space O(distinct elements).

**Edge cases:** Element not present (`getOrDefault(x, 0)`), negative numbers (can't be array indices directly), ties for highest or lowest frequency.

**Interview traps**
- HashMap lookup is O(1) **average**, not guaranteed. Mention collisions, and that Java 8+ treeifies long buckets.
- Don't use an array hash for large ranges like 10⁹.
- Ties: ask whether to return the smallest value.

**How to explain:** "I precompute frequencies once into an array or HashMap, so every count query becomes a constant-time lookup."
