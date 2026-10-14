# Two Sum II – Sorted Array (LC 167)

**Problem:** Sorted array, find two numbers adding to `target`. Return 1-indexed positions. Exactly one answer.

**Brute force:** Check all pairs → O(n²) time, O(1) space.
**Also possible:** HashMap → O(n) time but O(n) space; ignores the "sorted" hint.

**Approach:** Opposite-end pointers `left=0`, `right=n-1`.
- `sum == target` → done
- `sum < target` → need bigger → `left++`
- `sum > target` → need smaller → `right--`

**Intuition:** Sorted order tells us which pointer to move. Moving `left` right only increases the sum; moving `right` left only decreases it. Each step safely discards one element that cannot be part of the answer.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Negatives, duplicates (`[3,3]`, target 6), two-element array, target at the extremes.

**Interview traps**
- Result is **1-indexed**, so return `left+1, right+1`.
- Don't use a hashmap and call it done. They want O(1) space.
- Use `left < right` (not `<=`) so you never use the same element twice.

**How to explain:** "Because it's sorted, I use two pointers at both ends. If the sum is too small I move the left pointer up, if too big I move the right pointer down. Each move eliminates one element, so it's O(n) with constant space."
