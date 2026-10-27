# Strings: Quick Revision (Interview Patterns)

Goal: remember one idea per pattern so unseen questions feel familiar. Questions already solved elsewhere in this repo are only linked. New ones are in the folders here.

## 1. Frequency count (26-array / HashMap)
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| Valid Anagram | [LC 242](https://leetcode.com/problems/valid-anagram/) | [beginner](../../beginner/basic-strings/ValidAnagram.md) | Count up for `s`, down for `t` |
| Group Anagrams | [LC 49](https://leetcode.com/problems/group-anagrams/) | [here](frequency-count/GroupAnagrams.md) | Sorted string (or counts) as map key |
| Find All Anagrams | [LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [here](frequency-count/FindAllAnagrams.md) | Fixed window + count array |
| Ransom Note | [LC 383](https://leetcode.com/problems/ransom-note/) | [here](frequency-count/RansomNote.md) | Count magazine, consume with note |
| First Unique Character | [LC 387](https://leetcode.com/problems/first-unique-character-in-a-string/) | [here](frequency-count/FirstUniqueCharacter.md) | Count, then scan in order |
| Isomorphic Strings | [LC 205](https://leetcode.com/problems/isomorphic-strings/) | [beginner](../../beginner/basic-strings/IsomorphicStrings.md) | Maps in both directions |
| Word Pattern | [LC 290](https://leetcode.com/problems/word-pattern/) | [here](frequency-count/WordPattern.md) | Same as isomorphic, with words |
| Sort Characters by Frequency | [LC 451](https://leetcode.com/problems/sort-characters-by-frequency/) | [beginner](../../beginner/basic-strings/SortCharactersByFrequency.md) | Count, then sort or bucket |

## 2. Two pointers
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| Valid Palindrome | [LC 125](https://leetcode.com/problems/valid-palindrome/) | [two-pointers](../../two-pointers/ValidPalindrome.md) | Skip junk, compare from ends |
| Valid Palindrome II | [LC 680](https://leetcode.com/problems/valid-palindrome-ii/) | [two-pointers](../../two-pointers/ValidPalindromeII.md) | One mismatch: skip left or right |
| Reverse String | [LC 344](https://leetcode.com/problems/reverse-string/) | [beginner](../../beginner/basic-strings/ReverseStringII.md) | Swap from ends |
| Reverse Vowels | [LC 345](https://leetcode.com/problems/reverse-vowels-of-a-string/) | [here](two-pointers/ReverseVowels.md) | Swap only vowels |
| Reverse Words in a String | [LC 151](https://leetcode.com/problems/reverse-words-in-a-string/) | [advanced](../advanced/ReverseWordsInString.md) | Split / reverse words |
| Is Subsequence | [LC 392](https://leetcode.com/problems/is-subsequence/) | [here](two-pointers/IsSubsequence.md) | One pointer per string |

## 3. Sliding window
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| Longest Substring Without Repeating | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [sliding-window](../../sliding-window/LongestSubstringWithoutRepeating.md) | Shrink when a repeat appears |
| Permutation in String | [LC 567](https://leetcode.com/problems/permutation-in-string/) | [here](sliding-window/PermutationInString.md) | Fixed window + count array |
| Longest Repeating Char Replacement | [LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) | [sliding-window](../../sliding-window/LongestRepeatingCharacterReplacement.md) | `window - maxFreq <= k` |
| Minimum Window Substring | [LC 76](https://leetcode.com/problems/minimum-window-substring/) | [sliding-window](../../sliding-window/MinimumWindowSubstring.md) | Expand until valid, then shrink |

## 4. Expand around centre
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| Longest Palindromic Substring | [LC 5](https://leetcode.com/problems/longest-palindromic-substring/) | [strings](../LongestPalindromicSubstring.md) | Odd and even centres, track max |
| Palindromic Substrings | [LC 647](https://leetcode.com/problems/palindromic-substrings/) | [here](expand-around-center/PalindromicSubstrings.md) | Same, count every expansion |

## 5. Stack
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| Valid Parentheses | [LC 20](https://leetcode.com/problems/valid-parentheses/) | [stack-and-queue](../../stack-and-queue/BalancedParentheses.md) | Push open, match on close |
| Remove All Adjacent Duplicates | [LC 1047](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | [here](stack/RemoveAdjacentDuplicates.md) | Pop if same as top |
| Min Remove to Make Valid Parentheses | [LC 1249](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) | [here](stack/MinRemoveToMakeValid.md) | Stack of indices, mark extras |
| Decode String | [LC 394](https://leetcode.com/problems/decode-string/) | [here](stack/DecodeString.md) | Save outer state on `[`, restore on `]` |

## 6. Prefix and matching
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| Longest Common Prefix | [LC 14](https://leetcode.com/problems/longest-common-prefix/) | [beginner](../../beginner/basic-strings/LongestCommonPrefix.md) | Shrink prefix against each word |
| Find First Occurrence (strStr) | [LC 28](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | [here](matching/FindFirstOccurrence.md) | Try each start (KMP is the follow-up) |
| Repeated Substring Pattern | [LC 459](https://leetcode.com/problems/repeated-substring-pattern/) | [here](matching/RepeatedSubstringPattern.md) | `s` inside `(s+s)` minus ends |
| Rotate String | [LC 796](https://leetcode.com/problems/rotate-string/) | [beginner](../../beginner/basic-strings/RotateString.md) | `goal` inside `s+s` |

## 7. Parsing and simulation
| Question | LeetCode | Where | Idea |
|---|---|---|---|
| String to Integer (atoi) | [LC 8](https://leetcode.com/problems/string-to-integer-atoi/) | [strings](../StringToInteger.md) | Sign, digits, overflow check |
| Roman to Integer | [LC 13](https://leetcode.com/problems/roman-to-integer/) | [strings](../RomanToInteger.md) | Subtract if smaller than next |
| Integer to Roman | [LC 12](https://leetcode.com/problems/integer-to-roman/) | [here](parsing/IntegerToRoman.md) | Greedy with subtractive pairs |
| Add Binary | [LC 67](https://leetcode.com/problems/add-binary/) | [here](parsing/AddBinary.md) | Right to left with carry |
| Multiply Strings | [LC 43](https://leetcode.com/problems/multiply-strings/) | [here](parsing/MultiplyStrings.md) | `int[n+m]`, digit i,j → i+j, i+j+1 |
| String Compression | [LC 443](https://leetcode.com/problems/string-compression/) | [here](parsing/StringCompression.md) | Reader/writer pointers |
| Count and Say | [LC 38](https://leetcode.com/problems/count-and-say/) | [advanced](../advanced/CountAndSay.md) | Run-length of previous term |

## Run any program
```
javac -d out frequency-count/*.java
java -cp out GroupAnagrams
```
