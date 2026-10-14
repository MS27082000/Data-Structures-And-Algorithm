# Strings (Basic and Medium)

Source: Striver's A2Z DSA Sheet, Strings (Basic and Medium), 7 items. Active recall: open the link, solve from scratch, then check the notes.

## Common string techniques
- **Counter instead of a stack** for valid parentheses problems.
- **26-size frequency array** for lowercase letters (faster than a HashMap).
- **StringBuilder** for building results (never `+=` in a loop).
- **Expand around centre** for palindromic substrings; **sliding window** for substring counting.
- Watch **integer overflow** when parsing numbers.

## Parentheses
| Question (notes) | LeetCode | Idea | Time | Space |
|---|---|---|---|---|
| [Remove Outermost Parentheses](RemoveOutermostParentheses.md) | [1021](https://leetcode.com/problems/remove-outermost-parentheses/) | Depth counter | O(n) | O(1) |
| [Max Nesting Depth of Parentheses](MaxNestingDepth.md) | [1614](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/) | Depth counter, track max | O(n) | O(1) |

## String Conversions
| Question (notes) | LeetCode | Idea | Time | Space |
|---|---|---|---|---|
| [Roman to Integer](RomanToInteger.md) | [13](https://leetcode.com/problems/roman-to-integer/) | Subtract if smaller than next | O(n) | O(1) |
| [String to Integer (atoi)](StringToInteger.md) | [8](https://leetcode.com/problems/string-to-integer-atoi/) | Parse + pre-check overflow | O(n) | O(1) |

## Substring Problems
| Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|
| [Count Number of Substrings](CountSubstringsWithKDistinct.md) | [GfG](https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1) | atMost(K) − atMost(K−1) | O(n) | O(1) |
| [Longest Palindromic Substring](LongestPalindromicSubstring.md) | [LC 5](https://leetcode.com/problems/longest-palindromic-substring/) | Expand around centre | O(n²) | O(1) |
| [Sum of Beauty of All Substrings](SumOfBeautyOfAllSubstrings.md) | [LC 1781](https://leetcode.com/problems/sum-of-beauty-of-all-strings/) | Incremental 26-array | O(26·n²) | O(1) |

Note: the sheet lists "Count Number of Substrings" without a description. I implemented the standard "exactly K distinct characters" version, so please check it against what you remember.

## Run any program
```
javac -d out *.java
java -cp out LongestPalindromicSubstring
```

## Advanced string algorithms
Hashing, Rabin-Karp, Z function, KMP, Shortest Palindrome and more: see [advanced](advanced/README.md).

