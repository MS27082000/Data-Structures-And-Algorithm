# N Meetings in One Room

**Problem:** `n` meetings with start and end times. One room. Find the **maximum number of meetings** that can be held. (A meeting can start only after the previous one has ended.)

**Brute force:** Try all subsets and check each for conflicts → O(2ⁿ · n).
**Optimal (greedy):** **Activity selection.** Sort meetings by **end time**; pick a meeting if its start is **after** the end of the last picked one → O(n log n).

**Why end time:** The meeting that ends earliest frees the room soonest, leaving the maximum time for everything else. (Exchange argument: replacing the first meeting of any optimal solution with the earliest-ending one never hurts.)

**Complexity:** Time O(n log n), Space O(n) for the index array.

**Edge cases:** One meeting, all overlapping (answer 1), identical times, back-to-back meetings (`end == next start`: **the sheet's version requires strictly after**, so they conflict), empty input.

**Interview traps**
- Sort by **end time**, with ties broken by start time.
- Clarify strict vs non-strict: `start > lastEnd` here (GfG). For LeetCode-style "touching is fine" use `start >= lastEnd`.
- You must sort the **pairs together**. Sorting the two arrays separately destroys the pairing.
- Print the meeting indices if asked, so keep the original indices.
- Related: Non-overlapping Intervals, Minimum Platforms, Meeting Rooms I/II.

**How to explain:** "Sort meetings by finish time and greedily take each one that starts after the last chosen one ends. Finishing earliest leaves the most room for the rest."
