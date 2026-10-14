# Longest Substring with At Most K Distinct Characters (LC 340)

**Problem:** Longest substring that contains at most `k` distinct characters.

**Brute force:** All substrings with a set → O(n²) or worse.
**Optimal:** Sliding window + frequency map. Expand `right`; while `map.size() > k`, shrink from the left, deleting a key when its count reaches 0 → O(n) time, O(k) space.

**Intuition:** "At most k distinct" is a monotonic condition. Shrinking a valid window keeps it valid, which is exactly what sliding window needs.

**Complexity:** Time O(n), Space O(k).

**Edge cases:** `k = 0` (answer 0), `k` larger than the number of distinct characters (whole string), empty string, a single character.

**Interview traps**
- Handle **`k == 0`** explicitly. The loop would otherwise never produce a valid window.
- **Delete the key** at count 0.
- Use `LinkedHashMap` / "last occurrence" variant to jump `left` directly (an optimisation for follow-up).
- It's the same as Fruit Into Baskets (`k = 2`) and Longest Substring with at most **2** distinct (LC 159).
- **Exactly k distinct** is different: use `atMost(k) − atMost(k−1)` for counting ([Count Number of Substrings](../strings/CountSubstringsWithKDistinct.md)).

**How to explain:** "I keep a map of character counts in the window. If it has more than k distinct characters I move the left edge forward, removing characters until only k remain, and track the longest valid window."
