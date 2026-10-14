# Majority Element I (LC 169)

**Problem:** Find the element that appears more than `n/2` times (it always exists).

**Brute force:** Count each element with nested loops → O(n²).
**Better:** HashMap of counts → O(n) time, O(n) space. Or sort and take the middle element → O(n log n).
**Optimal:** **Boyer-Moore Voting** → O(n) time, O(1) space.

**Approach:** Keep a `candidate` and a `count`. If `count == 0`, pick the current element as the candidate. Same as the candidate → `count++`, otherwise `count--`.

**Intuition:** Each non-majority element can cancel out at most one majority vote. Since the majority has more than half the votes, it survives all the cancelling.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Single element, all same, negatives.

**Interview traps**
- If a majority is **not guaranteed**, you need a second pass to verify the candidate.
- Explain *why* the cancellation argument works.
- The sort trick (`nums[n/2]`) is a valid quick answer but O(n log n).

**How to explain:** "Boyer-Moore: pair off different elements. The element with more than half the votes can't be fully cancelled, so it's the one left at the end."
