# Sort Characters by Frequency (LC 451)

**Problem:** Rearrange the characters in decreasing order of frequency.

**Intuition:** Count each character, put it in a bucket indexed by its frequency, then read the buckets from high to low.

**Approach / complexity:** Bucket sort O(n) time, O(n) space. Heap: O(n log k).

**Edge cases:** Case sensitivity ('A' and 'a' differ), ties in any order, empty string.

**Interview traps**
- Append the character count times.
- Bucket size is n + 1.

**How to explain:** "Frequencies are at most n, so a bucket per frequency sorts everything in linear time."
