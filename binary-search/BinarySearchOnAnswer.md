# Pattern: Binary Search on the Answer

Learned from: [Koko Eating Bananas (LC 875)](https://leetcode.com/problems/koko-eating-bananas/). Notes: [KokoEatingBananas.md](KokoEatingBananas.md), code: [KokoEatingBananas.java](KokoEatingBananas.java).

## 1. The idea

Normally we search for a value **inside an array**. Here there is no sorted array. Instead we **guess the answer**, test the guess, and use the result to throw away half of the possible answers.

## 2. The Koko question (in simple words)

- Piles of bananas, e.g. `[3, 6, 7, 11]`. Koko has `h = 8` hours.
- She picks a speed `k` (bananas per hour) and keeps it for the whole time.
- Each hour she eats from **one** pile only. If the pile has fewer than `k` bananas, she finishes it and the rest of that hour is wasted.
- Find the **smallest** `k` so she finishes within `h` hours.

Speed `k = 4`: pile 3 takes 1 hour, pile 6 takes 2, pile 7 takes 2, pile 11 takes 3. Total 8, so it works.
Speed `k = 3`: 1 + 2 + 3 + 4 = 10 hours, more than 8, so it fails.

## 3. The hidden question

We cannot compute `k` directly, but we can **test** any `k`: is the total hours `<= h`?

| speed k | 1 | 2 | 3 | 4 | 5 | 6 | ... | 11 |
|---|---|---|---|---|---|---|---|---|
| total hours | 27 | 15 | 10 | 8 | 8 | 6 | ... | 4 |
| works (`<= 8`)? | no | no | no | **yes** | yes | yes | ... | yes |

- If a speed works, every faster speed works.
- If a speed fails, every slower speed fails.

So the row is `no no no yes yes yes`. It flips **once**. We need the **first yes**.

## 4. Why binary search works

Test the middle speed:
- **yes:** this speed and everything faster works. We want the smallest, so look **left** (keep `mid`).
- **no:** this speed and everything slower fails. Look **right** (drop `mid`).

Each test removes half of the speeds. We are not searching an array. We are searching the **range of possible answers**.

## 5. Where the search starts and ends

- `low = 1`. Speed 0 never finishes.
- `high = max(piles)`. At this speed every pile takes exactly 1 hour. Going faster cannot help, because she cannot use two piles in one hour.
- `high` always works, because the problem guarantees `h >= n`. So a "yes" always exists in our range.

## 6. Counting hours for one speed (the ceil formula)

Hours for one pile = number of rounds needed. Leftover bananas still cost a full hour.

- `7 / 4` is `1` in Java, but the real answer is `2`. We need division **rounded up**.
- Formula: `(pile + k - 1) / k`
- Check: `(7 + 4 - 1) / 4 = 10 / 4 = 2`. Exact fit: `(8 + 4 - 1) / 4 = 11 / 4 = 2`.
- Adding `k - 1` pushes any leftover over the next multiple, so it rounds up. With no leftover, the extra is too small to change anything.

Use `long` for the total, because the sum can overflow `int`.

## 7. The loop, line by line

```java
int low = 1, high = max(piles);
while (low < high) {
    int mid = low + (high - low) / 2;
    if (hoursNeeded(piles, mid) <= h) high = mid;   // works: keep mid, try slower
    else low = mid + 1;                             // fails: drop mid, go faster
}
return low;
```

- `low`, `high`: the speeds still possible. The answer is always between them.
- `high = mid` (not `mid - 1`): `mid` works, so it might be the answer. We only throw away what we are **sure** is not the answer.
- `low = mid + 1`: `mid` failed, so it is not the answer.
- `while (low < high)`: we stop when one speed is left. `low == high` is the answer.

## 8. Dry run: `piles = [3, 6, 7, 11]`, `h = 8`

| low | high | mid | hours at mid | works? | action |
|---|---|---|---|---|---|
| 1 | 11 | 6 | 1+1+2+2 = 6 | yes | high = 6 |
| 1 | 6 | 3 | 1+2+3+4 = 10 | no | low = 4 |
| 4 | 6 | 5 | 1+2+2+3 = 8 | yes | high = 5 |
| 4 | 5 | 4 | 1+2+2+3 = 8 | yes | high = 4 |
| 4 | 4 | | | | stop, answer **4** |

We tested 4 speeds out of 11. With piles up to 1 billion it is about 30 tests instead of 1 billion.

## 9. The reusable recipe

**Use it when:**
- The question asks for the **minimum** (or **maximum**) value that satisfies a rule.
- You can test one value quickly.
- The tests look like `no no no yes yes yes` (one switch only).

**4 steps:**
1. **Range:** smallest and largest possible answer. (Koko: `1 ... max(piles)`)
2. **Test function `ok(x)`:** can this answer work? (Koko: total hours `<= h`)
3. **Direction:** `ok(mid)` true → `high = mid`. False → `low = mid + 1`.
4. **Loop:** `while (low < high)`, then `return low`.

Only the **range** and the **test function** change from problem to problem. The loop stays the same.

```java
int low = MIN_POSSIBLE, high = MAX_POSSIBLE;
while (low < high) {
    int mid = low + (high - low) / 2;
    if (ok(mid)) high = mid;
    else low = mid + 1;
}
return low;
```

**Maximum version** (pattern is `yes yes no no`, e.g. Aggressive Cows). Use the **upper mid**, or the loop never ends:

```java
while (low < high) {
    int mid = low + (high - low + 1) / 2;
    if (ok(mid)) low = mid;
    else high = mid - 1;
}
return low;
```

**Cost:** O(n x log(range)). The test costs O(n), and runs about log(range) times.

## 10. Common mistakes

- Using `p / k` instead of the ceil formula.
- Setting `low = 0` (division by zero).
- Using `int` for the total hours (overflow).
- Searching the array indices instead of the speeds.
- In the maximum version, using the lower mid (infinite loop).

## 11. Practice on this pattern (in this folder)

Do them in this order. Same shape first, then harder tests.

| # | Question | What changes |
|---|---|---|
| 1 | [Smallest Divisor](SmallestDivisor.md) (LC 1283) | Almost a copy of Koko. Test: sum of ceilings `<= threshold`. |
| 2 | [Capacity to Ship Packages](CapacityToShipPackages.md) (LC 1011) | Range: `max(weights) ... sum`. Test: days needed `<= D`. |
| 3 | [Min Days to Make Bouquets](MinDaysToMakeBouquets.md) (LC 1482) | Range: `min ... max` of the days. Test: bouquets `>= m`. |
| 4 | [Square Root](SquareRoot.md) (LC 69) and [Nth Root](NthRoot.md) | Answer is a number, not a count. Test: `mid^n <= m`. |
| 5 | [Kth Missing Positive Number](KthMissingPositiveNumber.md) (LC 1539) | Test: missing numbers up to `a[i]` `>= k`. |
| 6 | [Split Array Largest Sum](SplitArrayLargestSum.md) (LC 410) | "Minimise the maximum". Test: parts needed `<= k`. |
| 7 | [Book Allocation](BookAllocation.md), [Painter's Partition](PaintersPartition.md) | Same as Split Array. |
| 8 | [Aggressive Cows](AggressiveCows.md) | **Maximum** version (`yes yes no no`). Use the upper mid. |
| 9 | [Minimize Max Distance to Gas Station](MinimizeMaxDistanceGasStation.md) | Answer is a decimal. Hardest in this group. |
