# Capacity to Ship Packages Within D Days (LC 1011)

**Problem:** Packages with weights must be shipped **in the given order**. Each day the ship carries up to `capacity`. Find the least capacity to ship everything within `D` days.

**Brute force:** Try capacities from `max(w)` upward → O(n · sum).
**Optimal:** **Binary search on capacity** in `[max(w), sum(w)]`. Larger capacity needs fewer days → O(n log sum).

**Feasibility check (greedy):** Load packages in order. When adding the next one would exceed `capacity`, start a new day. Count the days.

**Intuition:** Lower bound `max(w)`: the ship must at least carry the heaviest package. Upper bound `sum(w)`: ship everything in one day.

**Complexity:** Time O(n log sum), Space O(1).

**Edge cases:** `D = 1` (answer = sum), `D = n` (answer = max), one package.

**Interview traps**
- The low bound is `max(w)`, **not 1**. A smaller capacity can't carry a package at all.
- Order is fixed, so greedy filling is correct (no reordering).
- **Same template** as Painter's Partition, Book Allocation, and Split Array Largest Sum. Learn it once.

**How to explain:** "Capacity monotonically reduces the days needed, so I binary search it. For each capacity I greedily simulate the days and compare with D."
