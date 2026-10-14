# Sliding Window

Source: Striver's A2Z DSA Sheet, Sliding Window / 2 Pointer (13 items: 1 theory + 12 problems). Active recall: open the link, solve from scratch, then check the notes.

## When to use
Contiguous subarray / substring + longest, shortest, count or fixed size K.
**Not** for conditions that aren't monotonic (e.g. sum with negative numbers). Use [prefix-sum](../prefix-sum/README.md) instead.

## Quick decision table
| Question looks like | Use |
|---|---|
| Window of fixed size K | Fixed window (add right, drop `right − k`) |
| Longest window with at most K of something | Expand, `while (invalid) shrink` |
| Shortest window covering something | Expand, `while (valid) { record; shrink }` |
| Count subarrays with **exactly** K | `atMost(K) − atMost(K − 1)` |
| Subsequence (not contiguous) | Not a window: two pointers / DP |

## Pattern and Template
| Question (notes) | Idea |
|---|---|
| [Sliding Window: Pattern and Template](SlidingWindowPatterns.md) | The four shapes, templates, why "at most" counting works |

## Constant Window
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Maximum Points You Can Obtain from Cards](MaxPointsFromCards.md) | [LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | Fixed window wrapping the ends | O(k) |

## Longest and Smallest Window Problems
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Longest Substring Without Repeating Characters](LongestSubstringWithoutRepeating.md) | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Last-index jump | O(n) |
| [Max Consecutive Ones III](MaxConsecutiveOnesIII.md) | [LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) | ≤ k zeros | O(n) |
| [Fruit Into Baskets](FruitIntoBaskets.md) | [LC 904](https://leetcode.com/problems/fruit-into-baskets/) | ≤ 2 distinct | O(n) |
| [Longest Substring with At Most K Distinct Characters](LongestSubstringKDistinct.md) | [LC 340](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) (premium) | ≤ k distinct | O(n) |
| [Longest Repeating Character Replacement](LongestRepeatingCharacterReplacement.md) | [LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) | `len − maxFreq ≤ k` | O(n) |
| [Minimum Window Substring](MinimumWindowSubstring.md) | [LC 76](https://leetcode.com/problems/minimum-window-substring/) | Shortest covering window | O(n+m) |
| [Minimum Window Subsequence](MinimumWindowSubsequence.md) | [LC 727](https://leetcode.com/problems/minimum-window-subsequence/) (premium) | Forward match, backward tighten | O(n·m) |

## Counting Subarrays / Substrings Problems
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Number of Substrings Containing All Three Characters](SubstringsContainingAllThreeChars.md) | [LC 1358](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/) | `min(last seen) + 1` | O(n) |
| [Binary Subarrays With Sum](BinarySubarraysWithSum.md) | [LC 930](https://leetcode.com/problems/binary-subarrays-with-sum/) | atMost(g) − atMost(g−1) | O(n) |
| [Count Number of Nice Subarrays](CountNiceSubarrays.md) | [LC 1248](https://leetcode.com/problems/count-number-of-nice-subarrays/) | Odd → 1, then as above | O(n) |
| [Subarrays with K Different Integers](SubarraysWithKDistinct.md) | [LC 992](https://leetcode.com/problems/subarrays-with-k-different-integers/) | atMost(k) − atMost(k−1) | O(n) |

## Related
- [Count Number of Substrings (exactly K distinct chars)](../strings/CountSubstringsWithKDistinct.md): same technique.
- [Longest Subarray with Sum K](../prefix-sum/LongestSubarrayWithSumK.md): prefix sums when negatives are present.
- [Two Pointers](../two-pointers/README.md): the opposite-ends cousin of this pattern.

## Run any program
```
javac -d out *.java
java -cp out MinimumWindowSubstring
```
