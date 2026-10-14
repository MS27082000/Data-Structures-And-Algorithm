# Linked List

Source: Striver's A2Z DSA Sheet, Linked-List section (49 items). They are split across folders by pattern:
- This folder: singly linked list basics and general problems
- [fast-and-slow-pointers](../fast-and-slow-pointers/README.md): middle, loops, palindrome
- [in-place-reversal-of-linked-list](../in-place-reversal-of-linked-list/README.md): reverse, reverse in k-groups
- [doubly-linked-list](../doubly-linked-list/README.md): all DLL questions

Active recall: open the link, solve from scratch, then check the notes.

## Golden rules
1. **Dummy node** in front of the head removes head special cases.
2. To insert/delete you need the **previous** node.
3. Update pointers in the right order (save `next` before overwriting).
4. After cutting or merging, make sure the last node's `next` is `null` (no accidental cycles).
5. Draw boxes and arrows before you code.

## Singly Linked List Fundamentals (14 items)
| Question (notes) | Covers |
|---|---|
| [Singly Linked List Basics](SinglyLinkedListBasics.md) | Introduction, Traversal, Deletion, Insertion, Delete head/tail/Kth/value X, Insert at head/tail/Kth/before value X, Length, Search |

## Logic Building and FAQs
| # | Question (notes) | LeetCode | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Add Two Numbers](AddTwoNumbers.md) | [2](https://leetcode.com/problems/add-two-numbers/) | Digit by digit + carry | O(n) | O(1) |
| 2 | [Segregate Odd and Even Nodes](OddEvenLinkedList.md) | [328](https://leetcode.com/problems/odd-even-linked-list/) | Two chains | O(n) | O(1) |
| 3 | [Sort a List of 0s, 1s, 2s](SortList012.md) | [GfG](https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1) | Three lists | O(n) | O(1) |
| 4 | [Remove Nth Node from End](RemoveNthNodeFromEnd.md) | [19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Gap of n | O(n) | O(1) |
| 5 | [Add One to a Number](AddOneToLinkedList.md) | [369](https://leetcode.com/problems/plus-one-linked-list/) (premium) | Last non-9 node | O(n) | O(1) |
| 6 | [Intersection of Two Lists](IntersectionOfTwoLinkedLists.md) | [160](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Switch heads | O(m+n) | O(1) |
| 7 | [Rotate a Linked List](RotateList.md) | [61](https://leetcode.com/problems/rotate-list/) | Make circular, cut | O(n) | O(1) |
| 8 | [Merge Two Sorted Lists](MergeTwoSortedLists.md) | [21](https://leetcode.com/problems/merge-two-sorted-lists/) | Dummy + tail | O(m+n) | O(1) |
| 9 | [Flattening a Linked List](FlattenLinkedList.md) | [GfG](https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1) | Merge columns | O(N·k) | O(k) |
| 10 | [Sort a Linked List](SortList.md) | [148](https://leetcode.com/problems/sort-list/) | Merge sort | O(n log n) | O(log n) |
| 11 | [Clone a List with Random Pointer](CopyListWithRandomPointer.md) | [138](https://leetcode.com/problems/copy-list-with-random-pointer/) | Interleave copies | O(n) | O(1) |

## Where the rest of the Linked-List section went
| Question | Folder |
|---|---|
| Reverse a Linked List, Reverse in Group of K | [in-place-reversal-of-linked-list](../in-place-reversal-of-linked-list/README.md) |
| Middle, Delete the Middle, Palindrome, Detect a Loop, Starting Point of a Loop, Length of a Loop | [fast-and-slow-pointers](../fast-and-slow-pointers/README.md) |
| 13 Doubly LL basics (incl. Reverse a DLL) + 3 DLL FAQs | [doubly-linked-list](../doubly-linked-list/README.md) |

## Run any program
```
javac -d out *.java
java -cp out RotateList
```
