# Backtracking

Source: Striver's A2Z DSA Sheet, Recursion section (the 15 "choose, explore, undo" questions). The 7 plain recursion questions are in [recursion](../recursion/README.md).
Active recall: open the link, solve from scratch, then check the notes.

## When to use
- "Generate **all** …" (subsets, combinations, permutations, partitions, paths)
- Constraint satisfaction (N-Queens, Sudoku, colouring)
- Search with dead ends where you must undo a choice

## Template
```java
void backtrack(state, path, result) {
    if (isSolution(state)) { result.add(new ArrayList<>(path)); return; }   // copy!
    for (choice : choices(state)) {
        if (!isValid(choice)) continue;          // prune early
        path.add(choice);                        // choose
        backtrack(next(state), path, result);    // explore
        path.remove(path.size() - 1);            // un-choose
    }
}
```

## Duplicate handling rule
After **sorting**, skip an element equal to the previous one at the **same level**: `if (i > start && a[i] == a[i-1]) continue;` (**`i > start`, not `i > 0`**).

## Subsets and combinations
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Power Set](PowerSet.md) | [GfG](https://www.geeksforgeeks.org/problems/power-set4302/1) | Bitmask over 2ⁿ | O(n·2ⁿ) |
| [Subsets I](SubsetsI.md) | [LC 78](https://leetcode.com/problems/subsets/) | Record at every node | O(n·2ⁿ) |
| [Subsets II](SubsetsII.md) | [LC 90](https://leetcode.com/problems/subsets-ii/) | Sort + same-level skip | O(n·2ⁿ) |
| [Combination Sum I](CombinationSum.md) | [LC 39](https://leetcode.com/problems/combination-sum/) | Reuse allowed (recurse with `i`) | Exponential |
| [Combination Sum II](CombinationSumII.md) | [LC 40](https://leetcode.com/problems/combination-sum-ii/) | Use once + skip duplicates | O(2ⁿ) |
| [Combination Sum III](CombinationSumIII.md) | [LC 216](https://leetcode.com/problems/combination-sum-iii/) | Exactly k from 1..9 | O(C(9,k)) |

## Strings and sequences
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Generate Parentheses](GenerateParentheses.md) | [LC 22](https://leetcode.com/problems/generate-parentheses/) | `open < n`, `close < open` | O(4ⁿ/√n) |
| [Letter Combinations of a Phone Number](LetterCombinationsOfPhoneNumber.md) | [LC 17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | One level per digit | O(4ⁿ·n) |
| [Palindrome Partitioning](PalindromePartitioning.md) | [LC 131](https://leetcode.com/problems/palindrome-partitioning/) | Cut only at palindromes | O(n·2ⁿ) |
| [Expression Add Operators](ExpressionAddOperators.md) | [LC 282](https://leetcode.com/problems/expression-add-operators/) | Track eval and last term | O(4ⁿ·n) |

## Grids, boards and graphs
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Word Search](WordSearch.md) | [LC 79](https://leetcode.com/problems/word-search/) | DFS, mark and restore cell | O(m·n·3^L) |
| [N-Queens](NQueens.md) | [LC 51](https://leetcode.com/problems/n-queens/) | One queen per row, 3 boolean arrays | O(n!) |
| [Rat in a Maze](RatInAMaze.md) | [GfG](https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1) | DFS in D, L, R, U order | O(4^(n²)) |
| [M-Coloring Problem](MColoring.md) | [GfG](https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1) | Try colours, check neighbours | O(m^V) |
| [Sudoku Solver](SudokuSolver.md) | [LC 37](https://leetcode.com/problems/sudoku-solver/) | Try 1-9, undo on dead end | O(9^m) |

## Run any program
```
javac -d out *.java
java -cp out NQueens
```
