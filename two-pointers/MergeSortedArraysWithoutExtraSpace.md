# Merge Two Sorted Arrays Without Extra Space

**Problem:** `a` (size `n`) and `b` (size `m`) are both sorted. Merge them **in place** so that `a` holds the smallest `n` values and `b` holds the largest `m` values, with both arrays sorted. No third array.

`a = [2, 4, 7, 10]`, `b = [2, 3]` → `a = [2, 2, 3, 4]`, `b = [7, 10]`

## 1. Approaches

1. **Brute force:** merge into a third array, then copy back. O(n + m) time, but O(n + m) space, which is not allowed.
2. **Swap + sort (this section teaches this):** O(min(n,m) + n log n + m log m) time, O(1) space.
3. **Gap method:** O((n + m) log(n + m)) time, O(1) space. No sorting step.

---

## 2. Approach 1: swap the wrong numbers, then sort

### Step 1: what is the goal?

Take `a = [1, 5, 9]`, `b = [2, 3]`.

Merged and sorted: `[1, 2, 3, 5, 9]`. `a` must keep the first 3, and `b` must get the last 2:

```
a should be [1, 2, 3]
b should be [5, 9]
```

Right now `5` and `9` sit in `a`, but they belong in `b`. And `2` and `3` sit in `b`, but they belong in `a`.

**The whole problem is: move the wrong numbers to the other array.**

### Step 2: where are the wrong numbers?

- `a` is sorted, so its **biggest** numbers are at its **end**. The big ones are the ones that may belong in `b`.
- `b` is sorted, so its **smallest** numbers are at its **start**. The small ones are the ones that may belong in `a`.

So we only compare:
- the **last** element of `a`, and
- the **first** element of `b`.

If `a`'s last is **bigger** than `b`'s first, both are in the wrong array, so swap them. Then compare the next pair: the second-last of `a` with the second of `b`.

We **stop** when `a`'s element is **not bigger** than `b`'s. That means everything left is already in the right array.

### Step 3: do the swaps with two pointers

- `i` = last index of `a` (`n - 1`)
- `j` = first index of `b` (`0`)

While `a[i] > b[j]`: swap them, `i--`, `j++`.

Example `a = [1, 5, 9]`, `b = [2, 3]`:

| i | j | a[i] | b[j] | action | a | b |
|---|---|---|---|---|---|---|
| 2 | 0 | 9 | 2 | 9 > 2, swap, `i--`, `j++` | `[1, 5, 2]` | `[9, 3]` |
| 1 | 1 | 5 | 3 | 5 > 3, swap, `i--`, `j++` | `[1, 3, 2]` | `[9, 5]` |
| 0 | 2 | | | `j == m`, stop | | |

Now every number in `a` is smaller than every number in `b`. But the order **inside** each array is broken (`3, 2` and `9, 5`).

### Step 4: sort both arrays

Sort `a` and sort `b` separately:

```
a = [1, 3, 2]  →  [1, 2, 3]
b = [9, 5]     →  [5, 9]
```

Result: `a = [1, 2, 3]`, `b = [5, 9]`. Matches the goal from Step 1.

### Why is it correct?

When the loop stops, split the numbers into four groups:

| Group | Where | Why it is small / big |
|---|---|---|
| unswapped part of `a` (`a[0..i]`) | in `a` | sorted, and `a[i] <= b[j]`, so all are small |
| numbers swapped into `a` (old `b[0..j-1]`) | in `a` | each was smaller than the `a` number it replaced |
| unswapped part of `b` (`b[j..]`) | in `b` | sorted, and `b[j] >= a[i]`, so all are big |
| numbers swapped into `b` (old `a[i+1..]`) | in `b` | each was bigger than the `b` number it replaced |

So everything in `a` is `<=` everything in `b`. The loop never changes **which numbers** are in each array beyond that, so after sorting each array we get the right answer.

---

## 3. Code (Approach 1)

```java
public void merge(long[] a, long[] b) {
    int n = a.length, m = b.length;
    int i = n - 1;        // last index of a (its biggest)
    int j = 0;            // first index of b (its smallest)

    while (i >= 0 && j < m && a[i] > b[j]) {
        long temp = a[i];
        a[i] = b[j];
        b[j] = temp;
        i--;
        j++;
    }

    Arrays.sort(a);
    Arrays.sort(b);
}
```

The loop condition has three parts:
- `i >= 0`: we haven't run off the left end of `a`.
- `j < m`: we haven't run off the right end of `b`.
- `a[i] > b[j]`: the pair is still in the wrong place.

## 4. Dry runs

