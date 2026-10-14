# In-Place Reversal of a Linked List

Source: Striver's A2Z DSA Sheet, Linked-List section. Active recall: open the link, solve from scratch, then check the notes.

## When to use
- Reverse a whole list, a sub-list, or every group of `k`
- Anything that needs to "read a list backwards" with O(1) space (palindrome check, reorder list)

## Template
```java
ListNode prev = null, cur = head;
while (cur != null) {
    ListNode next = cur.next;   // 1) remember the rest
    cur.next = prev;            // 2) flip the link
    prev = cur;                 // 3) advance prev
    cur = next;                 // 4) advance cur
}
return prev;                    // new head
```

## Questions
| # | Question (notes) | LeetCode | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Reverse a Linked List](ReverseLinkedList.md) | [206](https://leetcode.com/problems/reverse-linked-list/) | 3 pointers (or recursion) | O(n) | O(1) |
| 2 | [Reverse Nodes in k-Group](ReverseNodesInKGroup.md) | [25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Reverse each block, reconnect | O(n) | O(1) |

## Related
- [Reverse a Doubly Linked List](../doubly-linked-list/DoublyLinkedListBasics.md): swap `prev` and `next` of every node.
- [Palindrome Linked List](../fast-and-slow-pointers/PalindromeLinkedList.md): reverses the second half.
- [Add Two Numbers](../linked-list/AddTwoNumbers.md) and [Add One](../linked-list/AddOneToLinkedList.md) use the same pointer handling.

## Run any program
```
javac -d out *.java
java -cp out ReverseNodesInKGroup
```
