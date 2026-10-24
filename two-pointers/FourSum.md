# 4Sum (LC 18)

**Problem:** Given an array `nums` and a number `target`, return all **unique** quadruplets `[a, b, c, d]` (four different positions) with `a + b + c + d == target`. The same quadruplet must not appear twice.

`[1, 0, -1, 0, -2, 2]`, `target = 0` → `[[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]`

## 1. Approaches

1. **Brute force:** four nested loops, plus a set to remove duplicate quadruplets. O(n⁴).
2. **Fix two, hash the rest:** O(n³), but the duplicate handling is messy.
3. **Sort + two fixed numbers + two pointers (best):** O(n³) time, O(1) extra space.

## 2. The idea: 4Sum is 3Sum with one more loop

Remember how the earlier problems reduce:

| Problem | Fixed with loops | Two pointers for |
|---|---|---|
| Two Sum II | nothing | the 2 numbers |
| 3Sum | `i` | the other 2 |
| **4Sum** | **`i` and `j`** | **the other 2** |

So in 4Sum we fix two numbers, `nums[i]` and `nums[j]`. Then we need two more numbers to the right of `j` that add up to `target - nums[i] - nums[j]`. That last part is Two Sum II, solved with `left` and `right` pointers.

Four positions are involved, so there are **four places** where duplicates can sneak in: `i`, `j`, `left`, `right`.

## 3. The steps

1. **Sort** the array. Two pointers need it, and equal numbers become neighbours.
2. **Outer loop `i`** from `0` to `n - 4` (it needs three numbers to its right).
3. **Inner loop `j`** from `i + 1` to `n - 3` (it needs two numbers to its right).
4. Put `left = j + 1`, `right = n - 1`.
5. Compute `sum = nums[i] + nums[j] + nums[left] + nums[right]`:
   - `sum == target` → save the quadruplet, move both pointers, skip duplicates.
   - `sum < target` → too small, `left++`.
   - `sum > target` → too big, `right--`.

## 4. Duplicate skipping, in detail

**(a) Duplicate `i`:**
```java
if (i > 0 && nums[i] == nums[i - 1]) continue;
```
If this `i` has the same value as the previous `i`, all quadruplets starting with that value were already found. Compare with the **previous** element, so the first copy is used.

**(b) Duplicate `j`:**
```java
if (j > i + 1 && nums[j] == nums[j - 1]) continue;
```
Same idea for `j`, but the condition is `j > i + 1`, not `j > 0`.

Why: `j` starts at `i + 1`. The first `j` is allowed to equal `nums[i]`. For `[2, 2, 2, 2]`, `i = 0` and `j = 1` are both `2`, and that is a valid quadruplet. If you wrote `j > 0`, you would compare `nums[1]` with `nums[0]`, find them equal, and wrongly skip it. With `j > i + 1`, you compare only with an earlier **`j`** in the same inner loop.

**(c) and (d) Duplicate `left` / `right` after a match:**
```java
left++;
right--;
while (left < right && nums[left]  == nums[left - 1])  left++;
while (left < right && nums[right] == nums[right + 1]) right--;
```
After saving, keep moving each pointer while it sits on a value that was just used. The `left < right` check keeps the pointers from crossing.

## 5. Why `long`

Values can be up to `10^9`. Four of them add up to `4·10^9`, which is more than `Integer.MAX_VALUE` (about `2.1·10^9`), so an `int` sum wraps around to a wrong (negative) number. That can match the target by accident.

```java
long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
```

The `(long)` on the first term makes the whole addition happen in `long`.

## 6. Code

```java
Arrays.sort(nums);
for (int i = 0; i < n - 3; i++) {
    if (i > 0 && nums[i] == nums[i - 1]) continue;
    for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;

        int left = j + 1, right = n - 1;
        while (left < right) {
            long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left]  == nums[left - 1])  left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
```

## 7. Dry run: `[1, 0, -1, 0, -2, 2]`, `target = 0`

Sorted: `[-2, -1, 0, 0, 1, 2]` (indices 0 to 5). `i` runs over `0..2`, and `j` runs over `i+1..3`.

