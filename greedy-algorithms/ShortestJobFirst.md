# Shortest Job First (SJF) Scheduling

**Problem:** `n` jobs with burst times, all arriving at time 0, run one at a time without interruption. Choose the order that **minimises the average waiting time**. (Return the average, floored.)

**Brute force:** Try all `n!` orders → exponential.
**Optimal (greedy):** Run jobs in **ascending order of burst time**. A job's wait = the sum of all burst times before it → O(n log n).

**Why shortest first is optimal (exchange argument):** Each job's burst time is added to the waiting time of **every job after it**. Putting a long job early makes many jobs wait for it. Swapping an adjacent pair where the longer job is first always reduces total waiting time.

**Complexity:** Time O(n log n), Space O(1) extra.

**Edge cases:** One job (wait 0), equal burst times, empty input, large totals (use `long`).

**Interview traps**
- The **first** job always waits 0.
- Sum of waits can overflow `int`, so use `long`.
- SJF **minimises average waiting time** but can **starve** long jobs. Mention that and the preemptive version (SRTF).
- If jobs arrive at different times the problem needs a priority queue (this version assumes all at time 0).

**How to explain:** "A job's burst time delays everyone behind it, so I run the shortest jobs first. Sorting by burst time gives the minimum total waiting time."
