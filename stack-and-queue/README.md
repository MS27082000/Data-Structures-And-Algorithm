# Stack and Queue

Source: Striver's A2Z DSA Sheet, Stack / Queues (31 items). They are split across three folders:
- **This folder:** implementations, Balanced Parentheses, conversions, Min Stack, Celebrity (11 files, 17 sheet items)
- [monotonic-stack-queue](../monotonic-stack-queue/README.md): next greater/smaller, histogram, sliding window maximum, etc. (13 items)
- [design](../design/README.md): LRU Cache and LFU Cache (2 items)

Active recall: open the link, solve from scratch, then check the notes.

## Stack vs Queue in one line
**Stack** = last in, first out (undo, DFS, matching brackets). **Queue** = first in, first out (BFS, scheduling).

## Implementation
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Implementation using different DS](DataStructureOverview.md) | Theory | Which Java class for which structure | n/a |
| 2 | [Stack using Arrays](StackUsingArray.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-stack-using-array/1) | `top` index | O(1) |
| 3 | [Queue using Arrays](QueueUsingArray.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-queue-using-array/1) | Circular buffer | O(1) |
| 4 | [Stack using Queue](StackUsingQueues.md) | [LC 225](https://leetcode.com/problems/implement-stack-using-queues/) | Rotate on push | push O(n) |
| 5 | [Queue using Stack](QueueUsingStacks.md) | [LC 232](https://leetcode.com/problems/implement-queue-using-stacks/) | Two stacks, amortised | O(1) amortised |
| 6 | [Stack using Linked List](StackUsingLinkedList.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1) | Head = top | O(1) |
| 7 | [Queue using Linked List](QueueUsingLinkedList.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1) | Head + tail | O(1) |
| 8 | [Balanced Parentheses](BalancedParentheses.md) | [LC 20](https://leetcode.com/problems/valid-parentheses/) | Stack of openers | O(n) |

## Prefix, Infix and Postfix Conversions (6 items)
| Question (notes) | Practice | Covers |
|---|---|---|
| [Expression Conversions](ExpressionConversions.md) | [GfG](https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1) | Infix→Postfix, Infix→Prefix, Prefix→Infix, Prefix→Postfix, Postfix→Infix, Postfix→Prefix |

## FAQs in this folder
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 9 | [Min Stack](MinStack.md) | [LC 155](https://leetcode.com/problems/min-stack/) | Parallel min stack or encoding | O(1) |
| 10 | [Celebrity Problem](CelebrityProblem.md) | [GfG](https://www.geeksforgeeks.org/problems/the-celebrity-problem/1) | Eliminate with two pointers | O(n) |

## Run any program
```
javac -d out *.java
java -cp out ExpressionConversions
```
