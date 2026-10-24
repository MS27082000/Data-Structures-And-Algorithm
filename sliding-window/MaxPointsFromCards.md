# Maximum Points You Can Obtain from Cards (LC 1423)

**Problem:** There are `n` cards in a row, and card `i` is worth `cardPoints[i]`. In one move you take **the first or the last** card. You must take **exactly `k`** cards. Return the maximum total points.

`cardPoints = [1, 2, 3, 4, 5, 6, 1]`, `k = 3` → `12` (take `5 + 6 + 1`)

---

## 1. Understand what you are allowed to pick

You can only take cards from the **two ends**. You can **never** take a card from the middle.

So a normal window of size 3 sitting in the middle, like `[3, 4, 5]`, is **not allowed**.

After `k` moves, you have taken some `i` cards from the **front** and `k - i` cards from the **back**, for some `i` from `0` to `k`. That gives only `k + 1` choices.

For `[1, 2, 3, 4, 5, 6, 1]`, `k = 3`:

| Cards from front | Cards from back | Cards taken | Sum |
|---|---|---|---|
| 3 | 0 | `1, 2, 3` | 6 |
| 2 | 1 | `1, 2` and `1` | 4 |
| 1 | 2 | `1` and `6, 1` | 8 |
| 0 | 3 | `5, 6, 1` | **12** |

The answer is the maximum of these sums: `12`.

## 2. Why this is a sliding window

Imagine the array as a **circle**, where the end is next to the start. The `k` cards you take are one window of size `k` that **wraps around the ends**.

```
1 2 3 4 5 6 1
```
- `1 2 3` → first row of the table
- slide one step: `1 2 | 1` → second row
- slide again: `1 | 6 1` → third row
- slide again: `| 5 6 1` → fourth row

Each slide gives back one card on the front side and takes one more on the back side. So the window size stays fixed at `k`, and each new sum is an O(1) update.

## 3. The approach

1. `sum` = sum of the first `k` cards. This is choice 1 (all from the front). Set `maxScore = sum`.
2. For `i` from `1` to `k`:
   - **remove** `cardPoints[k - i]`: the front card that is no longer taken
   - **add** `cardPoints[n - i]`: the next card from the back
   - update `maxScore`

### Where do `k - i` and `n - i` come from?

Think of two pointers:
- `leftIndex` = index of the last front card taken. It starts at `k - 1`, then goes down by 1 each step: `k - 1`, `k - 2`, ..., `0`. At step `i` it is `k - i`.
- `rightIndex` = index of the next back card to take. It starts at `n - 1`, then goes down by 1 each step. At step `i` it is `n - i`.

## 4. Code

```java
int n = cardPoints.length;

int sum = 0;
for (int i = 0; i < k; i++) {
    sum += cardPoints[i];            // take all k cards from the front
}
int maxScore = sum;

for (int i = 1; i <= k; i++) {
    sum -= cardPoints[k - i];        // give back one front card
    sum += cardPoints[n - i];        // take one more back card
    maxScore = Math.max(maxScore, sum);
}
return maxScore;
```

## 5. Dry run: `[1, 2, 3, 4, 5, 6, 1]`, `k = 3`, `n = 7`

Start: `sum = 1 + 2 + 3 = 6`, `maxScore = 6`.

| i | removed `cardPoints[k-i]` | added `cardPoints[n-i]` | sum | maxScore |
|---|---|---|---|---|
| 1 | `cardPoints[2]` = 3 | `cardPoints[6]` = 1 | 6 − 3 + 1 = 4 | 6 |
| 2 | `cardPoints[1]` = 2 | `cardPoints[5]` = 6 | 4 − 2 + 6 = 8 | 8 |
| 3 | `cardPoints[0]` = 1 | `cardPoints[4]` = 5 | 8 − 1 + 5 = 12 | 12 |

The answer is `12`. The rows match the table in section 1.

## 6. Another view: leave the minimum in the middle (Approach 2)

### Key observation
Taking `k` cards from the ends is the same as **leaving `n - k` cards in the middle**.

- The cards left in the middle always form one **continuous subarray**.
- To maximize the score, **leave the minimum possible sum** in the middle.

```
Maximum Score = Total Sum - Minimum Subarray Sum (window size = n - k)
```

### Why a sliding window?
The middle cards are continuous, and we need the **minimum sum of a fixed-size subarray**. A sliding window does that in O(n) time and O(1) space.

### Steps
1. Compute `totalSum` of all cards.
2. If `k == n`, return `totalSum` (nothing is left in the middle).
3. Set `windowSize = n - k`.
4. Slide a window of that size and track the **minimum** window sum.
5. Return `totalSum - minWindowSum`.

### Code

```java
int n = cardPoints.length;

int totalSum = 0;
for (int val : cardPoints) {
    totalSum += val;
}

if (k == n) {
    return totalSum;
}

int windowSize = n - k;
int windowSum = 0;
int minWindowSum = Integer.MAX_VALUE;
int left = 0;

for (int right = 0; right < n; right++) {
    windowSum += cardPoints[right];                  // add the card on the right

    if (right - left + 1 == windowSize) {            // the window has reached its size
        minWindowSum = Math.min(minWindowSum, windowSum);
        windowSum -= cardPoints[left];               // drop the card on the left
        left++;
    }
}
return totalSum - minWindowSum;
```

### Example: `[1, 2, 3, 4, 5, 6, 1]`, `k = 3`
- `totalSum = 22`, `windowSize = 4`
- Windows of size 4: `1+2+3+4 = 10`, `2+3+4+5 = 14`, `3+4+5+6 = 18`, `4+5+6+1 = 16`
- Minimum window sum = `10`
- Answer = `22 - 10 = 12`

### Edge cases for this view
- `k = 0` → `windowSize = n`, the only window is the whole array, so the score is `0`.
- `k = n` → return `totalSum`.
- All values equal → any selection gives the same score.

### Pattern to remember
"Pick from the start or the end" and "exactly `k` elements" → **think in reverse**: remove a minimum-sum subarray from the middle.

Both views give the same answer. This second one is easier to remember, since it is the standard fixed-size window.

---

## 7. Complexity

- View 1 (the two ends): time O(k), space O(1).
- View 2 (the middle window): time O(n), space O(1).

**Edge cases:** `k == n` (take everything), `k = 1` (the better end), all values equal.

**Interview traps**
- Greedy "always take the bigger end" is **wrong**. Example `[1, 79, 80, 1, 1, 1, 200, 1]`, `k = 3`: greedy gets `160`, but the best is `202` (`1 + 200 + 1`).
- Not a normal middle window. The window **wraps around** the ends: remove `cardPoints[k - i]`, add `cardPoints[n - i]`.
- Don't try a "distinct elements" window. Nothing in the question is about distinct values. First ask: what is fixed? Here it's the total of `k` cards.
- In view 2, handle `n - k == 0` (an empty middle window).

**How to explain:** "Whatever I take, it's some cards from the front and the rest from the back. I start with all `k` from the front, then slide one card at a time from the front to the back, updating the sum in O(1) and tracking the best."
