# Max Consecutive Ones III (LC 1004)

**Problem:** Binary array `nums`. You may flip at most `k` zeros to ones. Return the length of the longest subarray of 1s.

`[1,1,1,0,0,0,1,1,1,1,0]`, `k = 2` → `6`

## Idea

"Flip at most `k` zeros" is the same as "the window may contain **at most `k` zeros`**". After flipping them, the whole window is ones. So: find the **longest window with at most `k` zeros**.

## The three answers

| Question | Answer |
|---|---|
| What do I track (state)? | `zeros` = number of zeros in the window |
| When is the window invalid? | `zeros > k` |
| What changes when `left` leaves? | if `nums[left] == 0`, then `zeros--` |

## Steps

1. Move `right` one step. If `nums[right] == 0`, `zeros++`.
2. While `zeros > k`: if `nums[left] == 0`, `zeros--`. Then `left++`.
3. The window is valid now. Update `maxLen = max(maxLen, right - left + 1)`.

## Code

```java
int left = 0, zeros = 0, maxLen = 0;

for (int right = 0; right < nums.length; right++) {
    if (nums[right] == 0) zeros++;

    while (zeros > k) {
        if (nums[left] == 0) zeros--;
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
return maxLen;
```

## Dry run: `[1, 1, 0, 0, 1]`, `k = 1`

```
right=0 (1)  zeros=0  left=0  window [0..0]  length 1   maxLen=1
right=1 (1)  zeros=0  left=0  window [0..1]  length 2   maxLen=2
right=2 (0)  zeros=1  left=0  window [0..2]  length 3   maxLen=3
right=3 (0)  zeros=2 > 1, shrink:
               nums[0]=1 → left=1
               nums[1]=1 → left=2
               nums[2]=0 → zeros=1, left=3
                          window [3..3]  length 1   maxLen=3
right=4 (1)  zeros=1  left=3  window [3..4]  length 2   maxLen=3
```

Answer: `3`.

## Common mistakes

- Using `k` as the state and decrementing it. When `left` passes a zero, that flip should be given back, and a counter on `k` can't do that. Track `zeros` in the window.
- Not checking `nums[left] == 0` before `zeros--`.
- Skipping the `maxLen` update when `nums[right] == 1`.

## Non-shrinking variant (optional)

Use `if` instead of `while`. The window never gets smaller, it only slides, so `n - left` at the end is the answer. Same O(n), shorter code.

**Complexity:** Time O(n), space O(1).

**Edge cases:** `k = 0` (longest run of ones), all zeros, all ones, `k` larger than the number of zeros.

**How to explain:** "Flipping at most `k` zeros means the longest window with at most `k` zeros. I expand right, and when there are too many zeros I shrink from the left."
