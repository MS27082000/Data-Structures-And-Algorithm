# Strings - Advanced Algorithms

Source: Striver's A2Z DSA Sheet, Strings (Advanced Algo) (9 items). Basic string problems are in [strings](../README.md). Active recall: open the link, solve from scratch, then check the notes.

## The essentials
- **Hashing:** O(1) substring comparison after an O(n) prefix-hash build. Verify on a match.
- **KMP / LPS:** linear matching; `lps[i]` = longest proper prefix of `pat[0..i]` that is also its suffix.
- **Z function:** `z[i]` = longest match of the suffix at i with the prefix. Match with `pattern + '#' + text`.
- LPS and Z solve the same family: pattern search, borders, palindromic prefixes, repeated patterns.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Reverse Words in a String](ReverseWordsInString.md) | [LC 151](https://leetcode.com/problems/reverse-words-in-a-string/) | Words from the right, or reverse-all then each word | O(n) |
| 2 | [Minimum Bracket Reversals](MinimumBracketReversals.md) | [GfG](https://www.geeksforgeeks.org/problems/count-the-reversals0401/1) | Cancel pairs; ceil(close/2) + ceil(open/2) | O(n) |
| 3 | [Count and Say](CountAndSay.md) | [LC 38](https://leetcode.com/problems/count-and-say/) | Run-length encode n-1 times | O(total length) |
| 4 | [Hashing in Strings (theory)](HashingInStrings.md) | Theory | Prefix hash, O(1) substring hash | O(n) build |
| 5 | [Rabin-Karp Algorithm](RabinKarp.md) | [GfG](https://www.geeksforgeeks.org/problems/search-pattern0205/1) | Rolling hash, verify matches | O(n+m) avg |
| 6 | [Z Function](ZFunction.md) | [GfG](https://www.geeksforgeeks.org/problems/search-pattern-z-algorithm--141631/1) | Window of the rightmost prefix match | O(n+m) |
| 7 | [KMP Algorithm / LPS Array](KMPAlgorithm.md) | [GfG](https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1) | Failure array, never move the text pointer back | O(n+m) |
| 8 | [Shortest Palindrome](ShortestPalindrome.md) | [LC 214](https://leetcode.com/problems/shortest-palindrome/) | LPS of s + '#' + reverse(s) | O(n) |
| 9 | [Longest Happy Prefix](LongestHappyPrefix.md) | [LC 1392](https://leetcode.com/problems/longest-happy-prefix/) | lps[n-1] | O(n) |

> Assumptions: the sheet gives no description for the bracket-reversal item, so it is the GfG "Count the Reversals" problem (only `{` and `}`). The GfG links are from memory and unverified.

## Run any program
```
javac -d out *.java
java -cp out KMPAlgorithm
```
