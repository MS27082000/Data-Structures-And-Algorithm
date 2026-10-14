# Clone a Linked List with Random Pointers (LC 138)

**Problem:** Each node has `next` and `random` (pointing to any node or `null`). Create a **deep copy**.

**Brute force / standard:** `HashMap<original, copy>`. Pass 1 creates all copies; pass 2 sets `next` and `random` via the map → O(n) time, **O(n) space**.
**Optimal (O(1) extra space), three passes:**
1. **Interleave:** after each original node insert its copy: `A → A' → B → B' → …`.
2. **Set randoms:** `copy.random = original.random.next` (the copy of the node the original points to).
3. **Separate:** restore the original list and extract the copy list.

**Intuition:** Putting each copy right after its original gives you a free "map" from any original node to its copy (`original.next`), without a HashMap.

**Complexity:** Time O(n), Space O(1) extra (the copy itself is the output).

**Edge cases:** Empty list, `random == null`, a node whose random points to itself, a random pointing backwards or forwards.

**Interview traps**
- Set randoms **before** separating, otherwise the mapping is gone.
- In pass 3 **restore the original list** (`cur.next = copy.next`). The caller's list must not be changed.
- Guard `cur.random != null` before using `.next`.
- Guard `copy.next` when linking the copies (the last copy points to `null`).
- Start with the HashMap solution, then say you can remove the map with interleaving.

**How to explain:** "I weave each copy right after its original so the copy of any node is just original.next. That lets me set the random pointers without a map, and then I unweave the two lists."
