# Rotate Array by K Places (Left and Right)

**Problem:** Rotate the array by `k` places, in place.
- Left rotate: `[1,2,3,4,5,6,7], k=3` → `[4,5,6,7,1,2,3]` (the first 3 go to the back)
- Right rotate (LeetCode 189): `[1,2,3,4,5,6,7], k=3` → `[5,6,7,1,2,3,4]` (the last 3 go to the front)

---

## Step 0: Reduce k

Rotating by `n` puts every element back where it started. So rotating by `k` is the same as rotating by `k % n`.
Example: `n = 7`, `k = 10` → `k % 7 = 3`. After this, `k` is always in `0..n-1`.
(Note it is `k % n`, not `n % k`.) If `k` becomes 0, return, there is nothing to do.

## Approaches

**1. Brute force:** rotate by one, `k` times. O(n·k) time, O(1) space.

**2. Extra array:** copy each element straight to its new position `(i + k) % n` in a new array. O(n) time, O(n) space.

**3. Reversal trick (optimal):** O(n) time, O(1) space. This is the one to learn.

---

## The reversal trick

A left rotation by `k` cuts the array into two blocks:

```
[ A | B ]    A = first k elements, B = the remaining n-k
```

and the answer is the blocks swapped: `[ B | A ]`.

You can swap the blocks with three reversals:

1. reverse `A`
2. reverse `B`
3. reverse the whole array

### Worked example: `[1,2,3,4,5,6,7]`, k = 3 (left)

```
A = [1,2,3]   B = [4,5,6,7]

start               1 2 3 | 4 5 6 7
reverse A (0..2)    3 2 1 | 4 5 6 7
reverse B (3..6)    3 2 1 | 7 6 5 4
reverse all (0..6)  4 5 6 7 | 1 2 3        <- B A
```

### Why does this work?

Reversing a sequence flips its order. Reversing a concatenation also swaps its parts:

```
reverse(X Y) = reverse(Y) reverse(X)
```

After steps 1 and 2 we hold `rev(A) rev(B)`. Reverse it as a whole and we get `rev(rev(B)) rev(rev(A))` = `B A`. Reversing something twice gives back the original, so the blocks come out in their original order, only swapped.

---

## Code, line by line

```java
k = k % n;                 // step 0: k is now in 0..n-1
if (k == 0) return;

reverse(a, 0, k - 1);      // reverse A  (indices 0..k-1)
reverse(a, k, n - 1);      // reverse B  (indices k..n-1)
reverse(a, 0, n - 1);      // reverse the whole array
```

`reverse(a, l, r)` uses two pointers: `l` at the left end and `r` at the right end. It swaps `a[l]` and `a[r]`, then moves `l` right and `r` left, until they meet. Each element is touched once, so it is O(length).

## Right rotation (LeetCode 189)

For a right rotation the blocks are different. The **last `k`** elements must go to the front:

```
[ A | B ]    A = first n-k elements, B = last k elements    ->    [ B | A ]
```

The same three reversals apply, only the split point changes:

```java
reverse(a, 0, n - k - 1);  // reverse A
reverse(a, n - k, n - 1);  // reverse B
reverse(a, 0, n - 1);      // reverse all
```

```
[1,2,3,4,5,6,7], k = 3     A = [1,2,3,4]   B = [5,6,7]

reverse A    4 3 2 1 | 5 6 7
reverse B    4 3 2 1 | 7 6 5
reverse all  5 6 7 | 1 2 3 4
```

A right rotation by `k` equals a left rotation by `n - k`.

---

## Left vs Right at a glance

**Same trick, different split point.** Always: reverse block 1, reverse block 2, reverse everything. Only the cut position changes.

Example: `[1,2,3,4,5,6,7]`, `k = 3`

| | Left rotate | Right rotate |
|---|---|---|
| Moves | first `k` go to the back | last `k` go to the front |
| Block A | `a[0 .. k-1]` = `[1,2,3]` | `a[0 .. n-k-1]` = `[1,2,3,4]` |
| Block B | `a[k .. n-1]` = `[4,5,6,7]` | `a[n-k .. n-1]` = `[5,6,7]` |
| Goal | `A B → B A` | `A B → B A` |
| Result | `[4,5,6,7,1,2,3]` | `[5,6,7,1,2,3,4]` |

- **Left:** cut after `k` elements. A is the first `k` and ends up at the back.
- **Right:** cut after `n-k` elements. B is the last `k` and ends up at the front.
- **Shortcut:** right rotate by `k` = left rotate by `n - k`. For `n = 7`, right by 3 = left by 4.

---

**Complexity:** three reversals touch about `2n` elements in total, so O(n) time. Only a few variables are used, so O(1) space.

**Edge cases:** `k = 0`, `k = n`, `k > n` (use `k % n`), empty array, single element.

**Interview traps**
- Do `k = k % n` first, or indices go out of bounds.
- Know which block is which: left rotation splits at `k`, right rotation splits at `n - k`.
- Be ready to explain **why** three reversals give `B A`.

**How to explain:** "Cut the array into two blocks. Reverse each block, then reverse the whole array. That swaps the two blocks in place in linear time."
