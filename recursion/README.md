# Recursion

Source: Striver's A2Z DSA Sheet, Recursion section (22 items). The 7 pure recursion questions are here; the 15 "choose, explore, undo" questions are in [backtracking](../backtracking/README.md).
Active recall: open the link, solve from scratch, then check the notes.

## How to think about recursion
1. **Base case**: when to stop.
2. **Smaller subproblem**: how the problem shrinks.
3. **Combine / record**: what to do with the result.
- Draw the recursion tree for small inputs. Count the nodes for complexity.
- Time ≈ (branches)^(depth); space = depth of the call stack.

## Questions here
| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Pow(x, n)](PowXN.md) | [LC 50](https://leetcode.com/problems/powx-n/) | Fast exponentiation | O(log n) | O(log n) |
| 2 | [Count Good Numbers](CountGoodNumbers.md) | [LC 1922](https://leetcode.com/problems/count-good-numbers/) | 5^even · 4^odd, mod power | O(log n) | O(1) |
| 3 | [Reverse a Stack](ReverseStack.md) | [GfG](https://www.geeksforgeeks.org/problems/reverse-a-stack/1) | Insert at bottom | O(n²) | O(n) |
| 4 | [Learn All Patterns of Subsequences](SubsequencePatterns.md) | Theory | Take / not take | O(n·2ⁿ) | O(n) |
| 5 | [Subsequence with Sum K (exists)](SubsequenceSumK.md) | [GfG](https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1) | Take / not take, return boolean | O(2ⁿ) | O(n) |
| 6 | [Count Subsequences with Sum K](CountSubsequencesSumK.md) | [GfG](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1) | Take / not take, return count | O(2ⁿ), O(n·K) memoised | O(n) |
| 7 | [Binary Strings Without Consecutive 1s](BinaryStringsNoConsecutiveOnes.md) | [GfG](https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1) | Constrained generation | O(n·F(n)) | O(n) |

## Where the other Recursion-section questions went
| Question | Folder |
|---|---|
| Generate Parentheses, Power Set, Subsets I and II, Combination Sum I/II/III, Letter Combinations, Palindrome Partitioning, Word Search, N-Queens, Rat in a Maze, M-Coloring, Sudoku Solver, Expression Add Operators | [backtracking](../backtracking/README.md) |

## Run any program
```
javac -d out *.java
java -cp out PowXN
```
