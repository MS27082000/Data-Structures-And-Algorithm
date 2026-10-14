# Fast and Slow Pointers

Source: Striver's A2Z DSA Sheet, Linked-List section (FAQs Medium). Active recall: open the link, solve from scratch, then check the notes.

## When to use
- Find the **middle** of a linked list
- **Detect a cycle**, find its start or its length
- Anything where one pointer should move at twice the speed of another

## Core idea
`slow` moves 1 step, `fast` moves 2. If `fast` reaches the end, `slow` is at the middle. If there is a cycle, `fast` catches `slow` inside it.

## Template
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    // if (slow == fast) -> cycle
}
// slow is now the middle (second middle for even lengths)
```

## Questions
| # | Question (notes) | LeetCode | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Middle of the Linked List](MiddleOfLinkedList.md) | [876](https://leetcode.com/problems/middle-of-the-linked-list/) | Slow/fast | O(n) | O(1) |
| 2 | [Delete the Middle Node](DeleteMiddleNode.md) | [2095](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/) | Fast starts one ahead | O(n) | O(1) |
| 3 | [Palindrome Linked List](PalindromeLinkedList.md) | [234](https://leetcode.com/problems/palindrome-linked-list/) | Middle + reverse half + compare | O(n) | O(1) |
| 4 | [Detect a Loop](LinkedListCycle.md) | [141](https://leetcode.com/problems/linked-list-cycle/) | Floyd's meeting | O(n) | O(1) |
| 5 | [Starting Point of the Loop](LinkedListCycleII.md) | [142](https://leetcode.com/problems/linked-list-cycle-ii/) | Reset one pointer to head | O(n) | O(1) |
| 6 | [Length of the Loop](LengthOfLoop.md) | [GfG](https://www.geeksforgeeks.org/problems/find-length-of-loop/1) | Count one lap | O(n) | O(1) |

## Other pointer-pattern questions elsewhere
- [Remove Nth Node from End](../linked-list/RemoveNthNodeFromEnd.md): fast leads by n.
- [Intersection of Two Linked Lists](../linked-list/IntersectionOfTwoLinkedLists.md): two pointers that swap lists.
- [Happy Number / cycle in a sequence] can be solved with the same idea.

## Run any program
```
javac -d out *.java
java -cp out LinkedListCycleII
```
