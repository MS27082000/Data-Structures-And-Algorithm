# Segregate Odd and Even Nodes (Odd Even Linked List, LC 328)

**Problem:** Group all nodes at **odd positions** (1st, 3rd, …) first, followed by nodes at **even positions** (2nd, 4th, …), keeping the relative order. It is about **positions**, not values.

**Brute force:** Copy values into two lists / an array and rewrite → O(n) time, O(n) space.
**Optimal:** Rewire in place with two chains: `odd` (starting at head) and `even` (starting at `head.next`). Alternately link each to the node after next. Finally `odd.next = evenHead` → O(n) time, O(1) space.

**Intuition:** Every odd node's next odd node is two steps ahead (and likewise for even). So you can build both chains in one pass and join them at the end.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty list, one node, two nodes, odd vs even length.

**Interview traps**
- **Save `evenHead`** before the loop. You need it to attach the even chain.
- Loop condition `even != null && even.next != null` covers both odd and even lengths.
- The last even node's `next` is already `null`, so no cycle, as long as you don't leave stale pointers.
- Don't confuse with segregating by **value** parity (a different problem).

**How to explain:** "I keep two pointers, one building the odd-position chain and one building the even-position chain, each skipping every other node. At the end I attach the even chain after the odd chain."
