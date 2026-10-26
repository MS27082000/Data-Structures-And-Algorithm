# Koko Eating Bananas (LC 875)

[Practice](https://leetcode.com/problems/koko-eating-bananas/) · Pattern: [Binary Search on the Answer](BinarySearchOnAnswer.md) · Code: [KokoEatingBananas.java](KokoEatingBananas.java)

## Problem

- Piles of bananas, e.g. `[3, 6, 7, 11]`. Koko has `h = 8` hours.
- She picks a speed `k` (bananas per hour) and keeps it.
- Each hour she eats from **one** pile only. If the pile has fewer than `k`, she finishes it and the rest of that hour is wasted.
- Find the **smallest** `k` so that she finishes within `h` hours.

Speed 4: pile 3 takes 1 hour, 6 takes 2, 7 takes 2, 11 takes 3. Total 8, works.
Speed 3: 1 + 2 + 3 + 4 = 10 hours, fails.

## Brute force

Try `k = 1, 2, 3, ...` and stop at the first one that works. O(n x max). Too slow when piles are up to 10^9.

## Key observation

For any speed we can **test** it: is the total hours `<= h`?

| speed | 1 | 2 | 3 | 4 | 5 | 6 | ... | 11 |
|---|---|---|---|---|---|---|---|---|
| hours | 27 | 15 | 10 | 8 | 8 | 6 | ... | 4 |
| `<= 8`? | no | no | no | **yes** | yes | yes | ... | yes |

- A speed that works means every faster speed works.
- A speed that fails means every slower speed fails.

The row is `no no no yes yes yes`. We need the **first yes**, so we can binary search on the speed.

## Approach

1. **Range:** `low = 1`, `high = max(piles)`.
   - Speed 0 never finishes.
   - At `max(piles)` every pile takes 1 hour. Going faster cannot help.
   - `high` always works because `h >= n`.
2. **Test:** `hours(k) = sum of ceil(pile / k)`, then check `<= h`.
   - Ceil formula: `(pile + k - 1) / k`. Plain `pile / k` rounds down and is wrong (`7 / 4` is 1, but she needs 2 hours).
3. **Loop:** `mid` works → `high = mid` (keep it, it may be the answer). `mid` fails → `low = mid + 1`.
4. Stop when `low == high`. That is the answer.

## Code

```java
static int minEatingSpeed(int[] piles, int h) {
    int low = 1, high = 0;
    for (int p : piles) high = Math.max(high, p);
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (hoursNeeded(piles, mid) <= h) high = mid;   // works: try slower
        else low = mid + 1;                             // fails: go faster
    }
    return low;
}

private static long hoursNeeded(int[] piles, int speed) {
    long hours = 0;
    for (int p : piles) hours += (p + speed - 1) / speed;   // ceil(p / speed)
    return hours;
}
```

## Dry run: `[3, 6, 7, 11]`, `h = 8`

| low | high | mid | hours | works? | action |
|---|---|---|---|---|---|
| 1 | 11 | 6 | 1+1+2+2 = 6 | yes | high = 6 |
| 1 | 6 | 3 | 1+2+3+4 = 10 | no | low = 4 |
| 4 | 6 | 5 | 1+2+2+3 = 8 | yes | high = 5 |
| 4 | 5 | 4 | 1+2+2+3 = 8 | yes | high = 4 |
| 4 | 4 | | | | stop, answer **4** |

4 tests instead of 11.

## Complexity

- Time: O(n log max). Each test is O(n), and we run about log(max) tests.
- Space: O(1).

## Edge cases

- `h == n`: every pile needs 1 hour, so the answer is `max(piles)`.
- Very large `h`: the answer is 1.
- Single pile `[p]`: the answer is `ceil(p / h)`.

## Mistakes to avoid

- `pile / k` instead of the ceil formula.
- `low = 0` (division by zero).
- `int` for the total hours (overflow). Use `long`.
- Using `high = mid - 1` when `mid` works. It may throw away the answer.

## How to explain in an interview

"If Koko can finish at speed `k`, she can finish at any faster speed. So the answers look like `no no yes yes`, and I binary search the smallest speed whose total hours is at most `h`."
