# Next Permutation (LC 31)

**Problem:** Rearrange the array **in place** into the next bigger arrangement. If it is already the biggest, change it to the smallest.

## 1. What it means

All arrangements of `[1,2,3]`, from smallest to biggest:

```
1 2 3
1 3 2     <- next of 1 2 3
2 1 3     <- next of 1 3 2
2 3 1
3 1 2
3 2 1     <- biggest. Its "next" is the smallest: 1 2 3
```

**Goal:** make the array a little bigger, by the smallest amount possible.

## 2. The idea, with `[1, 3, 5, 4, 2]`

Answer should be `[1, 4, 2, 3, 5]`.

**Step 1: find the pivot.**
Find the first number, going from the right, that is smaller than the number next to it.

Look from the right: `2`, `4`, `5` increase as you move left. So `5 4 2` is in decreasing order. Decreasing order is already the biggest order for those numbers, so rearranging them cannot make the array bigger.

Move one more to the left: `3` is smaller than `5`. Now we can make the array bigger. This `3` is the **pivot** (index 1).

**Step 2: put a bigger number in the pivot's place.**
Pick the smallest number on the right that is still bigger than 3. From `5, 4, 2` that is `4`. Swap `3` and `4`:

```
[1, 3, 5, 4, 2]  ->  [1, 4, 5, 3, 2]
```

**Step 3: make the right part as small as possible.**
The right part is now `5 3 2`. Its smallest order is `2 3 5`. It is decreasing right now, so reversing it gives increasing order:

```
[1, 4, 5, 3, 2]  ->  [1, 4, 2, 3, 5]
```

Done: `[1, 4, 2, 3, 5]`.

**If there is no pivot** (like `[3, 2, 1]`, all decreasing), the array is already the biggest. Reverse the whole array to get the smallest: `[1, 2, 3]`.

## 3. How the code implements it

```java
int pivot = -1;
int n = nums.length;

for (int i = n - 2; i >= 0; i--) {              // (A) find the pivot
    if (nums[i] < nums[i + 1]) {
        pivot = i;
        break;
    }
}

if (pivot != -1) {                              // (B) swap with the next bigger number
    for (int i = n - 1; i > pivot; i--) {
        if (nums[i] > nums[pivot]) {
            // swap nums[i] and nums[pivot]
            break;
        }
    }
}

reverse(nums, pivot + 1, n - 1);                // (C) reverse the part after the pivot
```

- **(A)** `pivot = -1` means "not found yet". Start at the second-last index and move left. The **first** time `nums[i] < nums[i+1]` (smaller than its right neighbour), save `i` as the pivot and `break`. That is Step 1. If nothing is found (all decreasing), `pivot` stays `-1`.
- **(B)** Only runs if a pivot exists. Start at the **last** index and move left, down to `pivot + 1`. The right part is decreasing, so the **first** number bigger than `nums[pivot]` that we meet is also the smallest bigger one. Swap and `break`. That is Step 2.
- **(C)** Reverse everything after the pivot. That is Step 3. When `pivot == -1`, `pivot + 1` is `0`, so the whole array is reversed. That handles the "no pivot" case without extra code.
- **`reverse(nums, start, end)`** swaps the two ends and moves inward until they meet.

### Variables traced on `[1, 3, 5, 4, 2]`, n = 5

| Moment | i | pivot | array |
|---|---|---|---|
| (A) `4 < 2`? no | 3 | -1 | `[1,3,5,4,2]` |
| (A) `5 < 4`? no | 2 | -1 | |
| (A) `3 < 5`? **yes**, break | 1 | 1 | |
| (B) `2 > 3`? no | 4 | 1 | |
| (B) `4 > 3`? **yes**, swap index 3 and 1, break | 3 | 1 | `[1,4,5,3,2]` |
| (C) reverse index 2 to 4 | | 1 | `[1,4,2,3,5]` |

## 4. More dry runs

**`[1, 2, 3]`**
- Pivot: `i=1`: `2 < 3`? Yes. Pivot = 1.
- Swap with first number from the right bigger than 2: that is `3` (index 2). Array `[1, 3, 2]`.
- Reverse index 2..2 (one element), no change. Answer `[1, 3, 2]`.

**`[3, 2, 1]`**
- `i=1`: `2 < 1`? No. `i=0`: `3 < 2`? No. Loop ends, pivot stays -1.
- Skip the swap. Reverse index 0..2. Answer `[1, 2, 3]`.

**`[1, 5, 1]` (duplicates)**
- `i=1`: `5 < 1`? No. `i=0`: `1 < 5`? Yes. Pivot = 0 (value 1).
- From the right: `nums[2]=1 > 1`? No (equal, skip). `nums[1]=5 > 1`? Yes, swap index 1 and 0.
- Swap index 0 and 1: `[5, 1, 1]`. Reverse index 1..2: no change. Answer `[5, 1, 1]`.

## 5. Why the comparisons are strict (`<` and `>`)

- Step 1 uses `<` (strict): equal numbers are not "smaller", so they don't count as a pivot. Keep moving left.
- Step 2 uses `>` (strict): we need a number **strictly bigger** than the pivot, so equal numbers are skipped.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** all decreasing (wraps to smallest), single element, duplicates.

**Interview traps**
- Handle `pivot = -1`. Never read `a[-1]`.
- Strict vs not strict comparisons (section 5).
- Be able to explain: the right part is decreasing, so it cannot grow. After the swap it is still decreasing, so reversing it gives the smallest order.

**How to explain:** "Find the rightmost number that is smaller than its right neighbour. Swap it with the smallest bigger number on its right. Then reverse the part after it to make it as small as possible."
