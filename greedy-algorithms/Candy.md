# Candy (LC 135)

**Problem:** Children stand in a line with ratings. Each gets at least 1 candy, and a child with a **higher rating than a neighbour** must get **more candy than that neighbour**. Minimise the total candy.

**Brute force:** Repeatedly fix violations until none remain → O(n²) in the worst case.
**Optimal (two passes) O(n) time, O(n) space:**
1. Left → right: if `rating[i] > rating[i-1]` then `candy[i] = candy[i-1] + 1`.
2. Right → left: if `rating[i] > rating[i+1]` then `candy[i] = max(candy[i], candy[i+1] + 1)`.
Sum the candies.

**Intuition:** The rule has two sides (left neighbour and right neighbour). Handle each side in its own pass, then take the max so both constraints hold.

**O(1) space version:** Treat the ratings as slopes. Each upward slope adds 1, 2, 3, … and each downward slope adds the same in reverse. The **peak** belongs to the longer slope (the code subtracts one if the up-slope was already at least as long as the down-slope).

**Complexity:** Two-pass: Time O(n), Space O(n). Slope version: O(n), O(1).

**Edge cases:** One child, all equal ratings (everyone gets 1, since equal ratings have no constraint), strictly increasing or decreasing, a peak or valley.

**Interview traps**
- **Equal ratings impose no constraint.** Don't force more candy.
- In pass 2 use **`max`** with the existing value. Overwriting breaks the left-pass result.
- Start `candies` filled with 1, not 0.
- Total can be O(n²) for a strictly increasing sequence, so use `long` only if n is huge (LeetCode: `int` is fine).

**How to explain:** "One pass left to right makes sure each child with a higher rating than their left neighbour has more candy, and one pass right to left does the same for the right neighbour. Taking the max of the two satisfies both, with the minimum total."
