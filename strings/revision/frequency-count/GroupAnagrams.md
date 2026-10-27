# Group Anagrams (LC 49)

**Problem:** Group the strings that are anagrams of each other.
`["eat","tea","tan","ate","nat","bat"]` → `[["eat","tea","ate"],["tan","nat"],["bat"]]`

**Brute force:** Compare each string with each group using an anagram check → O(n² · k).

**Key idea:** All anagrams share one *canonical form*. Compute it, and use it as the HashMap key.

**Dry run (sorted key):**
| word | key | map after |
|---|---|---|
| eat | aet | aet → [eat] |
| tea | aet | aet → [eat, tea] |
| tan | ant | ant → [tan] |
| ate | aet | aet → [eat, tea, ate] |
| nat | ant | ant → [tan, nat] |
| bat | abt | abt → [bat] |

**Two ways to make the key**
| Key | Cost per word | Note |
|---|---|---|
| Sorted chars | O(k log k) | Simplest, say this first |
| 26 counts joined with `#` | O(k) | Faster; follow-up answer |

**Complexity:** Time O(n · k log k) (or O(n · k) with counts). Space O(n · k).

**Edge cases:** `""` is its own group; a single string; all words are anagrams → one group.

**Interview traps**
- An `int[]` as a map key does not work (identity hash). Convert to a String.
- Join counts with a separator, or `"1" "11"` and `"11" "1"` look the same.
- Output order of groups does not matter.

**Pattern:** "group by a property" → HashMap with a canonical key.
