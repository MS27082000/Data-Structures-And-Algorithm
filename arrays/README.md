# Arrays

Source: Striver's A2Z DSA Sheet, Arrays section (32 items). The questions are split across folders by pattern.
Active recall: open the link, solve from scratch, then check the notes.

## In this folder
| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Linear Search](LinearSearch.md) | [GfG](https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1) | Scan | O(n) | O(1) |
| 2 | [Largest Element](LargestElement.md) | [GfG](https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0) | Running max | O(n) | O(1) |
| 3 | [Second Largest](SecondLargestElement.md) | [GfG](https://www.geeksforgeeks.org/problems/second-largest3735/1) | Two variables | O(n) | O(1) |
| 4 | [Max Consecutive Ones](MaxConsecutiveOnes.md) | [LC 485](https://leetcode.com/problems/max-consecutive-ones/) | Running count | O(n) | O(1) |
| 5 | [Left Rotate by One](LeftRotateByOne.md) | [GfG](https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1) | Shift | O(n) | O(1) |
| 6 | [Left Rotate by K](LeftRotateByK.md) | [LC 189](https://leetcode.com/problems/rotate-array/) | Triple reversal | O(n) | O(1) |
| 7 | [Missing Number](FindMissingNumber.md) | [LC 268](https://leetcode.com/problems/missing-number/) | XOR / sum | O(n) | O(1) |
| 8 | [Majority Element I](MajorityElementI.md) | [LC 169](https://leetcode.com/problems/majority-element/) | Boyer-Moore | O(n) | O(1) |
| 9 | [Majority Element II](MajorityElementII.md) | [LC 229](https://leetcode.com/problems/majority-element-ii/) | Boyer-Moore, 2 candidates | O(n) | O(1) |
| 10 | [Leaders in an Array](LeadersInArray.md) | [GfG](https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1) | Scan from the right | O(n) | O(1) |
| 11 | [Rearrange by Sign](RearrangeBySign.md) | [LC 2149](https://leetcode.com/problems/rearrange-array-elements-by-sign/) | Two write indices | O(n) | O(n) |
| 12 | [Next Permutation](NextPermutation.md) | [LC 31](https://leetcode.com/problems/next-permutation/) | Pivot, swap, reverse | O(n) | O(1) |
| 13 | [Find Repeating and Missing](FindRepeatingAndMissing.md) | [GfG](https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1) | Sum and sum of squares | O(n) | O(1) |

## Other Arrays-section questions live here
| Question | Folder |
|---|---|
| Move Zeros to End, Remove Duplicates from Sorted Array, 3 Sum, Sort 0/1/2 | [two-pointers](../two-pointers/README.md) |
| 4 Sum, Union of Sorted Arrays, Intersection of Sorted Arrays, Merge Two Sorted Arrays Without Extra Space | [two-pointers](../two-pointers/README.md) |
| Two Sum | [hashing](../hashing/README.md) |
| Kadane's Algorithm, Maximum Product Subarray | [dynamic-programming/kadane-subarray](../dynamic-programming/kadane-subarray/README.md) |
| Spiral Matrix, Rotate Matrix, Set Matrix Zeroes, Pascal's Triangle I/II/III | [matrix](../matrix/README.md) |
| Count Inversions, Reverse Pairs | [sorting/merge-sort-applications](../sorting/merge-sort-applications/README.md) |

## Run any program
```
javac -d out *.java
java -cp out NextPermutation
```
