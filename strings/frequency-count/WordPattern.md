# Word Pattern (LC 290)

**LeetCode:** [290](https://leetcode.com/problems/word-pattern/)

**Problem:** Does sentence `s` follow `pattern`? Each letter ↔ exactly one word (a bijection).
`("abba", "dog cat cat dog")` → `true`

**Key idea:** Same as Isomorphic Strings, but the "characters" of the second string are words. A bijection needs checks in **both** directions.

**Why two maps:**
| Case | pattern | s | One map says | Truth |
|---|---|---|---|---|
| Two letters, one word | `abba` | `dog dog dog dog` | a→dog, b→dog (fine) | `false` |
| One letter, two words | `aaaa` | `dog cat cat dog` | a→dog then a→cat (caught) | `false` |
Only `word → letter` catches the first case.

**Dry run (`abba`, `dog cat cat fish`):**
- a→dog, dog→a
- b→cat, cat→b
- b again, word `cat`: matches
- a, word `fish`: `a` maps to `dog` ≠ `fish` → `false`

**Complexity:** Time O(n). Space O(n).

**Edge cases:** Different counts of words and letters → `false` right away.

**Interview traps**
- Split first and compare lengths before the loop.
- Compare words with `.equals`, not `==`.

**Pattern:** "one-to-one mapping" → two maps (char→word and word→char).
