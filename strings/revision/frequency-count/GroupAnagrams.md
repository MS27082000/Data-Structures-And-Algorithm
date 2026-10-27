# Group Anagrams (LC 49)

**Problem:** Group the strings that are anagrams of each other.

**Brute force:** Compare every string with every group using an anagram check → O(n² · k).

**Approach:** Anagrams look the same after sorting. Use the sorted string as a HashMap key and collect originals in a list.

**Faster key:** The 26 letter counts (`"1#0#...#"`) as the key → O(n · k), no sorting.

**Complexity:** Time O(n · k log k) with sort, O(n · k) with counts. Space O(n · k).

**Edge cases:** Empty string `""` is its own group; single string.

**Interview traps**
- Do not use `int[]` directly as a key (arrays use identity hashing). Convert to a String.
- Join counts with a separator, or `"11"` can mean 1,1 or 11.

**Pattern:** "group by something" → HashMap with a canonical key.
