# Sum of Subarray Minimums (LC 907)

**Problem:** Sum `min(subarray)` over **all** contiguous subarrays, modulo 10⁹+7.

**Brute force:** Every subarray with a running minimum → O(n²).
**Optimal (contribution technique + monotonic stack):** Instead of summing per subarray, ask **"in how many subarrays is `arr[i]` the minimum?"**
- `left[i]` = number of choices for the left end = `i − (index of previous smaller element)`.
- `right[i]` = number of choices for the right end = `(index of next smaller-or-equal element) − i`.
- `arr[i]` is the minimum of `left[i] · right[i]` subarrays, so it contributes `arr[i] · left[i] · right[i]`.
Compute both arrays with monotonic stacks → O(n).

**Handling ties:** Use **strictly smaller on one side and smaller-or-equal on the other** so each subarray's minimum is counted for **exactly one** of its equal elements. (Without this, `[2,2,2]` double counts.)

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Equal elements (`[2,2,2]` → 12), a single element, increasing/decreasing arrays, large values (mod arithmetic).

**Interview traps**
- **Tie-breaking** is the key detail. Be able to explain the asymmetric `<` / `<=`.
- Use `long` and reduce **after each multiplication**: `arr[i] * left % MOD * right`.
- The left count is `i + 1` when there is no previous smaller; the right count is `n − i` when there is no next smaller.
- Same trick solves Sum of Subarray Maximums and, by subtraction, **Sum of Subarray Ranges**.

**How to explain:** "For each element I count the subarrays where it is the minimum: the number of left extensions times the number of right extensions before hitting a smaller element. I get those counts with two monotonic stacks and add `value × count`."
