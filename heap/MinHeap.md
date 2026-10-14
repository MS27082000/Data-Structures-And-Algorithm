# Implement a Min Heap

**Problem:** Implement a min-heap with `insert`, `peek` (get min), `extractMin`, `size`.

**Data layout:** An array `a` and a `size`. Parent `(i−1)/2`, children `2i+1`, `2i+2`.

**Operations**
- **insert(x):** put `x` at `a[size]`, then **sift up**: while the parent is larger, swap up → O(log n).
- **peek():** `a[0]` → O(1).
- **extractMin():** save `a[0]`; move the **last** element to the root (`a[0] = a[--size]`); **sift down**: swap with the smaller child while a child is smaller → O(log n).
- **Resize:** double the array when full (amortised O(1) per insert).

**Intuition:** Both repairs follow one path between a leaf and the root, so the cost is the tree height, log n.

**Complexity:** insert/extract O(log n), peek O(1), space O(n).

**Edge cases:** Extract/peek from an empty heap (throw), duplicates (fine), extracting the last element (don't sift an empty heap), growth past the initial capacity.

**Interview traps**
- On extract, decrement `size` **before** moving the last element, and skip the sift-down if the heap became empty.
- Sift down against the **smaller** child.
- Use `<=` in sift-up (`a[p] <= a[i]` → stop) so equal values don't cause swaps forever.
- Mention **decreaseKey** (O(log n) with a position map): Dijkstra and Prim use it.

**How to explain:** "I store the heap in an array. Insert adds at the end and sifts up; extract-min returns the root, moves the last element to the top and sifts down. Each is O(log n)."
