# Max Consecutive Ones III (LC 1004)

**Problem:** Binary array. You may flip at most `k` zeros to ones. Return the length of the longest subarray of 1s.

**Brute force:** For every start, extend while zeros used ≤ k → O(n²).
**Optimal:** Longest window containing **at most `k` zeros** → O(n), O(1).

**Steps:** Expand `right`. If `nums[right] == 0`, `zeros++`. While `zeros > k`: if `nums[left] == 0`, `zeros--`; `left++`. Record `right - left + 1`.

**Intuition:** "Flip at most k zeros" is the same as "the window may contain at most k zeros". After flipping them, the entire window is ones.

**Non-shrinking trick:** Replace `while` with `if`. The window never shrinks, only slides, and `n − left` at the end is the answer. It's the same complexity, with simpler code.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** `k = 0` (longest run of ones), all zeros with `k ≥ length`, all ones, `k` larger than the number of zeros.

**Interview traps**
- Track the **count of zeros**, not the positions of flipped ones.
- Update the zero count in **both** the expand and shrink steps.
- Generalises: Longest Repeating Character Replacement, Longest Subarray of 1s After Deleting One Element.

**How to explain:** "Flipping at most k zeros means finding the longest window with at most k zeros. I expand right, and when the window has too many zeros I shrink from the left."
