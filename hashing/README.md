# Hashing

Source: Striver's A2Z DSA Sheet, Hashing section (6 items; the theory item is covered by Basic Hashing), plus Two Sum from Arrays → FAQs.
Active recall: solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Basic Hashing](BasicHashing.md) | Theory | Frequency array / HashMap | O(n) build, O(1) query | O(n) |
| 2 | [Two Sum](TwoSum.md) | [LC 1](https://leetcode.com/problems/two-sum/) | HashMap of seen values | O(n) | O(n) |
| 3 | [Longest Consecutive Sequence](LongestConsecutiveSequence.md) | [LC 128](https://leetcode.com/problems/longest-consecutive-sequence/) | HashSet, start only at sequence beginnings | O(n) | O(n) |

The other four Hashing questions (Longest Subarray with Sum K, Largest Subarray with Sum 0, Count Subarrays with Sum K, Count Subarrays with XOR K) use prefix sums, so they live in [prefix-sum](../prefix-sum/README.md).

See also [Two Sum II](../two-pointers/TwoSumII.md) (sorted input, O(1) space).

## Run
```
javac -d out *.java
java -cp out TwoSum
```
