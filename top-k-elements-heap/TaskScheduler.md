# Task Scheduler (LC 621)

**Problem:** Tasks labelled `A–Z`; each takes one unit of time. The **same** task must be separated by at least `n` units (other tasks or idle). Return the minimum total time.

**Heap simulation:** Each tick, run the task with the **most remaining executions** (a max-heap of counts) so the cooldown never gets blocked by a lonely frequent task. After running, the task goes to a **cooldown queue** and re-enters the heap when its wait is over. If the heap is empty but the cooldown queue isn't, that tick is **idle** → O(m log 26).
**Greedy formula (O(m)):** The most frequent task (`maxFreq` times) forces `maxFreq − 1` frames of length `n + 1`, plus a final partial frame containing every task tied for the maximum:
`answer = max(tasks.length, (maxFreq − 1) · (n + 1) + tiedCount)`.

**Intuition:** The bottleneck is the most frequent task. Everything else can fill the gaps between its occurrences; if there are more tasks than gaps, no idling is needed and the answer is simply `tasks.length`.

**Complexity:** Formula O(m) time, O(1) space. Heap O(m log 26) ≈ O(m).

**Edge cases:** `n = 0` (answer = number of tasks), one task type, many distinct tasks (no idle), several tasks tied for the maximum frequency.

**Interview traps**
- The **`max(tasks.length, …)`** guard is essential. Without it the formula undercounts when idle slots are all filled.
- The **tied-count** term handles several tasks with the maximum frequency.
- Greedy choice: always schedule the task with the most remaining copies.
- Be ready to derive the formula with the `A B idle A B idle A B` picture.

**How to explain:** "The most frequent task determines the schedule: it needs n slots between its repeats. I fill those slots with other tasks, and any leftover slots are idle. The total is the larger of that frame count and the number of tasks."
