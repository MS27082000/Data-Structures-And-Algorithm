# LFU Cache (LC 460)

**Problem:** A fixed-capacity cache with `get` and `put` in **O(1)**. When full, evict the **least frequently used** key. If several keys tie on frequency, evict the **least recently used** among them.

**Brute force:** Keep a count per key and scan for the minimum on eviction → O(n).
**Optimal (O(1)):** Three structures:
- `values`: key → value
- `freq`: key → use count
- `buckets`: use count → a `LinkedHashSet` of keys with that count (**insertion order = recency**, oldest first)
- plus a `minFreq` variable.

**Operations**
- `get/put on an existing key`: remove it from bucket `f`, add it to bucket `f + 1`. If bucket `f` became empty and `f == minFreq`, then `minFreq++`.
- `put` of a **new** key: if full, evict the **first** key of `buckets[minFreq]` (the oldest among the least frequent). Then insert with frequency 1 and set `minFreq = 1`.

**Intuition:** Frequency buckets give O(1) access to "all keys with the lowest count", and the ordered set inside each bucket resolves ties by recency.

**Complexity:** `get` and `put` are O(1). Space O(capacity).

**Edge cases:** Capacity 0 (ignore all puts), updating an existing key (counts as a use, no eviction), ties on frequency, `minFreq` after the lowest bucket empties.

**Interview traps**
- **A new key always resets `minFreq` to 1.** Do it after evicting.
- **`put` on an existing key increments its frequency too.**
- When a bucket empties, **remove it** and bump `minFreq` only if it was the minimum bucket.
- Capacity 0 must not crash (`buckets.get(minFreq)` would be null).
- Harder than LRU. Mention LRU first, then say "LFU adds frequency buckets."

**How to explain:** "I group keys by how often they've been used, each group ordered by recency. Using a key moves it to the next group; eviction takes the oldest key from the lowest-frequency group, which I track with a min-frequency pointer."
