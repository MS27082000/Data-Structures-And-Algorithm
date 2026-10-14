# Design (Data Structure Design)

Source: Striver's A2Z DSA Sheet, Stack / Queues → FAQs (LRU Cache, LFU Cache) and Heaps → FAQs (Design Twitter). These are "design a data structure" problems that combine a hash map with an ordered structure or a heap. Active recall: open the link, solve from scratch, then check the notes.

## The pattern
Pick the structures so that **every operation is O(1)**:
- a **HashMap** for O(1) lookup by key,
- an **ordered structure** (doubly linked list or `LinkedHashSet`) to track recency or frequency with O(1) reordering and eviction.

## Questions
| # | Question (notes) | LeetCode | Structures | Time |
|---|---|---|---|---|
| 1 | [LRU Cache](LRUCache.md) | [146](https://leetcode.com/problems/lru-cache/) | HashMap + doubly linked list | O(1) |
| 2 | [LFU Cache](LFUCache.md) | [460](https://leetcode.com/problems/lfu-cache/) | HashMaps + frequency buckets (`LinkedHashSet`) + `minFreq` | O(1) |
| 3 | [Design Twitter](DesignTwitter.md) | [355](https://leetcode.com/problems/design-twitter/) | Tweet lists + follow sets; news feed = k-way merge with a heap | O(F log F) feed |

## LRU vs LFU
| | LRU | LFU |
|---|---|---|
| Evicts | Least **recently** used | Least **frequently** used (ties: least recently used) |
| Extra state | Recency order | Use counts + `minFreq` |
| Difficulty | Medium | Hard |

## Run any program
```
javac -d out *.java
java -cp out LRUCache
```
