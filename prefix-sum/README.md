# Prefix Sum

## When to use
- Subarray sum / XOR / count questions, especially with **negative** numbers (sliding window fails there)
- Many range-sum queries: `sum(i..j) = P[j+1] - P[i]`
- "Equal prefixes mean the stretch between them is zero"

## Core identity
`sum(a[j+1..i]) = P[i] - P[j]`. To find subarrays with sum `k`, look for an earlier prefix equal to `P[i] - k` in a HashMap.

**Why `P[i] - k`:** we want `P[i] - P[j] = k`. `P[i]` is known, `P[j]` is the unknown, so `P[j] = P[i] - k`. Full explanation with examples: [Count Subarrays with Sum K](CountSubarraysWithSumK.md).

## Template
```java
Map<Long, Integer> seen = new HashMap<>();
seen.put(0L, -1);              // for "longest": store first index. For "count": seen.put(0L, 1) and store counts
long prefix = 0;
for (int i = 0; i < n; i++) {
    prefix += a[i];
    // lookup (prefix - k) BEFORE inserting prefix
    // then record prefix
}
```

## Questions
Source: Striver's A2Z DSA Sheet, Hashing → FAQs. Active recall: solve from scratch, then check the notes.

| # | Question (notes) | Practice | Map stores | Time | Space |
|---|---|---|---|---|---|
| 1 | [Longest Subarray with Sum K](LongestSubarrayWithSumK.md) | [GfG](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1) | First index | O(n) | O(n) |
| 2 | [Largest Subarray with Sum 0](LargestSubarrayWithSumZero.md) | [GfG](https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1) | First index | O(n) | O(n) |
| 3 | [Count Subarrays with Sum K](CountSubarraysWithSumK.md) | [LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | Counts | O(n) | O(n) |
| 4 | [Count Subarrays with XOR K](CountSubarraysWithXorK.md) | [GfG](https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1) | Counts (prefix XOR) | O(n) | O(n) |

## Run any program
```
javac -d out *.java
java -cp out CountSubarraysWithSumK
```
