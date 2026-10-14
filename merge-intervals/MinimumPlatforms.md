# Minimum Number of Platforms Required for a Railway Station

**Problem:** Given arrival and departure times of trains, find the minimum number of platforms so that no train waits.

**Brute force:** For each train count how many others overlap it → O(n²).
**Optimal (sort + two pointers):** Sort **arrivals** and **departures separately**. Sweep with two pointers like merging:
- `arr[i] <= dep[j]` → a train arrives before the earliest departure → platforms++ and `i++`
- else → a train has left → platforms-- and `j++`
Track the maximum.

**Intuition:** The answer is the **maximum number of trains present at the same time** (maximum overlap). You don't need to know which arrival pairs with which departure, only the counts over time.

**Alternatives:** Events array (+1 for arrival, -1 for departure) sorted by time; or a min-heap of departure times (Meeting Rooms II).

**Complexity:** Time O(n log n), Space O(1) extra (O(n) if you copy the arrays).

**Edge cases:** All trains overlapping (answer n), none overlapping (1), a train arriving exactly when another departs (**needs its own platform** with `<=`), empty input.

**Interview traps**
- Sorting the arrays **independently** is correct here (counts only), unlike Merge Intervals.
- Tie handling: `arr <= dep` counts an arrival at the same time as a departure as overlapping (GfG). Clarify the rule.
- Update the maximum after every step.
- Same idea as **Meeting Rooms II** (LC 253).

**How to explain:** "The platforms needed equal the maximum number of trains present at once. I sort arrivals and departures separately and sweep through time: an arrival adds a train, a departure removes one, and I track the peak."
