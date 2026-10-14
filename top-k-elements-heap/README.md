# Top K Elements (Heap)

Source: Striver's A2Z DSA Sheet, Heaps (the K-th largest and the "priority" FAQs). Active recall: open the link, solve from scratch, then check the notes.

## When to use
- "K largest / smallest / most frequent / closest"
- "Repeatedly pick the best remaining item" (greedy with a priority queue)
- A running **median** or a running k-th element in a stream

## The key inversion
| Goal | Heap to keep |
|---|---|
| **K largest** | **MIN**-heap of size k (root = smallest of the k, the one to evict) |
| **K smallest** | **MAX**-heap of size k |
| **Median** | Max-heap (lower half) + min-heap (upper half) |

Cost: O(n log k) time and O(k) space. Beats sorting (O(n log n)) when k is small and works on streams.

## Template
```java
PriorityQueue<Integer> heap = new PriorityQueue<>();      // min-heap for the k largest
for (int x : nums) {
    heap.offer(x);
    if (heap.size() > k) heap.poll();                      // drop the smallest
}
// heap now holds the k largest; heap.peek() is the k-th largest
```

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [K-th Largest Element in an Array](KthLargestInArray.md) | [LC 215](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Min-heap of size k, or quickselect | O(n log k) |
| 2 | [K-th Largest in a Stream](KthLargestInStream.md) | [LC 703](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | Persistent min-heap of size k | O(log k) per add |
| 3 | [Replace Elements by Their Rank](ReplaceElementsByRank.md) | [GfG](https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1) | Sorted order, bump rank on change | O(n log n) |
| 4 | [Task Scheduler](TaskScheduler.md) | [LC 621](https://leetcode.com/problems/task-scheduler/) | Max-heap of counts + cooldown, or formula | O(m) |
| 5 | [Hand of Straights](HandOfStraights.md) | [LC 846](https://leetcode.com/problems/hand-of-straights/) | Smallest card starts a group | O(n log n) |
| 6 | [Minimum Cost to Connect Sticks](MinCostToConnectSticks.md) | [LC 1167](https://leetcode.com/problems/minimum-cost-to-connect-sticks/) (premium) | Merge the two smallest (Huffman) | O(n log n) |
| 7 | [Maximum Sum Combination](MaximumSumCombination.md) | [GfG](https://www.geeksforgeeks.org/problems/maximum-sum-combination/1) | Best-first search over pairs | O(n log n + K log K) |
| 8 | [Top K Frequent Elements](TopKFrequentElements.md) | [LC 347](https://leetcode.com/problems/top-k-frequent-elements/) | Min-heap by frequency, or buckets | O(n log k) / O(n) |
| 9 | [Find Median from Data Stream](FindMedianFromDataStream.md) | [LC 295](https://leetcode.com/problems/find-median-from-data-stream/) | Two heaps | O(log n) add, O(1) median |

## Related
[Heap theory and implementation](../heap/README.md) · [K-way merge](../k-way-merge/README.md) · [Design Twitter](../design/DesignTwitter.md)

## Run any program
```
javac -d out *.java
java -cp out TopKFrequentElements
```
