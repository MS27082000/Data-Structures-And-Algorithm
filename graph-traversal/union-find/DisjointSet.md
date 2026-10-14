# Disjoint Set (Union-Find / DSU)

**Problem:** Maintain a collection of **disjoint groups** of elements under two operations:
- `find(x)`: which group (representative/root) does `x` belong to?
- `union(a, b)`: merge the groups of `a` and `b`.

**Structure:** A forest where each element points to a `parent`; a root points to itself. Two elements are in the same group iff `find` returns the same root.

**Two optimisations (use both):**
1. **Path compression:** during `find`, point every visited node **directly at the root** (flattens the tree).
2. **Union by size/rank:** attach the **smaller** tree under the **larger** one (keeps trees shallow).
Together each operation costs **O(α(n))** amortised, where α is the inverse Ackermann function (< 5 for any practical n), so effectively constant.

**Complexity:** Time O(α(n)) per operation, Space O(n). Build O(n).

**Extras the class tracks:** `size[root]` (group size) and `components` (count, decremented on every successful union).

**Edge cases:** Union of elements already together (return false, don't change the count), `find` on a root, a single element, a chain of unions that would create a deep tree without balancing.

**Interview traps**
- Always `find` both elements **before** comparing or linking. Linking `a` and `b` directly instead of their roots corrupts the structure.
- Compress paths **iteratively** (or with recursion) correctly. Don't just return the root without compressing.
- Return a boolean from `union` ("was a merge performed?") so cycle detection is trivial.
- Use cases: connected components (static or **online**), cycle detection, Kruskal's MST, accounts merge, grid islands, equivalence classes.
- A DSU cannot **split** groups. It only merges.

**How to explain:** "Each group is a tree with a root as its representative. Find follows parents to the root and flattens the path; union links the smaller tree under the larger. With both tricks, each operation is almost constant time."
