# LRU Cache (LC 146)

**Problem:** Design a cache with a fixed capacity supporting `get(key)` and `put(key, value)` in **O(1)**. When full, evict the **least recently used** key.

**Brute force:** Store a timestamp per key and scan for the minimum on eviction → O(n).
**Optimal:** **HashMap + Doubly Linked List.**
- The **map** gives O(1) access to a node by key.
- The **doubly linked list** keeps keys ordered by recency: **head = most recently used**, **tail = least recently used**. A doubly linked list allows removing any node in O(1) (it has `prev`).

**Operations**
- `get(k)`: if present, move the node to the front and return the value; else `-1`.
- `put(k, v)`: if present, update and move to the front. Otherwise, if full, remove the node before the tail sentinel (LRU) and its map entry, then insert a new node at the front.

**Intuition:** The map answers "where is it?" and the list answers "how recent is it?". Each needs the other to be O(1).

**Complexity:** `get` and `put` are O(1). Space O(capacity).

**Edge cases:** Capacity 1, updating an existing key (must **not** evict), `get` on a missing key, repeated gets reorder recency.

**Interview traps**
- **Dummy head and tail sentinels** remove all null checks in add/remove.
- Each node must store its **key**, so you can delete the map entry when evicting the LRU node.
- `get` **counts as a use**, so it must move the node to the front.
- Update the value for an existing key without evicting anyone.
- In Java, `LinkedHashMap(capacity, 0.75f, true)` with `removeEldestEntry` is a 5-line solution. Mention it, but be ready to build it by hand.

**How to explain:** "A hash map finds a node in O(1), and a doubly linked list keeps nodes in recency order so I can move one to the front or remove the last in O(1). The tail is always the least recently used key to evict."
