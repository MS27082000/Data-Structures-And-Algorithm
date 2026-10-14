# Java Collections (Standard Libraries)

**Problem:** The collection classes used in nearly every DSA solution.

**Intuition:** ArrayList (dynamic array), HashSet/HashMap (O(1) average lookup), TreeSet/TreeMap (sorted, O(log n), floor/ceiling), ArrayDeque (stack and queue), PriorityQueue (heap), Arrays and Collections utilities.

**Approach / complexity:** HashMap/HashSet: O(1) average. TreeMap/TreeSet: O(log n). PriorityQueue: O(log n) insert and remove, O(1) peek. ArrayList get O(1), insert in the middle O(n).

**Edge cases:** Null keys, concurrent modification while iterating, integer caching (== on boxed Integers).

**Interview traps**
- Prefer ArrayDeque to the legacy Stack and Vector classes.
- Use equals() for boxed values; == only works for -128..127.
- PriorityQueue iteration is not sorted.
- Remove during iteration with an Iterator.

**How to explain:** "I pick the structure by the operation I need: hash for lookups, tree for ordered queries, heap for the best element, deque for stack and queue."
