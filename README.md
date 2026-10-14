# Data Structures And Algorithm (Java)

My Java solutions and quick-revision notes for **Striver's A2Z DSA Sheet** (all 19 sections), organised by pattern. Every question has:
- a Java program (`.java`) with a `main` and the expected output in comments,
- a short note (`.md`): approach, intuition, brute force vs optimised, edge cases, interview traps, complexity and a one-line "how to explain",
- a row in the folder `README.md` with a practice link for active recall.

## How to use it
1. Open a pattern folder and read its `README.md` (the table of questions and links).
2. **Active recall:** open the practice link, solve it from scratch, then compare with the `.java` and `.md`.
3. Before an interview, re-read only the "Interview traps" and "How to explain" lines.

## Run a program
Each class is standalone (no packages). From inside a folder:
```
javac -d out *.java
java -cp out ClassName
```
In IntelliJ, open a pattern folder as the module, or mark it as a source root. Class names repeat across folders on purpose, so do not mark the whole repo as one source root.

## Folders by pattern
| Folder | What is inside |
|---|---|
| [beginner](beginner/README.md) | Patterns, basic maths, arrays, hashing, strings, recursion, time complexity, Java collections |
| [sorting](sorting/README.md) | Selection, bubble, insertion, merge, quick (+ merge-sort applications) |
| [arrays](arrays/README.md), [matrix](matrix/README.md), [prefix-sum](prefix-sum/README.md), [hashing](hashing/README.md) | Array problems, matrices, prefix sums, hashing |
| [two-pointers](two-pointers/README.md), [sliding-window](sliding-window/README.md), [fast-and-slow-pointers](fast-and-slow-pointers/README.md) | Pointer patterns |
| [binary-search](binary-search/README.md) | Searching, 2D, binary search on the answer |
| [strings](strings/README.md) | Basic and medium strings, plus [advanced](strings/advanced/README.md): hashing, Rabin-Karp, Z, KMP |
| [recursion](recursion/README.md), [backtracking](backtracking/README.md) | Recursion and backtracking |
| [linked-list](linked-list/README.md), [doubly-linked-list](doubly-linked-list/README.md), [in-place-reversal-of-linked-list](in-place-reversal-of-linked-list/README.md) | Linked lists |
| [bitwise-manipulation](bitwise-manipulation/README.md) | Bit tricks |
| [greedy-algorithms](greedy-algorithms/README.md), [merge-intervals](merge-intervals/README.md) | Greedy and interval problems |
| [stack-and-queue](stack-and-queue/README.md), [monotonic-stack-queue](monotonic-stack-queue/README.md), [design](design/README.md) | Stacks, queues, monotonic structures, LRU/LFU/Twitter |
| [tree-bfs](tree-bfs/README.md), [tree-dfs](tree-dfs/README.md), [binary-search-tree](binary-search-tree/README.md) | Binary trees and BSTs |
| [heap](heap/README.md), [top-k-elements-heap](top-k-elements-heap/README.md), [k-way-merge](k-way-merge/README.md) | Heaps and top-K |
| [graph-traversal](graph-traversal/README.md) | BFS, DFS, topological sort, shortest paths, MST, union-find |
| [dynamic-programming](dynamic-programming/README.md) | 1D, 2D, grid, stocks, knapsack, LIS, LCS, strings, MCM, Kadane |
| [trie](trie/README.md) | Tries and XOR tries |
| [maths](maths/README.md) | Sieve of Eratosthenes and prime factorisation |

`cyclic-sort` is an empty placeholder: the A2Z sheet has no dedicated cyclic-sort questions. Git does not track empty folders, so it will not appear on GitHub until you add a file to it.

## Where each sheet section lives
| A2Z section | Folder |
|---|---|
| Beginner Problems | beginner |
| Sorting | sorting |
| Arrays | arrays, matrix, prefix-sum, two-pointers |
| Hashing | hashing |
| Binary Search | binary-search |
| Strings (Basic and Medium) | strings |
| Recursion | recursion, backtracking |
| Linked List | linked-list, doubly-linked-list, fast-and-slow-pointers, in-place-reversal-of-linked-list |
| Bit Manipulation | bitwise-manipulation |
| Greedy Algorithms | greedy-algorithms, merge-intervals |
| Sliding Window / Two Pointer | sliding-window, two-pointers |
| Stack / Queues | stack-and-queue, monotonic-stack-queue, design |
| Binary Trees | tree-bfs, tree-dfs |
| Binary Search Trees | binary-search-tree |
| Heaps | heap, top-k-elements-heap, k-way-merge, design |
| Graphs | graph-traversal |
| Dynamic Programming | dynamic-programming |
| Tries | trie |
| Strings (Advanced Algo) | strings/advanced |
| Maths | maths |

## Things to know
- Practice links were written from memory and have not all been opened; if one is broken, search the problem title.
- A few sheet items come without a description. In those cases I implemented the most likely problem and wrote the assumption in that folder's README.
- Some problems are LeetCode Premium; the notes are self-contained so you can still revise them.
