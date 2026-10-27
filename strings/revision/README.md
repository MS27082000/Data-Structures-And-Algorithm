# Strings: Quick Revision (Interview Patterns)

Goal: remember one idea per pattern so unseen questions feel familiar. Questions already solved elsewhere in this repo are only linked. New ones are in the folders here.

## 1. Frequency count (26-array / HashMap)
| Question | Where | Idea |
|---|---|---|
| Valid Anagram | [beginner](../../beginner/basic-strings/ValidAnagram.md) | Count up for `s`, down for `t` |
| Group Anagrams | [here](frequency-count/GroupAnagrams.md) | Sorted string (or counts) as map key |
| Find All Anagrams | [here](frequency-count/FindAllAnagrams.md) | Fixed window + count array |
| Ransom Note | [here](frequency-count/RansomNote.md) | Count magazine, consume with note |
| First Unique Character | [here](frequency-count/FirstUniqueCharacter.md) | Count, then scan in order |
| Isomorphic Strings | [beginner](../../beginner/basic-strings/IsomorphicStrings.md) | Maps in both directions |
| Word Pattern | [here](frequency-count/WordPattern.md) | Same as isomorphic, with words |
| Sort Characters by Frequency | [beginner](../../beginner/basic-strings/SortCharactersByFrequency.md) | Count, then sort or bucket |

## 2. Two pointers
| Question | Where | Idea |
|---|---|---|
| Valid Palindrome | [two-pointers](../../two-pointers/ValidPalindrome.md) | Skip junk, compare from ends |
| Valid Palindrome II | [two-pointers](../../two-pointers/ValidPalindromeII.md) | One mismatch: skip left or right |
| Reverse String | [beginner](../../beginner/basic-strings/ReverseStringII.md) | Swap from ends |
| Reverse Vowels | [here](two-pointers/ReverseVowels.md) | Swap only vowels |
| Reverse Words in a String | [advanced](../advanced/ReverseWordsInString.md) | Split / reverse words |
| Is Subsequence | [here](two-pointers/IsSubsequence.md) | One pointer per string |

## 3. Sliding window
| Question | Where | Idea |
|---|---|---|
| Longest Substring Without Repeating | [sliding-window](../../sliding-window/LongestSubstringWithoutRepeating.md) | Shrink when a repeat appears |
| Permutation in String | [here](sliding-window/PermutationInString.md) | Fixed window + count array |
| Longest Repeating Char Replacement | [sliding-window](../../sliding-window/LongestRepeatingCharacterReplacement.md) | `window - maxFreq <= k` |
| Minimum Window Substring | [sliding-window](../../sliding-window/MinimumWindowSubstring.md) | Expand until valid, then shrink |

## 4. Expand around centre
| Question | Where | Idea |
|---|---|---|
| Longest Palindromic Substring | [strings](../LongestPalindromicSubstring.md) | Odd and even centres, track max |
| Palindromic Substrings | [here](expand-around-center/PalindromicSubstrings.md) | Same, count every expansion |

## 5. Stack
| Question | Where | Idea |
|---|---|---|
| Valid Parentheses | [stack-and-queue](../../stack-and-queue/BalancedParentheses.md) | Push open, match on close |
| Remove All Adjacent Duplicates | [here](stack/RemoveAdjacentDuplicates.md) | Pop if same as top |
| Min Remove to Make Valid Parentheses | [here](stack/MinRemoveToMakeValid.md) | Stack of indices, mark extras |
| Decode String | [here](stack/DecodeString.md) | Save outer state on `[`, restore on `]` |

## 6. Prefix and matching
| Question | Where | Idea |
|---|---|---|
| Longest Common Prefix | [beginner](../../beginner/basic-strings/LongestCommonPrefix.md) | Shrink prefix against each word |
| Find First Occurrence (strStr) | [here](matching/FindFirstOccurrence.md) | Try each start (KMP is the follow-up) |
| Repeated Substring Pattern | [here](matching/RepeatedSubstringPattern.md) | `s` inside `(s+s)` minus ends |
| Rotate String | [beginner](../../beginner/basic-strings/RotateString.md) | `goal` inside `s+s` |

## 7. Parsing and simulation
| Question | Where | Idea |
|---|---|---|
| String to Integer (atoi) | [strings](../StringToInteger.md) | Sign, digits, overflow check |
| Roman to Integer | [strings](../RomanToInteger.md) | Subtract if smaller than next |
| Integer to Roman | [here](parsing/IntegerToRoman.md) | Greedy with subtractive pairs |
| Add Binary | [here](parsing/AddBinary.md) | Right to left with carry |
| Multiply Strings | [here](parsing/MultiplyStrings.md) | `int[n+m]`, digit i,j → i+j, i+j+1 |
| String Compression | [here](parsing/StringCompression.md) | Reader/writer pointers |
| Count and Say | [advanced](../advanced/CountAndSay.md) | Run-length of previous term |

## Run any program
```
javac -d out frequency-count/*.java
java -cp out GroupAnagrams
```
