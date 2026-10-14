# Implementation Using Different Data Structures (Theory)

## The four structures
| Structure | Rule | Core operations | Java class to use |
|---|---|---|---|
| **Stack** | LIFO (last in, first out) | `push`, `pop`, `peek` | **`ArrayDeque`** (`push/pop/peek`) |
| **Queue** | FIFO (first in, first out) | `offer`, `poll`, `peek` | **`ArrayDeque`** or `LinkedList` |
| **Deque** | Insert/remove at both ends | `offerFirst/Last`, `pollFirst/Last` | **`ArrayDeque`** |
| **Priority queue** | Highest priority out first | `offer`, `poll`, `peek` | **`PriorityQueue`** (min-heap by default) |

## Why `ArrayDeque`, not `Stack`
`java.util.Stack` extends `Vector`: every method is synchronised (slower) and it exposes list methods that break the LIFO guarantee. The Java docs recommend `Deque<Integer> stack = new ArrayDeque<>()`.
`ArrayDeque` disallows `null` elements; `LinkedList` allows them but uses more memory per element.

## How each is built (what interviewers ask)
| Implementation | Stack | Queue |
|---|---|---|
| **Array** | `top` index; push `++top`, pop `top--` | **Circular** buffer with `front` and `size` |
| **Linked list** | Head = top, O(1) push/pop | Head (dequeue) + **tail** (enqueue) |
| **Using the other** | Stack from queues (rotate on push) | Queue from stacks (two stacks, amortised O(1)) |

## Complexity
All core stack/queue/deque operations are **O(1)** (amortised for resizing arrays). `PriorityQueue` operations are O(log n); `peek` is O(1).

## Empty-structure behaviour
`pop()` / `remove()` **throw** `NoSuchElementException`; `poll()` / `peek()` return `null`. Pick based on whether you want an exception or a sentinel.

## When to use which
- **Stack:** undo/redo, DFS, balanced brackets, expression evaluation, monotonic problems.
- **Queue:** BFS, level-order traversal, scheduling, buffering.
- **Deque:** sliding window maximum, palindromes, 0-1 BFS.
- **Priority queue:** top K, scheduling by priority, Dijkstra, merge K sorted lists.

**How to explain:** "A stack is last-in-first-out and a queue is first-in-first-out. In Java I'd use ArrayDeque for both, and PriorityQueue when elements should come out by priority."
