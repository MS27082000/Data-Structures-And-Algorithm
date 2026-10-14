# K-Way Merge

Source: Striver's A2Z DSA Sheet, Heaps → FAQs. Active recall: open the link, solve from scratch, then check the notes.

## When to use
- Merging **k sorted** lists / arrays / streams
- "Smallest element across several sorted sources"
- Elements that are **almost sorted** (each within k positions)

## The idea
Keep a **min-heap of the current front element of each source**. Pop the smallest, output it, and push the next element from the **same source**. The heap size stays at most `k`, so each of the N outputs costs O(log k) → **O(N log k)**.

## Template
```java
PriorityQueue<Node> heap = new PriorityQueue<>(comparator);
for (Source s : sources) if (s.hasNext()) heap.offer(s.front());
while (!heap.isEmpty()) {
    Node smallest = heap.poll();
    output(smallest);
    if (smallest.source.hasNext()) heap.offer(smallest.source.next());
}
```

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Sort a K-Sorted Array](SortKSortedArray.md) | [GfG](https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1) | Min-heap of size k + 1 | O(n log k) |
| 2 | [Merge K Sorted Lists](MergeKSortedLists.md) | [LC 23](https://leetcode.com/problems/merge-k-sorted-lists/) | Heap of list heads (or divide and conquer) | O(N log k) |

## Related
[Heap theory](../heap/README.md) · [Top K elements](../top-k-elements-heap/README.md) · [Design Twitter](../design/DesignTwitter.md) (a k-way merge of tweet lists) · [Merge Two Sorted Lists](../linked-list/MergeTwoSortedLists.md)

## Run any program
```
javac -d out *.java
java -cp out MergeKSortedLists
```
