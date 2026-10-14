# Basic Strings

Source: Striver's A2Z DSA Sheet, Beginner Problems. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Reverse a String II](ReverseStringII.md) | [LC 541](https://leetcode.com/problems/reverse-string-ii/) | Reverse first k of every 2k | O(n) |
| 2 | [Palindrome Check](PalindromeCheck.md) | [LC 125](https://leetcode.com/problems/valid-palindrome/) | Two pointers | O(n) |
| 3 | [Largest Odd Number in a String](LargestOddNumberInString.md) | [LC 1903](https://leetcode.com/problems/largest-odd-number-in-string/) | Prefix up to the last odd digit | O(n) |
| 4 | [Longest Common Prefix](LongestCommonPrefix.md) | [LC 14](https://leetcode.com/problems/longest-common-prefix/) | Vertical scan | O(total chars) |
| 5 | [Isomorphic Strings](IsomorphicStrings.md) | [LC 205](https://leetcode.com/problems/isomorphic-strings/) | Maps in both directions | O(n) |
| 6 | [Rotate String](RotateString.md) | [LC 796](https://leetcode.com/problems/rotate-string/) | goal inside s + s | O(n) |
| 7 | [Valid Anagram](ValidAnagram.md) | [LC 242](https://leetcode.com/problems/valid-anagram/) | Count letters up and down | O(n) |
| 8 | [Sort Characters by Frequency](SortCharactersByFrequency.md) | [LC 451](https://leetcode.com/problems/sort-characters-by-frequency/) | Bucket by frequency | O(n) |

> Assumption: the sheet's Reverse a String II is implemented as LC 541.

## Run any program
```
javac -d out *.java
java -cp out ValidAnagram
```
