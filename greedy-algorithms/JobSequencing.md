# Job Sequencing Problem

**Problem:** Each job takes 1 unit of time, has a **deadline** and a **profit** (earned only if finished by the deadline). One job at a time. Maximise total profit. Return the number of jobs done and the maximum profit.

**Brute force:** Try every subset and every order → exponential.
**Optimal (greedy):** Sort jobs by **profit, descending**. For each job, put it in the **latest free slot on or before its deadline**; if none is free, skip it → O(n log n + n·D) with a simple slot array (D = max deadline).

**Why the latest free slot:** It leaves earlier slots free for jobs with tighter deadlines.

**Better data structure:** **Disjoint Set Union** to find the latest free slot in near O(1) → O(n log n) overall.

**Complexity:** Time O(n log n + n·D), Space O(D).

**Edge cases:** All deadlines 1 (only one job fits), deadlines larger than `n`, equal profits, empty input.

**Interview traps**
- Sort by **profit** (not by deadline).
- Search from `min(deadline, maxDeadline)` **downwards** to find a free slot.
- Don't confuse with Activity Selection (sort by end time) or Scheduling with different durations.
- Mention the DSU optimisation if asked to improve the inner loop.

**How to explain:** "I consider jobs from most to least profitable. Each one goes into the latest free time slot before its deadline, which keeps earlier slots available for other jobs. If no slot is free, I skip it."
