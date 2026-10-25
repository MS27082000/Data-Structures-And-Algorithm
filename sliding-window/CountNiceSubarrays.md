# Count Number of Nice Subarrays (LC 1248)

**Problem:** A subarray is **nice** if it has exactly `k` **odd** numbers. Count the nice subarrays.

`[1, 1, 2, 1, 1]`, `k = 3` → `2` (`[1,1,2,1]` and `[1,2,1,1]`)

## Approaches

1. **Brute force:** check every subarray and count its odd numbers. O(n²).
2. **Sliding window with `atMost` (main):** O(n) time, O(1) space.
3. **Prefix count of odds + HashMap:** like Count Subarrays with Sum K. O(n) time, O(n) space.

## Idea

Only whether a number is odd matters. Replace every number by `1` (odd) or `0` (even), and the problem becomes **Binary Subarrays With Sum = k**: count subarrays with exactly `k` ones.

So use the same trick:

```
answer = atMost(k) - atMost(k - 1)
```

`atMost(k)` counts subarrays with at most `k` odd numbers. Subtracting `atMost(k − 1)` leaves exactly `k`. (Why this works: see [Binary Subarrays With Sum](BinarySubarraysWithSum.md).)

## How `atMost(k)` works

| Question | Answer |
|---|---|
| State | `oddCount` = odd numbers in the window |
| Invalid when | `oddCount > k` |
| When `left` leaves | if `nums[left]` is odd, `oddCount--` |

For each `right`:
1. **Add** `nums[right]`. If it's odd, `oddCount++`.
2. **While** `oddCount > k`: if `nums[left]` is odd, `oddCount--`. Then `left++`.
3. **Count** `right − left + 1`.

Step 3: the window `[left..right]` has at most `k` odd numbers. Every start from `left` to `right` gives a subarray ending at `right` with at most `k` odds, since removing elements from the left can't add odds. So there are `right − left + 1` of them.

## Code

```java
public int numberOfSubarrays(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
}

private int atMost(int[] nums, int k) {
    if (k < 0) return 0;

    int left = 0, oddCount = 0, count = 0;

    for (int right = 0; right < nums.length; right++) {
        if (nums[right] % 2 != 0) {
            oddCount++;
        }

        while (oddCount > k) {
            if (nums[left] % 2 != 0) {
                oddCount--;
            }
            left++;
        }

        count += right - left + 1;
    }
    return count;
}
```

## Dry run: `[1, 1, 2, 1, 1]`, `k = 3`

`atMost(3)`:
```
right=0 (1)  oddCount=1  left=0  count += 1 → 1
right=1 (1)  oddCount=2  left=0  count += 2 → 3
right=2 (2)  oddCount=2  left=0  count += 3 → 6
right=3 (1)  oddCount=3  left=0  count += 4 → 10
right=4 (1)  oddCount=4 > 3 → nums[0]=1 is odd → oddCount=3, left=1
                         left=1  count += 4 → 14
```
`atMost(2)`:
```
right=0 (1)  oddCount=1  left=0  count += 1 → 1
right=1 (1)  oddCount=2  left=0  count += 2 → 3
right=2 (2)  oddCount=2  left=0  count += 3 → 6
right=3 (1)  oddCount=3 > 2 → nums[0] odd → oddCount=2, left=1
                         left=1  count += 3 → 9
right=4 (1)  oddCount=3 > 2 → nums[1] odd → oddCount=2, left=2
                         left=2  count += 3 → 12
```
Answer: `14 − 12 = 2`.

## Complexity

Each pointer only moves forward, so one `atMost` is O(n). Two calls are O(n). Space is O(1).

**Edge cases:** `k = 0` (subarrays with only even numbers, so `atMost(−1)` must return 0), no odd numbers when `k >= 1` (answer 0), all numbers odd.

**Interview traps**
- `atMost(k − 1)` with `k = 0` is `atMost(−1)`. Return 0, or the `while` loop never ends.
- Decrease `oddCount` only when the number leaving is **odd**.
- Evens never change `oddCount`. They just stretch the window.
- Use `x % 2 != 0` for odd. `x % 2 == 1` fails for negative numbers.

**How to explain:** "Only odd or even matters, so this is 'count subarrays with exactly k ones'. I count at most `k` odds, subtract at most `k − 1` odds, each with a sliding window."
