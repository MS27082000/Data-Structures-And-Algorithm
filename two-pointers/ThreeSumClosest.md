# 3Sum Closest (LC 16)

**Problem:** Pick three numbers from the array so that their sum is **as close as possible to `target`**. Return that sum. Exactly one answer exists.

`[-1, 2, 1, -4]`, `target = 1` → `2` (because `-1 + 2 + 1 = 2`)

## 1. Approaches

1. **Brute force:** try every triple with three loops. O(n³).
2. **Sort + two pointers (best):** O(n²) time, O(1) space.

## 2. How it differs from 3Sum

3Sum looks for sums that are exactly `0`. Here we look for the sum closest to `target`. So:

- We keep a variable `closest` that stores the **best sum seen so far**.
- We don't need to skip duplicates. We only return one number, so repeats can't hurt.
- Everything else is the same: sort, fix `i`, two pointers.

## 3. The idea in steps

1. **Sort** the array.
2. Set `closest = nums[0] + nums[1] + nums[2]` (a real triple sum to start with).
3. For each `i`, set `left = i + 1`, `right = n - 1`.
4. Compute `sum = nums[i] + nums[left] + nums[right]`.
5. **Update the best:** if `sum` is closer to `target` than `closest`, set `closest = sum`.
6. **Move a pointer:**
   - `sum == target` → distance is 0, return `sum` right away.
   - `sum < target` → sum is too small, so `left++` (take a bigger number).
   - `sum > target` → sum is too big, so `right--` (take a smaller number).

## 4. The condition `Math.abs(sum - target) < Math.abs(closest - target)`

`Math.abs(sum - target)` is the **distance** between `sum` and `target`, ignoring the sign.

| sum | target | `sum - target` | distance `abs(...)` |
|---|---|---|---|
| 3 | 1 | 2 | 2 |
| -1 | 1 | -2 | 2 |
| 2 | 1 | 1 | 1 |

A sum of `3` and a sum of `-1` are **equally far** from `1`, even though one is above and one is below. We care about distance, not direction, so we use the absolute value. Without it, `-1 - 1 = -2` would look "smaller" than `1`, and we would compare wrongly.

So the condition reads: "is this sum **closer** to the target than the best one I have?" If yes, it becomes the new best.

## 5. Code

```java
Arrays.sort(nums);
int closest = nums[0] + nums[1] + nums[2];

for (int i = 0; i < nums.length - 2; i++) {
    int left = i + 1, right = nums.length - 1;
    while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (Math.abs(sum - target) < Math.abs(closest - target)) {
            closest = sum;                 // this sum is closer, so remember it
        }

        if (sum == target) return sum;     // can't do better than distance 0
        else if (sum < target) left++;     // too small
        else right--;                      // too big
    }
}
return closest;
```

## 6. Dry run: `nums = [-1, 2, 1, -4]`, `target = 1`

Sorted: `[-4, -1, 1, 2]` (indices 0 to 3).
Start: `closest = -4 + -1 + 1 = -4`, distance `|-4 - 1| = 5`.

The loop runs for `i = 0 .. 1` (`i < n - 2 = 2`).

### i = 0, anchor = -4

| left (value) | right (value) | sum | distance `|sum - 1|` | best distance | action |
|---|---|---|---|---|---|
| 1 (-1) | 3 (2) | -4 + -1 + 2 = **-3** | 4 | 5 | 4 < 5, so `closest = -3`. Sum < 1, so `left++` |
| 2 (1) | 3 (2) | -4 + 1 + 2 = **-1** | 2 | 4 | 2 < 4, so `closest = -1`. Sum < 1, so `left++` |
| 3 | 3 | | | | `left == right`, stop |

### i = 1, anchor = -1

| left (value) | right (value) | sum | distance `|sum - 1|` | best distance | action |
|---|---|---|---|---|---|
| 2 (1) | 3 (2) | -1 + 1 + 2 = **2** | 1 | 2 | 1 < 2, so `closest = 2`. Sum > 1, so `right--` |
| 2 | 2 | | | | `left == right`, stop |

### i = 2
`i < n - 2` is `2 < 2`, false, so the loop ends.

**Answer: `2`**

## 7. Dry run with an exact match: `[1, 2, 4, 8]`, `target = 7`

- Start: `closest = 1 + 2 + 4 = 7`, distance 0.
- `i = 0`: `left = 1` (2), `right = 3` (8). Sum = 11, distance 4. Not closer than 0, so `closest` stays 7. Sum > 7, so `right--`.
- `left = 1` (2), `right = 2` (4). Sum = 7 → `sum == target`, so return **7**.

## 8. Complexity

Sorting is O(n log n). The loop over `i` runs n times, and the two pointers move at most n steps for each, so O(n²). Extra space is O(1).

**Edge cases:** exactly 3 elements, exact match exists, target far outside the possible sums, negative numbers, duplicates.

**Interview traps**
- Start `closest` with a real triple sum, **not** `Integer.MAX_VALUE`. `MAX_VALUE - target` can overflow.
- Compare **absolute distances**, not raw sums.
- Duplicate skipping is not needed for correctness. It is only a speed-up.
- Don't `left++` and `right--` together. Move only the one the comparison tells you to.

**How to explain:** "Same as 3Sum: sort, fix one number, two pointers for the other two. Instead of looking for zero, I keep the sum closest to target, and I move the pointers by comparing the sum with the target."
