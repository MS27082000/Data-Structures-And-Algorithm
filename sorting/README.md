# Sorting Algorithms

Source: Striver's A2Z DSA Sheet, Sorting section (7 items).
Active recall: write each from scratch, then check the notes. Practice problem for all of them: [Sort an Array (LC 912)](https://leetcode.com/problems/sort-an-array/).

## Cheat sheet
| Algorithm | Best | Average | Worst | Space | Stable | Notes |
|---|---|---|---|---|---|---|
| [Selection Sort](SelectionSort.md) | O(n²) | O(n²) | O(n²) | O(1) | No | Fewest swaps |
| [Bubble Sort](BubbleSort.md) | O(n) | O(n²) | O(n²) | O(1) | Yes | Needs a `swapped` flag for O(n) best |
| [Insertion Sort](InsertionSort.md) | O(n) | O(n²) | O(n²) | O(1) | Yes | Great for nearly sorted / small arrays |
| [Merge Sort](MergeSort.md) | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | Divide and conquer, always n log n |
| [Quick Sort](QuickSort.md) | O(n log n) | O(n log n) | O(n²) | O(log n) | No | Fast in practice, pivot choice matters |
| [Recursive Bubble Sort](RecursiveBubbleSort.md) | O(n) | O(n²) | O(n²) | O(n) stack | Yes | Recursion replaces the outer loop |
| [Recursive Insertion Sort](RecursiveInsertionSort.md) | O(n) | O(n²) | O(n²) | O(n) stack | Yes | Recursion replaces the outer loop |

## Merge sort applications
See [merge-sort-applications](merge-sort-applications/README.md): Count Inversions and Reverse Pairs.

## Common interview questions
- Which sorts are stable, and why does stability matter?
- Why is quick sort used in practice even though its worst case is O(n²)?
- When would you pick merge sort over quick sort? (stability, guaranteed n log n, linked lists)
- Which sort is best for nearly sorted data? (insertion)
- Can you sort faster than O(n log n)? (not by comparisons; counting/radix sort work when the key range is limited)

## Run any program
```
javac -d out *.java
java -cp out MergeSort
```
