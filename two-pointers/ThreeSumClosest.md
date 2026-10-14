# 3Sum Closest (LC 16)

**Problem:** Return the sum of three numbers closest to `target`.

**Brute force:** Triple loop → O(n³).

**Approach:** Same as 3Sum: sort, fix `i`, two pointers. Track the sum with the smallest `|sum - target|`. Move `left` if sum < target, else `right`. If sum equals target, return immediately.

**Intuition:** Sorted order still tells us the direction to move. We don't need exact matches, only to remember the best seen so far.

**Complexity:** Time O(n²), Space O(1).

**Edge cases:** Exactly 3 elements, exact match exists, target far outside the possible range (huge or very negative), negatives, duplicates.

**Interview traps**
- Initialise `closest` with a real triple sum (`nums[0]+nums[1]+nums[2]`), **not** `Integer.MAX_VALUE`, because `MAX_VALUE - target` can overflow.
- Compare absolute differences, not raw sums.
- No duplicate skipping is needed for correctness (it's only an optimisation).

**How to explain:** "Like 3Sum, but instead of looking for zero I keep the sum closest to target and steer the pointers by comparing the sum with the target."
