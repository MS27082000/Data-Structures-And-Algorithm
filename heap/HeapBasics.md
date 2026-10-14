# Heaps (Theory)

## What a heap is
A **heap** is a **complete binary tree** (all levels full except possibly the last, filled left to right) that satisfies the **heap property**:
- **Min-heap:** every parent ≤ its children → the **minimum is at the root**.
- **Max-heap:** every parent ≥ its children → the **maximum is at the root**.

It is **not sorted**. Only parent/child order is guaranteed, and siblings are unordered.

## Stored in an array (no pointers needed)
For a 0-indexed array: `parent(i) = (i − 1) / 2`, `left(i) = 2i + 1`, `right(i) = 2i + 2`. Completeness means the array has no gaps. Leaves are indices `n/2 … n−1`; the last internal node is `n/2 − 1`.

## Operations and costs
| Operation | How | Time |
|---|---|---|
| **peek** (min/max) | read `a[0]` | O(1) |
| **insert** | add at the end, **sift up** | O(log n) |
| **extract** root | move the last element to the root, **sift down** (heapify) | O(log n) |
| **build heap** from an array | heapify every internal node bottom-up | **O(n)** |
| **search** an arbitrary value | scan | O(n) (a heap is not a search structure) |
| **delete** an arbitrary element | find it (O(n)), then swap with the last and fix | O(n) |

## Java: `PriorityQueue`
- **Min-heap by default.** Max-heap: `new PriorityQueue<>(Collections.reverseOrder())`.
- `offer/poll/peek` (return `null` on empty) vs `add/remove/element` (throw).
- **Pitfalls:** printing/iterating a `PriorityQueue` is **not sorted**. `remove(Object)` and `contains` are O(n). The comparator `(a, b) -> b - a` **overflows**, so use `Integer.compare(b, a)`.

## When to use a heap
| Signal in the problem | Use |
|---|---|
| "k largest / smallest / most frequent" | Heap of size k |
| "Repeatedly take the best/smallest item" | Priority queue |
| "Merge k sorted …" | Heap of the current heads |
| "Median of a stream" | Two heaps |
| "Schedule by priority / cooldown" | Heap + greedy |

## Heap vs other structures
Sorted array: min/max O(1) but insert O(n). BST: min/max O(log n), supports search and ordered iteration. Heap: **fastest insert + extract-min**, but only the root is accessible.

## Interview traps
- A heap is **not** a sorted array, and not a BST.
- **Top K largest → MIN-heap of size k** (the smallest of the k sits at the root and is the one to evict). This inversion trips many people.
- Build-heap is O(n), **not** O(n log n). Be ready to explain why.

**How to explain:** "A heap is a complete binary tree in an array where each parent is no larger (min-heap) or no smaller (max-heap) than its children, so the best element is always at the root. Insert and extract take O(log n), and peeking takes O(1)."
