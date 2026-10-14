# Merge Sort Applications

Source: Striver's A2Z DSA Sheet, Arrays → FAQs (Hard). Pattern: use merge sort's "two sorted halves" step to count cross-half pairs in linear time. See [MergeSort](../MergeSort.md) first.

| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Count Inversions](CountInversions.md) | [GfG](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1) | Count while merging | O(n log n) | O(n) |
| 2 | [Reverse Pairs](ReversePairs.md) | [LC 493](https://leetcode.com/problems/reverse-pairs/) | Count before merging | O(n log n) | O(n) |

## Run
```
javac -d out *.java
java -cp out CountInversions
```
