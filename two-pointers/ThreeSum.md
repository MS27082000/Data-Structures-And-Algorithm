# 3Sum (LC 15)

**Problem:** Find all **unique** triplets `[a, b, c]` in the array with `a + b + c == 0`. No triplet may be repeated.

`[-1, 0, 1, 2, -1, -4]` → `[[-1, -1, 2], [-1, 0, 1]]`

## 1. Approaches

1. **Brute force:** three nested loops, plus a set to remove duplicate triplets. O(n³).
2. **Hash set:** fix `i`, then use a set to find the other two. O(n²), but removing duplicates is messy and it uses extra space.
3. **Sort + two pointers (best):** O(n²) time, O(1) extra space. This is the one to learn.

## 2. The idea in 3 steps

**Step 1: sort the array.**
Sorting helps twice: we can use two pointers, and equal numbers sit next to each other, so skipping duplicates is easy.

**Step 2: fix one number, then find the other two.**
Pick `nums[i]` (the *anchor*). We now need two numbers to its right that add up to `-nums[i]`. That is **Two Sum II** (sorted array), which you already know.

- Put `left = i + 1` and `right = n - 1`.
- Compute `sum = nums[i] + nums[left] + nums[right]`.
  - `sum < 0` → too small → `left++` (take a bigger number).
  - `sum > 0` → too big → `right--` (take a smaller number).
  - `sum == 0` → found a triplet. Save it and move both pointers.

**Step 3: skip duplicates.**
Without this, the same triplet could be saved many times. We skip repeated values in 3 places.

## 3. Duplicate skipping, in detail

**(a) Duplicate anchor:**
```java
if (i > 0 && nums[i] == nums[i - 1]) continue;
```
If this anchor equals the previous anchor, all triplets that start with this value were already found, so skip it.

Compare with the **previous** element (`i - 1`), not the next one. Then the *first* copy is processed and only later copies are skipped.
Example: sorted `[-1, -1, 0, 1, 2]`. At the first `-1` (index 0) the pointers can pick the second `-1`, giving `[-1, -1, 2]`. If we skipped the first copy, we would lose that triplet.

**(b) and (c) Duplicate `left` / `right` after a match:**
```java
left++;
right--;
while (left < right && nums[left]  == nums[left - 1])  left++;
while (left < right && nums[right] == nums[right + 1]) right--;
```
After saving a triplet, move both pointers. If the new `left` has the same value as the old one, using it would give the same triplet, so keep moving `left` forward until the value changes. Same for `right`, going backward.
The `left < right` check stops the pointers from crossing.

## 4. Code

```java
Arrays.sort(nums);
for (int i = 0; i < n - 2; i++) {
    if (nums[i] > 0) break;                              // smallest is positive, so the sum can't be 0
    if (i > 0 && nums[i] == nums[i - 1]) continue;       // skip duplicate anchor

    int left = i + 1, right = n - 1;
    while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
            left++;
            right--;
            while (left < right && nums[left]  == nums[left - 1])  left++;
            while (left < right && nums[right] == nums[right + 1]) right--;
        } else if (sum < 0) {
            left++;
        } else {
            right--;
        }
    }
}
```

## 5. Dry run: `[-1, 0, 1, 2, -1, -4]`

Sorted: `[-4, -1, -1, 0, 1, 2]` (indices 0 to 5).

| i (anchor) | left | right | sum | action |
|---|---|---|---|---|
| 0 (-4) | 1 (-1) | 5 (2) | -3 | too small, `left++` |
| 0 | 2 (-1) | 5 (2) | -3 | `left++` |
| 0 | 3 (0) | 5 (2) | -2 | `left++` |
| 0 | 4 (1) | 5 (2) | -1 | `left++`, now left = right, stop |
| 1 (-1) | 2 (-1) | 5 (2) | 0 | **save `[-1, -1, 2]`**, left=3, right=4 |
| 1 | 3 (0) | 4 (1) | 0 | **save `[-1, 0, 1]`**, left=4, right=3, stop |
| 2 (-1) | | | | same as previous anchor, **skip** |
| 3 (0) | 4 (1) | 5 (2) | 3 | too big, `right--`, now left = right, stop |

Result: `[[-1, -1, 2], [-1, 0, 1]]`.

## 6. Dry run with duplicates: `[0, 0, 0, 0]`

- `i = 0`: `left = 1`, `right = 3`, sum 0 → save `[0, 0, 0]`. Move: `left = 2`, `right = 2`. The skip loops need `left < right`, which is false, so they stop. The main loop ends too.
- `i = 1`: `nums[1] == nums[0]` → skip.
- The loop ends (`i < n - 2 = 2`).

Only one triplet is saved: `[[0, 0, 0]]`.

**Complexity:** Sorting is O(n log n). The main loop runs `i` over n values, and the two pointers move at most n steps for each, so O(n²) in total. Extra space is O(1), not counting the output list.

**Edge cases:** empty array or fewer than 3 elements, all zeros, all positive or all negative, many duplicates.

**Interview traps**
- Duplicate skipping is the hard part of this problem. Skip the anchor, and skip `left` and `right` **after** a match.
- Compare with the **previous** element for the anchor.
- `nums[i] > 0 → break` is only an optimisation.
- Sorting changes the order of elements. That is fine, because we return values, not indices.

**How to explain:** "Sort the array. Fix one number, then use two pointers to find the other two that make the sum zero. Skip repeated values for the anchor and for both pointers, so no triplet repeats. O(n²) time."