**A. `a = [2, 4, 7, 10]`, `b = [2, 3]`**

| i | j | a[i] | b[j] | action | a | b |
|---|---|---|---|---|---|---|
| 3 | 0 | 10 | 2 | 10 > 2, swap | `[2, 4, 7, 2]` | `[10, 3]` |
| 2 | 1 | 7 | 3 | 7 > 3, swap | `[2, 4, 3, 2]` | `[10, 7]` |
| 1 | 2 | | | `j == m`, stop | | |

Sort `a` → `[2, 2, 3, 4]`. Sort `b` → `[7, 10]`. ✓

**B. Already in order: `a = [0, 1]`, `b = [2, 3]`**

- `i = 1`, `j = 0`: `a[1] = 1 > b[0] = 2`? No. Stop at once.
- Sorting does nothing. Result `a = [0, 1]`, `b = [2, 3]`. ✓

**C. Everything in `b` is smaller: `a = [5, 6]`, `b = [1, 2]`**

- `i = 1`, `j = 0`: `6 > 1`, swap → `a = [5, 1]`, `b = [6, 2]`.
- `i = 0`, `j = 1`: `5 > 2`, swap → `a = [2, 1]`, `b = [6, 5]`.
- `i = -1`: stop. Sort → `a = [1, 2]`, `b = [5, 6]`. ✓

## 5. Complexity (Approach 1)

- Swap loop: at most `min(n, m)` steps.
- Sorting: `O(n log n + m log m)`.
- Extra space: O(1).

---

## 6. Approach 2: the gap method (no sorting step)

Treat `a` followed by `b` as **one long array** of length `total = n + m`. Index `k < n` is `a[k]`, and index `k >= n` is `b[k - n]`.

**Idea:** compare elements that are `gap` apart, and swap if the left one is bigger. Start with a big gap and halve it each round, down to 1. This is the idea behind Shell sort. When the gap is 1, the array is sorted.

**Steps:**
- `gap = ceil(total / 2)`, written as `(total + 1) / 2`.
- Repeat: set `l = 0`, `r = gap`. While `r < total`, compare the elements at `l` and `r`, swap if `left > right`, then `l++`, `r++`.
- Then `gap = (gap + 1) / 2`. Stop after the round with `gap == 1`.

**Three cases for comparing positions `l` and `r`:**
- `l` in `a` and `r` in `b` (`l < n` and `r >= n`): compare `a[l]` with `b[r - n]`.
- Both in `b` (`l >= n`): compare `b[l - n]` with `b[r - n]`.
- Both in `a`: compare `a[l]` with `a[r]`.

**Dry run:** `a = [1, 4]`, `b = [2, 3]`, `total = 4`, `gap = 2`

| gap | l | r | compare | action | a | b |
|---|---|---|---|---|---|---|
| 2 | 0 | 2 | `a[0]=1` vs `b[0]=2` | 1 > 2? no | `[1, 4]` | `[2, 3]` |
| 2 | 1 | 3 | `a[1]=4` vs `b[1]=3` | 4 > 3, swap | `[1, 3]` | `[2, 4]` |
| 1 | 0 | 1 | `a[0]=1` vs `a[1]=3` | no | `[1, 3]` | `[2, 4]` |
| 1 | 1 | 2 | `a[1]=3` vs `b[0]=2` | 3 > 2, swap | `[1, 2]` | `[3, 4]` |
| 1 | 2 | 3 | `b[0]=3` vs `b[1]=4` | no | `[1, 2]` | `[3, 4]` |

Gap 1 is done, so stop. Result: `a = [1, 2]`, `b = [3, 4]`. ✓

**Cost:** about `log(n + m)` rounds, each O(n + m), so O((n + m) log(n + m)). Space O(1).

---

**Edge cases:** already in order (no swaps), all of `b` smaller than all of `a`, unequal sizes, duplicates.

**Interview traps**
- Approach 1: don't forget the final sort of **both** arrays.
- Approach 1: the loop must check `i >= 0` and `j < m`, or you go out of bounds.
- Gap method: handle all three comparison cases (`a` vs `a`, `a` vs `b`, `b` vs `b`). Missing one is the usual bug.
- Gap method: update with `(gap + 1) / 2` (ceil), and stop **after** processing gap 1.
- This is different from LC 88, where `a` has spare space at its end and you merge from the back.

**How to explain:** "The biggest numbers of `a` and the smallest of `b` are the only ones that can be in the wrong array. I swap those pairs from the outside in until nothing is wrong, then sort each array. The gap method does the same in O((n + m) log(n + m)) without a sort call."
