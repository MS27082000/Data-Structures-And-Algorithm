# Maximum Points You Can Obtain from Cards (LC 1423)

**Problem:** Cards in a row with points. In `k` moves you take a card from either the **front** or the **back**. Maximise the total points of the `k` cards.

**Brute force:** Recursion over (front, back) choices → O(2ᵏ).
**Optimal:** Any choice is "`i` cards from the front + `k − i` from the back". Start with all `k` from the front, then move one card at a time from the front end to the back end, tracking the best sum → O(k), O(1).

**Equivalent view:** The `n − k` cards you **don't** take form a **contiguous** window. Maximise taken = `total − (minimum window sum of size n − k)`. This is a classic fixed-size sliding window.

**Intuition:** Taking from both ends always leaves a contiguous middle block, so the problem is hidden inside a fixed window.

**Complexity:** Time O(k) (or O(n) for the complement version), Space O(1).

**Edge cases:** `k == n` (take everything), `k = 1` (best end), all equal values.

**Interview traps**
- Greedy "take the larger end each time" is **wrong** (`[1,79,80,1,1,1,200,1]`, k=3).
- The sliding "window" wraps around the ends: drop `cardPoints[k - i]`, add `cardPoints[n - i]`.
- If `n − k == 0`, the complement window is empty, so return the total.

**How to explain:** "The cards I skip are one contiguous block in the middle. So I can slide a window from taking all k from the front to all k from the back, updating the sum in O(1) each step."
