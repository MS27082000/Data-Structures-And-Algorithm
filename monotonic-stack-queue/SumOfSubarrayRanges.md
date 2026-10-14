# Sum of Subarray Ranges (LC 2104)

**Problem:** The **range** of a subarray is `max − min`. Return the sum of ranges over all subarrays.

**Brute force:** Track running max and min for every subarray → O(n²). (Fine for n ≤ 1000, which is the LeetCode constraint.)
**Optimal:** `sum of ranges = (sum of all subarray MAXIMUMS) − (sum of all subarray MINIMUMS)`. Compute each with the **contribution technique** from [Sum of Subarray Minimums](SumOfSubarrayMinimums.md) using monotonic stacks → O(n).

**Intuition:** Linearity of summation: the sum of `(max − min)` equals the sum of maxes minus the sum of mins. Each half is a "how many subarrays is this element the extreme of" problem.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** All equal (0), a single element (0), negative numbers (the answer is still non-negative), large sums (**`long`**).

**Interview traps**
- Handle **ties** with a strict comparison on one side and non-strict on the other, for both max and min.
- Use `long`; the sum can reach ~10¹⁶ for large inputs.
- Start by saying the O(n²) solution passes the given constraints, then offer the O(n) one.
- Write one helper parameterised by max/min mode to avoid duplicating code.

**How to explain:** "The sum of ranges is the sum of all subarray maxima minus the sum of all subarray minima. I compute each using a monotonic stack to count, for every element, how many subarrays it's the max or the min of."
