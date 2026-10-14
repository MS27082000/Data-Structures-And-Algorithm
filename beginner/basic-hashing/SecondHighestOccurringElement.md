# Second Highest Occurring Element

**Problem:** Find the element with the second largest distinct frequency (-1 if it does not exist).

**Intuition:** Count frequencies; track the largest and the next distinct smaller frequency; return the smaller element on a tie.

**Approach / complexity:** O(n) time, O(n) space.

**Edge cases:** Only one distinct frequency -> -1. Ties.

**Interview traps**
- Second highest means the second distinct frequency, not the second element in sorted order.
- Handle the no-answer case.

**How to explain:** "I find the top two distinct frequencies in one pass over the counts."
