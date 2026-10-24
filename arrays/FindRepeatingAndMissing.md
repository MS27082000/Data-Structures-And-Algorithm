# Find the Repeating and Missing Number

**Problem:** The array has size `n` and should contain `1..n`. One number appears **twice** and one number is **missing**. Return `[repeating, missing]`.

`[4, 3, 6, 2, 1, 1]` → `[1, 5]`

## Main approach: sum and sum of squares (O(1) space)

Let `x` = repeating number, `y` = missing number.

**Step 1: compare sums.**
If the array were perfect (`1..n`), its sum would be `n(n+1)/2`. The actual array has one extra `x` and lacks `y`, so:

```
actual sum - expected sum = x - y
```

**Step 2: compare sums of squares.**
The same idea with squares. Expected sum of squares is `n(n+1)(2n+1)/6`.

```
actual squares - expected squares = x² - y²
```

**Step 3: solve.**
`x² - y² = (x - y)(x + y)`, so dividing the second result by the first gives `x + y`. Now we have:

```
x - y = diff
x + y = sum
```

Add them: `2x = diff + sum`, so `x = (sum + diff) / 2`.
From `x - y = diff`: `y = x - diff`.

### Code
```java
long n = arr.length;
long expected = n * (n + 1) / 2;
long expectedSquares = n * (n + 1) * (2 * n + 1) / 6;

long actual = 0, actualSquares = 0;
for (int x : arr) {
    actual += x;
    actualSquares += (long) x * x;
}

long diff = actual - expected;                      // x - y
long squaresDiff = actualSquares - expectedSquares; // x² - y²
long sum = squaresDiff / diff;                      // x + y

long repeating = (sum + diff) / 2;                  // x
long missing = repeating - diff;                    // y
```

### Dry run: `[4, 3, 6, 2, 1, 1]`, n = 6

| Quantity | Value |
|---|---|
| expected sum `6·7/2` | 21 |
| expected squares `6·7·13/6` | 91 |
| actual sum | 17 |
| actual squares `16+9+36+4+1+1` | 67 |
| `diff = 17 - 21` | -4 (x - y) |
| `squaresDiff = 67 - 91` | -24 (x² - y²) |
| `sum = -24 / -4` | 6 (x + y) |
| `repeating = (6 + -4) / 2` | 1 |
| `missing = 1 - (-4)` | 5 |

Answer: `[1, 5]`.

**Complexity:** Time O(n), Space O(1).

**Interview traps**
- Both differences must be **actual minus expected**. If one is flipped, the sign of `sum` is wrong.
- Use `long`. The sum of squares overflows `int` for large `n`.
- `diff` is never 0, because exactly one value repeats and one is missing.

## Another approach: frequency array (O(n) space)

Count how many times each number appears.
- Count **2** → repeating.
- Count **0** → missing.

```java
int[] frequency = new int[n + 1];       // index 0 unused
for (int x : arr) frequency[x]++;

for (int v = 1; v <= n; v++) {
    if (frequency[v] == 2) repeating = v;
    else if (frequency[v] == 0) missing = v;
}
```

For `[4, 3, 6, 2, 1, 1]` the counts for `1..6` are `2, 1, 1, 1, 0, 1`, so `1` repeats and `5` is missing.

**Complexity:** Time O(n), Space O(n). Easier to think of, but uses extra space.

**Edge cases:** `[1, 1]` → `[1, 2]`. `[2, 2]` → `[2, 1]`. The repeating or missing number can be 1 or n.

**How to explain:** "The sums give `x - y`, the sums of squares give `x² - y²`, which divided gives `x + y`. Solve the two for x and y. O(n) time, O(1) space."
