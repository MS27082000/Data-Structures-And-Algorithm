# Trie

Source: Striver's A2Z DSA Sheet, Tries (7 items). Active recall: open the link, solve from scratch, then check the notes.

## The essentials
- A trie is a tree where each edge is a character (or a bit). A word is a path from the root; shared prefixes share nodes.
- insert / search / startsWith are all **O(L)**, independent of the number of words.
- Cost: memory - up to 26 children per node.
- Binary trie: edges are 0/1 and a number is a 31-bit path. Used for **maximum XOR** problems (walk to the opposite bit).

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Bit Prerequisites for Trie Problems](BitPrerequisitesForTrie.md) | Theory | Bits as an MSB-first path | n/a |
| 2 | [Trie Implementation and Operations](ImplementTrie.md) | [LC 208](https://leetcode.com/problems/implement-trie-prefix-tree/) | Children array + isEnd flag | O(L) |
| 3 | [Trie Implementation and Advanced Operations](ImplementTrieII.md) | [Coding Ninjas](https://www.naukri.com/code360/problems/implement-trie_1387095) | endCount and prefixCount, erase | O(L) |
| 4 | [Longest Word with All Prefixes](LongestWordWithAllPrefixes.md) | [LC 720](https://leetcode.com/problems/longest-word-in-dictionary/) | Every node on the path must be a word end | O(total chars) |
| 5 | [Number of Distinct Substrings](NumberOfDistinctSubstrings.md) | [Coding Ninjas](https://www.naukri.com/code360/problems/count-distinct-substrings_985292) | Insert all suffixes, count new nodes | O(n^2) |
| 6 | [Maximum XOR of Two Numbers in an Array](MaximumXorOfTwoNumbers.md) | [LC 421](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) | Binary trie, go to the opposite bit | O(31n) |
| 7 | [Maximum XOR With an Element From Array](MaximumXorWithElementFromArray.md) | [LC 1707](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/) | Offline: sort queries by limit | O((n+q)*31) |

> Assumptions: the sheet's "Trie Implementation and Advanced Operations" is implemented as Implement Trie II (count equal, count prefix, erase). The Coding Ninjas links are from memory and may differ. Related: [Word Break](../dynamic-programming/dp-on-strings/README.md).

## Run any program
```
javac -d out *.java
java -cp out ImplementTrie
```
