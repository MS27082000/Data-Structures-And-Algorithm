# Binary Subarrays With Sum (LC 930)

**Problem:** `nums` contains only `0` and `1`. Count the subarrays whose sum is exactly `goal`.

`[1, 0, 1, 0, 1]`, `goal = 2` → `4`

## Approaches

1. **Brute force:** check every subarray. O(n²).
2. **Sliding window with `atMost` (main):** O(n) time, O(1) space.
3. **Prefix sum + HashMap:** O(n) time, O(n) space. Also works with negative numbers. See [Count Subarrays with Sum K](../prefix-sum/CountSubarraysWithSumK.md).

## Why a plain sliding window fails for "exactly"

The window works by shrinking when the sum is too big. But zeros make **many different starts** give the same sum.

`nums = [1, 0, 0, 1]`, `goal = 1`, `right = 3`:

| Start | Subarray | Sum |
|---|---|---|
| 1 | `[0, 0, 1]` | 1 ✓ |
| 2 | `[0, 1]` | 1 ✓ |
| 3 | `[1]` | 1 ✓ |

That is 3 subarrays for one `right`, and a single `count++` would count only one.

## The fix: exactly = atMost(goal) − atMost(goal − 1)

`atMost(g)` counts the subarrays with sum `0, 1, ..., g`. Subtracting the sums `0..goal−1` leaves only sum `goal`.

Subarrays of `[1, 0, 1]` grouped by sum:

| Sum | How many |
|---|---|
| 0 | 1 |
| 1 | 4 |
| 2 | 1 |

For `goal = 1`: `atMost(1) = 1 + 4 = 5`, `atMost(0) = 1`, so the answer is `5 − 1 = 4`.

"At most" works with a window because shrinking a window never increases its sum (all values are `>= 0`).

## How `atMost(g)` works

| Question | Answer |
|---|---|
| State | `sum` of the window |
| Invalid when | `sum > g` |
| When `left` leaves | `sum -= nums[left]` |

Steps for each `right`:
1. **Add** `nums[right]` to `sum`.
2. **While** `sum > g`: `sum -= nums[left]`, `left++`.
3. **Count** `right − left + 1`.

Step 3: the window `[left..right]` has `sum <= g`. Every start from `left` to `right` gives a subarray ending at `right` that also has `sum <= g`, because removing elements from the left can only lower the sum. So there are `right − left + 1` of them.

## Code

```java
public int numSubarraysWithSum(int[] nums, int goal) {
    return atMost(nums, goal) - atMost(nums, goal - 1);
}

private int atMost(int[] nums, int goal) {
    if (goal < 0) return 0;                     // no subarray has a negative sum
    int left = 0, sum = 0, count = 0;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum > goal) {
            sum -= nums[left];
            left++;
        }

        count += right - left + 1;
    }
    return count;
}
```

## Dry run: `[1, 0, 1]`, `goal = 1`

`atMost(1)`:
```
right=0  sum=1  left=0  count += 1 → 1      ([1])
right=1  sum=1  left=0  count += 2 → 3      ([1,0], [0])
right=2  sum=2 > 1 → sum -= nums[0], sum=1, left=1
                        count += 2 → 5      ([0,1], [1])
```
`atMost(0)`:
```
right=0  sum=1 > 0 → sum -= nums[0], sum=0, left=1   count += 0 → 0
right=1  sum=0  left=1  count += 1 → 1      ([0])
right=2  sum=1 > 0 → sum -= nums[1] (0), sum=1, left=2
                     sum -= nums[2] (1), sum=0, left=3   count += 0 → 1
```
Answer: `5 − 1 = 4`.

## Complexity

Each pointer moves forward only, so one `atMost` is O(n). Two calls are still O(n). Space is O(1).

**Edge cases:** `goal = 0` (counts the runs of zeros, `[0,0,0,0,0]` → 15), `goal` larger than the total sum (0), a single element.

**Interview traps**
- `goal − 1` can be `-1` when `goal = 0`. Return `0` from `atMost` when `goal < 0`, or the `while` loop never ends.
- This window needs **non-negative** values. With negatives, use prefix sums.
- `atMost` alone does not give "exactly". Subtract the `goal − 1` count.
- Add `right − left + 1`, not `1`.

**How to explain:** "Counting subarrays with exactly `goal` is hard directly. So I count those with at most `goal`, subtract those with at most `goal − 1`, and do each with a sliding window."
