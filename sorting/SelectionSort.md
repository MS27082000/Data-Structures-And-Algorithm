# Selection Sort

**Idea:** Repeatedly *select* the minimum of the unsorted part and swap it to the front.

**Steps:** For `i = 0..n-2`: find the index of the minimum in `[i..n-1]`, swap it with `a[i]`. Left side `[0..i]` is final after each pass.

**Intuition:** After pass `i`, the `i+1` smallest elements are already in their final places.

**Complexity:** Time O(n²) in **all** cases (best too). Space O(1). Swaps: at most n-1.
**Stable?** No (the long-distance swap can jump over equal elements).

**When to use:** When writes/swaps are expensive (only n-1 swaps). Otherwise rarely.

**Edge cases:** Empty or 1 element, duplicates, already sorted (still O(n²)), reverse sorted.

**Interview traps**
- No early exit possible. It's O(n²) even when sorted (unlike bubble/insertion).
- Not stable. Say this when asked.
- Swap only once per pass, after the inner loop finishes.

**How to explain:** "Each pass finds the smallest remaining element and puts it next in line. Simple, in-place, O(n²), but does the fewest swaps."
