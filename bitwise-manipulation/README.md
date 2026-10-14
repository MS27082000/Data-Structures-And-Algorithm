# Bit Manipulation

Source: Striver's A2Z DSA Sheet, Bit Manipulation section (14 items). Active recall: open the link, solve from scratch, then check the notes.

## When to use
- Parity, powers of two, set-bit counts, flags/masks
- "Everyone appears twice except…" → **XOR**
- Subsets via masks (`2ⁿ` combinations)
- Fast multiply/divide by powers of two

## The five identities to memorise
| Identity | Use |
|---|---|
| `n & (n - 1)` | Clear the lowest set bit (power of two, set-bit count) |
| `n & -n` | Isolate the lowest set bit (Single Number III) |
| `x ^ x = 0`, `x ^ 0 = x` | Cancel pairs |
| `(n >> i) & 1` | Read bit i |
| `n \| (n + 1)` | Set the rightmost unset bit |

## Theory
| Question (notes) | Idea |
|---|---|
| [Introduction to Bits and Tricks](BitTricks.md) | Operators, one-liners, two's complement, traps |

## Bit Fundamentals
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Check if the i-th Bit is Set](CheckIthBit.md) | [GfG](https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1) | `(n >> i) & 1` | O(1) |
| 2 | [Check if a Number is Odd](OddOrEven.md) | [GfG](https://www.geeksforgeeks.org/problems/odd-or-even3618/1) | `n & 1` | O(1) |
| 3 | [Check if a Number is a Power of 2](PowerOfTwo.md) | [LC 231](https://leetcode.com/problems/power-of-two/) | `n & (n-1) == 0` | O(1) |
| 4 | [Count the Number of Set Bits](CountSetBits.md) | [LC 191](https://leetcode.com/problems/number-of-1-bits/) | Brian Kernighan | O(k) |
| 5 | [Set the Rightmost Unset Bit](SetRightmostUnsetBit.md) | [GfG](https://www.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1) | `n \| (n+1)` | O(1) |
| 6 | [Swap Two Numbers](SwapTwoNumbers.md) | [GfG](https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1) | XOR swap | O(1) |

## Problems
| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 7 | [Minimum Bit Flips to Convert Number](MinBitFlips.md) | [LC 2220](https://leetcode.com/problems/minimum-bit-flips-to-convert-number/) | XOR then popcount | O(k) | O(1) |
| 8 | [Single Number I](SingleNumberI.md) | [LC 136](https://leetcode.com/problems/single-number/) | XOR all | O(n) | O(1) |
| 9 | [Single Number II](SingleNumberII.md) | [LC 137](https://leetcode.com/problems/single-number-ii/) | Bit counts mod 3 | O(32n) | O(1) |
| 10 | [Single Number III](SingleNumberIII.md) | [LC 260](https://leetcode.com/problems/single-number-iii/) | Split by a differing bit | O(n) | O(1) |
| 11 | [Divide Two Integers](DivideTwoIntegers.md) | [LC 29](https://leetcode.com/problems/divide-two-integers/) | Shift-and-subtract | O(log² n) | O(1) |
| 12 | Power Set (Bit Manipulation) | [GfG](https://www.geeksforgeeks.org/problems/power-set4302/1) | Bitmask over 2ⁿ | O(n·2ⁿ) | O(n·2ⁿ) |
| 13 | [XOR of Numbers in a Range](XorInRange.md) | [GfG](https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1) | Pattern of `n % 4` | O(1) | O(1) |

Item 12 (Power Set using bit manipulation) is already done in [backtracking/PowerSet](../backtracking/PowerSet.md) with the bitmask method, so it isn't repeated here.

## Run any program
```
javac -d out *.java
java -cp out SingleNumberIII
```
