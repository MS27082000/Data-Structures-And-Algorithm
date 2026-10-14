# Fractional Knapsack

**Problem:** `n` items with a value and weight. A knapsack holds weight `W`. You **may take fractions** of items. Maximise the total value.

**Brute force:** Not applicable directly. Fractions make the choice continuous.
**Optimal (greedy):** Sort items by **value / weight** (descending). Take whole items while they fit; for the first that doesn't fit, take the fraction that fills the remaining capacity → O(n log n).

**Why greedy works:** Because items are divisible, every unit of capacity should go to the item with the best value per unit weight. No better use of capacity exists. (The **0/1** knapsack, where items can't be split, breaks this argument and needs DP.)

**Complexity:** Time O(n log n), Space O(n) for the index ordering.

**Edge cases:** Capacity 0, everything fits (take it all), zero-weight items (division by zero, so check), a single item.

**Interview traps**
- Compare ratios as `double` (`(double) v / w`). Integer division loses the ratio.
- Sort **by ratio**, not by value or by weight alone.
- Know the difference from **0/1 Knapsack**: greedy fails there (e.g. values 60,100,120 / weights 10,20,30 / W=50 gives 220 for 0/1 but 240 fractional).
- Return a `double`.

**How to explain:** "Rank items by value per kilogram and fill the bag greedily. When the next item doesn't fit entirely, I take just enough of it to fill the remaining space."
