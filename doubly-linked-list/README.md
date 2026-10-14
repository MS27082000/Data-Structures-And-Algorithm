# Doubly Linked List

Source: Striver's A2Z DSA Sheet, Linked-List section: Fundamentals (Doubly LL) (13 items) and FAQs (DLL) (3 items).
Active recall: open the link, solve from scratch, then check the notes.

## Why a DLL
Each node has `prev` and `next`. You can traverse both ways and delete or insert at a **given node in O(1)**, at the cost of one extra pointer per node.

## Always update two pointers per link
`a.next = b` **and** `b.prev = a`. Verify with forward **and** backward prints.

## Fundamentals (13 items)
| Question (notes) | Covers |
|---|---|
| [Doubly Linked List Basics](DoublyLinkedListBasics.md) | Introduction, Convert Array to DLL, Deletion (head, tail, Kth, given node), Insertion (before head, before tail, before Kth, before a given node), Reverse a DLL |

## FAQs
| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Delete All Occurrences of a Key](DeleteAllOccurrencesDLL.md) | [GfG](https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1) | Unlink in one pass | O(n) | O(1) |
| 2 | [Remove Duplicates from Sorted DLL](RemoveDuplicatesSortedDLL.md) | [GfG](https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1) | Duplicates are adjacent | O(n) | O(1) |
| 3 | [Find Pairs with Given Sum](PairsWithGivenSumDLL.md) | [GfG](https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1) | Two pointers, head and tail | O(n) | O(1) |

## Run any program
```
javac -d out *.java
java -cp out DoublyLinkedListBasics
```
