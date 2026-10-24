# Trapping Rain Water (LC 42)

**Problem:** Each value in `height` is the height of a bar of width 1. After it rains, how much water is trapped between the bars?

`[4, 2, 0, 3, 2, 5]` → `9`

```
5 |  .  .  .  .  .  █
4 |  █  ~  ~  ~  ~  █
3 |  █  ~  ~  █  ~  █
2 |  █  █  ~  █  █  █
1 |  █  █  ~  █  █  █
     4  2  0  3  2  5      █ = bar, ~ = water
```

Water cells: 4 + 3 + 1 + 1 = 9.

---

## 1. The key idea: water on top of ONE bar

Forget the whole picture. Look at a single bar at index `i`.

Water above it can rise only until it spills over a wall. There is one wall on each side:
- `maxLeft` = the tallest bar to its left (including itself)
- `maxRight` = the tallest bar to its right (including itself)

Water spills over the **shorter** of those two walls, so the water level is `min(maxLeft, maxRight)`. The water **above** the bar is the level minus the bar's own height:

```
water[i] = min(maxLeft, maxRight) - height[i]
```

The answer is the sum of `water[i]` over all bars. (It can never be negative, because each max includes the bar itself.)

**Example:** bar at index 2 (height 0) in `[4, 2, 0, 3, 2, 5]`.
- `maxLeft = 4`, `maxRight = 5`
- level = `min(4, 5) = 4`
- water = `4 - 0 = 4`

---

## 2. Approach 1: brute force, O(n²)

For every `i`, scan left to find `maxLeft`, scan right to find `maxRight`, apply the formula. Easy, but slow, because the scans repeat the same work for every bar.

## 3. Approach 2: prefix and suffix arrays, O(n) time, O(n) space

Store the maxima once, instead of scanning each time.

- `leftMax[i]` = tallest bar from index 0 to `i`
- `rightMax[i]` = tallest bar from index `i` to the end

For `[4, 2, 0, 3, 2, 5]`:

| i | 0 | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|---|
| height | 4 | 2 | 0 | 3 | 2 | 5 |
| leftMax | 4 | 4 | 4 | 4 | 4 | 5 |
| rightMax | 5 | 5 | 5 | 5 | 5 | 5 |
| min(leftMax, rightMax) | 4 | 4 | 4 | 4 | 4 | 5 |
| water = min − height | 0 | 2 | 4 | 1 | 2 | 0 |

Sum: `0 + 2 + 4 + 1 + 2 + 0 = 9`. Correct.

Now the question is how to get rid of those two extra arrays.

---

## 4. Approach 3: two pointers, O(n) time, O(1) space

Use `left = 0` and `right = n - 1`, and two running variables, `leftMax` and `rightMax`. Each is the tallest bar seen so far **from its own side**.

**Rule:** compare `height[left]` and `height[right]`. Process the **smaller** side.

```java
if (height[left] < height[right]) {
    // process the left bar
    if (height[left] >= leftMax) leftMax = height[left];   // new tallest wall, no water here
    else water += leftMax - height[left];                  // a wall exists, so water fills up to leftMax
    left++;
} else {
    // process the right bar, same idea, mirrored
    if (height[right] >= rightMax) rightMax = height[right];
    else water += rightMax - height[right];
    right--;
}
```

### Why is it safe to use only `leftMax` for the left bar?

The formula needs `min(maxLeft, maxRight)`. We only know `leftMax`, and not the true `maxRight`. Here's why that is enough.

When `height[left] < height[right]`:
- There is a bar on the right (`height[right]`) that is **taller** than the current left bar.
- The `leftMax` we hold was recorded earlier, when some bar on the right was already taller than it. That bar is still on the right.

So the right side has a wall at least as tall as `leftMax`. This means the **left** wall is the shorter one, and the water level is decided by `leftMax` alone: `water = leftMax - height[left]`. We don't need to know the exact `maxRight`.

The mirror argument applies when `height[right] <= height[left]`: the left side has a wall at least as tall as `rightMax`, so `rightMax` decides the level.

In one sentence: **always process the side whose current bar is smaller, because that side's max is the real limit.**

---

## 5. Dry run 1: `[4, 2, 0, 3, 2, 5]`

Start: `left = 0`, `right = 5`, `leftMax = 0`, `rightMax = 0`, `water = 0`.

| step | left | right | h[left] | h[right] | side | action | water |
|---|---|---|---|---|---|---|---|
| 1 | 0 | 5 | 4 | 5 | left (4 < 5) | 4 ≥ leftMax(0), so `leftMax = 4` | 0 |
| 2 | 1 | 5 | 2 | 5 | left | 2 < 4, so `water += 4 − 2 = 2` | 2 |
| 3 | 2 | 5 | 0 | 5 | left | `water += 4 − 0 = 4` | 6 |
| 4 | 3 | 5 | 3 | 5 | left | `water += 4 − 3 = 1` | 7 |
| 5 | 4 | 5 | 2 | 5 | left | `water += 4 − 2 = 2` | 9 |
| | 5 | 5 | | | | `left == right`, stop | **9** |

## 6. Dry run 2 (the right side is used): `[4, 0, 2, 0, 3]`

Start: `left = 0`, `right = 4`, `leftMax = 0`, `rightMax = 0`, `water = 0`.

| step | left | right | h[left] | h[right] | side | action | water |
|---|---|---|---|---|---|---|---|
| 1 | 0 | 4 | 4 | 3 | right (4 is not < 3) | 3 ≥ rightMax(0), so `rightMax = 3` | 0 |
| 2 | 0 | 3 | 4 | 0 | right | 0 < 3, so `water += 3 − 0 = 3` | 3 |
| 3 | 0 | 2 | 4 | 2 | right | `water += 3 − 2 = 1` | 4 |
| 4 | 0 | 1 | 4 | 0 | right | `water += 3 − 0 = 3` | 7 |
| | 0 | 0 | | | | `left == right`, stop | **7** |

Check with the table method: `leftMax = [4,4,4,4,4]`, `rightMax = [4,3,3,3,3]`, `min = [4,3,3,3,3]`, minus heights `[4,0,2,0,3]` gives `[0,3,1,3,0]` = 7. ✓

---

## 7. Complexity

Each step moves one pointer, and the pointers move toward each other, so there are at most `n` steps. Time O(n), space O(1).

**Edge cases:** fewer than 3 bars (0 water), strictly increasing or decreasing heights (0 water), all bars equal, one deep pit in the middle.

**Interview traps**
- Interviewers usually ask you to go from O(n) space to O(1). Walk through brute force, then prefix and suffix arrays, then two pointers.
- The thing to justify is **why the smaller side is processed**. Use the argument in section 4.
- Don't confuse it with Container With Most Water. That one picks **two** lines and ignores the bars between them. This one fills **every** gap.
- A bar that is taller than or equal to its max adds **no** water. It just becomes the new max.

**How to explain:** "Water on a bar is the shorter of the two tallest walls around it, minus the bar's height. With two pointers, I process the side whose current bar is smaller, because the wall on the other side is at least as tall, so my side's max is the real limit. O(n) time, O(1) space."