### i = 0 (value -2)

**j = 1 (value -1)**, `left = 2`, `right = 5`

| left (value) | right (value) | sum | action |
|---|---|---|---|
| 2 (0) | 5 (2) | -2 + -1 + 0 + 2 = **-1** | too small, `left++` |
| 3 (0) | 5 (2) | -2 + -1 + 0 + 2 = **-1** | too small, `left++` |
| 4 (1) | 5 (2) | -2 + -1 + 1 + 2 = **0** | **save `[-2,-1,1,2]`**; `left=5`, `right=4`, stop |

**j = 2 (value 0)**: is `j > i+1` (2 > 1) and `nums[2] == nums[1]`? `0` vs `-1`, no. Continue. `left = 3`, `right = 5`

| left (value) | right (value) | sum | action |
|---|---|---|---|
| 3 (0) | 5 (2) | -2 + 0 + 0 + 2 = **0** | **save `[-2,0,0,2]`**; `left=4`, `right=4`, stop |

**j = 3 (value 0)**: `j > i+1` and `nums[3] == nums[2]` (`0 == 0`), so **skip**.

### i = 1 (value -1)
`nums[1] == nums[0]`? `-1` vs `-2`, no. Continue.

**j = 2 (value 0)**, `left = 3`, `right = 5`

| left (value) | right (value) | sum | action |
|---|---|---|---|
| 3 (0) | 5 (2) | -1 + 0 + 0 + 2 = **1** | too big, `right--` |
| 3 (0) | 4 (1) | -1 + 0 + 0 + 1 = **0** | **save `[-1,0,0,1]`**; `left=4`, `right=3`, stop |

**j = 3 (value 0)**: `j > i+1` (3 > 2) and `nums[3] == nums[2]`, so **skip**.

### i = 2 (value 0)
`nums[2] == nums[1]`? `0` vs `-1`, no. Continue.

**j = 3 (value 0)**, `left = 4`, `right = 5`

| left (value) | right (value) | sum | action |
|---|---|---|---|
| 4 (1) | 5 (2) | 0 + 0 + 1 + 2 = **3** | too big, `right--`; `left == right`, stop |

`j = 4` is not allowed, since `j < n - 2 = 4`. `i = 3` is not allowed either, since `i < n - 3 = 3`. Done.

**Result: `[[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]`**

## 8. Dry run with all duplicates: `[2, 2, 2, 2, 2]`, `target = 8`

`n = 5`. `i` runs over `0..1`, and `j` runs over `i+1..2`.

- `i = 0`, `j = 1`: `left = 2`, `right = 4`. Sum = `2+2+2+2 = 8` → **save `[2,2,2,2]`**. Then `left = 3`, `right = 3`. The skip loops need `left < right`, which is false, so they stop.
- `i = 0`, `j = 2`: `j > i+1` and `nums[2] == nums[1]`, so **skip**.
- `i = 1`: `nums[1] == nums[0]`, so **skip**.

Only one quadruplet is saved: `[[2,2,2,2]]`.

## 9. Complexity

Two nested loops give about n² pairs `(i, j)`. For each pair, the two pointers move at most n steps. So O(n³). Sorting is O(n log n), which is smaller. Extra space is O(1), not counting the output list.

**Edge cases:** fewer than 4 elements (the loops never run, so the result is empty), all elements equal, negative numbers, values near `10^9` (overflow).

**Interview traps**
- **Overflow:** use `long` for the sum.
- Skip duplicates at **all four** positions: `i`, `j`, `left`, `right`.
- For `j` the check is `j > i + 1`, not `j > 0`.
- Skip `left` / `right` duplicates only **after** a match.
- Generalisation: for kSum, fix `k - 2` numbers with loops (or recursion), and use two pointers for the last two.

**How to explain:** "Sort, fix two numbers with nested loops, then use two pointers for the other two. Skip repeated values for `i`, `j`, and for the pointers after a match. Use `long` for the sum. O(n³) time."
