# Heap

Source: Striver's A2Z DSA Sheet, Heaps → Theory and Implementation (9 items; this folder has 8 files, one per implementation topic). The 11 FAQs live in [top-k-elements-heap](../top-k-elements-heap/README.md), [k-way-merge](../k-way-merge/README.md) and [design](../design/README.md). Active recall: open the link, solve from scratch, then check the notes.

## The essentials
- A heap is a **complete binary tree in an array**; parent `(i−1)/2`, children `2i+1`, `2i+2`.
- **Min-heap:** root is the minimum. **Max-heap:** root is the maximum.
- peek O(1) · insert O(log n) · extract O(log n) · **build O(n)**.
- Java: `PriorityQueue` (min-heap by default).

## Theory and Implementation
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Heaps (theory)](HeapBasics.md) | Theory | Array layout, operations, `PriorityQueue` | n/a |
| 2 | [Heapify Algorithm](HeapifyAlgorithm.md) | [GfG](https://www.geeksforgeeks.org/problems/heap-sort/1) | Sift down at one node | O(log n) |
| 3 | [Build Heap from an Array](BuildHeap.md) | [GfG](https://www.geeksforgeeks.org/problems/heap-sort/1) | Heapify from `n/2 − 1` down | O(n) |
| 4 | [Implement Min Heap](MinHeap.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-min-heap/1) | Sift up / sift down | O(log n) |
| 5 | [Implement Max Heap](MaxHeap.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-max-heap/1) | Mirror of min-heap | O(log n) |
| 6 | [Check if an Array is a Min Heap](CheckMinHeap.md) | [GfG](https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1) | Parent ≤ children for internal nodes | O(n) |
| 7 | [Convert Min Heap to Max Heap](ConvertMinHeapToMaxHeap.md) | [GfG](https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1) | Rebuild bottom-up | O(n) |
| 8 | [Heap Sort](HeapSort.md) | [GfG](https://www.geeksforgeeks.org/problems/heap-sort/1) | Build, then swap root to the end | O(n log n) |
| 9 | K-th Largest Element in an Array | [LC 215](https://leetcode.com/problems/kth-largest-element-in-an-array/) | See [top-k-elements-heap](../top-k-elements-heap/KthLargestInArray.md) | O(n log k) |

## Where the Heaps FAQs went
| Question | Folder |
|---|---|
| Kth Largest in a Stream, Replace by Rank, Task Scheduler, Hand of Straights, Min Cost to Connect Sticks, Maximum Sum Combination, Top K Frequent, Median from Data Stream | [top-k-elements-heap](../top-k-elements-heap/README.md) |
| Sort a K-Sorted Array, Merge K Sorted Lists | [k-way-merge](../k-way-merge/README.md) |
| Design Twitter | [design](../design/README.md) |

## Run any program
```
javac -d out *.java
java -cp out HeapSort
```
