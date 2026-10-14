# Two Pointers

## When to use
- Sorted array/string, or you can sort without breaking the answer
- Finding pairs/triplets with a target sum
- Palindrome checks / mirroring from both ends
- In-place compaction or partition (remove, move, dedupe)
- "O(1) extra space" in the constraints

## Three flavours
| Type | Setup | Typical use |
|---|---|---|
| Opposite ends | `left=0`, `right=n-1`, move inward | Two Sum II, palindrome, container, trapping water |
| Same direction (reader/writer) | `slow`, `fast` both from the start | Remove duplicates, move zeroes |
| Partition (3 pointers) | `low`, `mid`, `high` | Sort colors |

## Template (opposite ends)
```java
int left = 0, right = n - 1;
while (left < right) {
    // evaluate with nums[left], nums[right]
    // decide which pointer to move, and why that's safe
}
```

## Questions (must-do)
Active recall: open the LeetCode link, solve from scratch, then check the notes.

| # | Question (notes) | LeetCode | Type | Time | Space |
|---|---|---|---|---|---|
| 1 | [Two Sum II](TwoSumII.md) | [167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Opposite | O(n) | O(1) |
| 2 | [Valid Palindrome](ValidPalindrome.md) | [125](https://leetcode.com/problems/valid-palindrome/) | Opposite | O(n) | O(1) |
| 3 | [Valid Palindrome II](ValidPalindromeII.md) | [680](https://leetcode.com/problems/valid-palindrome-ii/) | Opposite | O(n) | O(1) |
| 4 | [3Sum](ThreeSum.md) | [15](https://leetcode.com/problems/3sum/) | Sort + Opposite | O(n²) | O(1) |
| 5 | [3Sum Closest](ThreeSumClosest.md) | [16](https://leetcode.com/problems/3sum-closest/) | Sort + Opposite | O(n²) | O(1) |
| 6 | [Container With Most Water](ContainerWithMostWater.md) | [11](https://leetcode.com/problems/container-with-most-water/) | Opposite | O(n) | O(1) |
| 7 | [Remove Duplicates from Sorted Array](RemoveDuplicatesFromSortedArray.md) | [26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Same dir | O(n) | O(1) |
| 8 | [Move Zeroes](MoveZeroes.md) | [283](https://leetcode.com/problems/move-zeroes/) | Same dir | O(n) | O(1) |
| 9 | [Sort Colors](SortColors.md) | [75](https://leetcode.com/problems/sort-colors/) | 3 pointers | O(n) | O(1) |
| 10 | [Trapping Rain Water](TrappingRainWater.md) | [42](https://leetcode.com/problems/trapping-rain-water/) | Opposite | O(n) | O(1) |
| 11 | [4Sum](FourSum.md) | [18](https://leetcode.com/problems/4sum/) | Sort + 2 fixed + Opposite | O(n³) | O(1) |
| 12 | [Union of Two Sorted Arrays](UnionOfSortedArrays.md) | [GfG](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1) | Merge-style | O(n+m) | O(1) |
| 13 | [Intersection of Two Sorted Arrays](IntersectionOfSortedArrays.md) | [LC 350](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Merge-style | O(n+m) | O(1) |
| 14 | [Merge Sorted Arrays Without Extra Space](MergeSortedArraysWithoutExtraSpace.md) | [GfG](https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1) | Swap ends / gap method | O((n+m) log(n+m)) | O(1) |

Questions 7, 8, 4 and 9 (Remove Duplicates, Move Zeroes, 3Sum, Sort Colors) are also part of Striver's Arrays section.

## Frequently asked (to practise and add yourself)
- [Reverse String (344)](https://leetcode.com/problems/reverse-string/)
- [Squares of a Sorted Array (977)](https://leetcode.com/problems/squares-of-a-sorted-array/)
- [Merge Sorted Array (88)](https://leetcode.com/problems/merge-sorted-array/)
- [Remove Element (27)](https://leetcode.com/problems/remove-element/)
- [Intersection of Two Arrays II (350)](https://leetcode.com/problems/intersection-of-two-arrays-ii/)
- [Backspace String Compare (844)](https://leetcode.com/problems/backspace-string-compare/)
- [Is Subsequence (392)](https://leetcode.com/problems/is-subsequence/)
- [Boats to Save People (881)](https://leetcode.com/problems/boats-to-save-people/)

## Run any program
```
javac -d out *.java
java -cp out TwoSumII
```
