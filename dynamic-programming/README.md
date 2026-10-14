# Dynamic Programming

Source: Striver's A2Z DSA Sheet, Dynamic Programming (53 items) plus the Kadane problems from Arrays. Active recall: open a folder, pick a question, solve it from scratch, then check the notes.

## The 5-step recipe
1. **State** - what does `f(...)` mean?
2. **Recurrence** - how does it use smaller states?
3. **Base cases**
4. **Order** - memoisation (top-down) or tabulation (bottom-up)
5. **Space** - keep only the rows you need (rolling array)

## Which folder?
| If the question looks like... | Folder |
|---|---|
| Fibonacci, pick or skip, stairs | [introduction](introduction/README.md), [1d-dp](1d-dp/README.md) |
| Choice depends on the previous choice | [2d-dp](2d-dp/README.md) |
| Walk on a grid or triangle | [grid-dp](grid-dp/README.md) |
| Buy and sell | [stocks](stocks/README.md) |
| Subset, partition, target sum (items used once) | [0-1-knapsack](0-1-knapsack/README.md) |
| Coins, items reusable | [unbounded-knapsack](unbounded-knapsack/README.md) |
| Longest chain ending at i | [lis](lis/README.md) |
| Two strings, common part | [longest-common-subsequence](longest-common-subsequence/README.md) |
| Edit, match, segment strings | [dp-on-strings](dp-on-strings/README.md) |
| Split a range at every point | [matrix-chain-multiplication](matrix-chain-multiplication/README.md) |
| Max subarray / product | [kadane-subarray](kadane-subarray/) |

## Loop direction cheat sheet
- 0/1 knapsack in 1D: capacity **downwards**.
- Unbounded: capacity **upwards**.
- Combinations: items outer. Permutations: target outer.
