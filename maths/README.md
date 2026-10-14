# Maths

Source: Striver's A2Z DSA Sheet, Maths (3 items, all under Sieve of Eratosthenes). Active recall: open the link, solve from scratch, then check the notes.

## The essentials
- A number n is composite if it has a divisor `<= sqrt(n)`, so trial division stops at the square root.
- **Sieve of Eratosthenes:** cross out multiples of each prime starting at `p*p`. O(N log log N).
- **SPF sieve:** store the smallest prime factor of every number; factorise any x in O(log x).
- **Segmented sieve:** for a huge R with a small range, sieve only the window using primes up to `sqrt(R)`.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Print All Primes Till N](PrintAllPrimesTillN.md) | [LC 204](https://leetcode.com/problems/count-primes/) / [GfG](https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1) | Sieve of Eratosthenes | O(N log log N) |
| 2 | [Prime Factorisation of a Number](PrimeFactorisation.md) | [GfG](https://www.geeksforgeeks.org/problems/prime-factorization-using-sieve/1) | Trial division, or SPF array | O(sqrt n) / O(log n) |
| 3 | [Count Primes in Range L to R](CountPrimesInRange.md) | [GfG](https://www.geeksforgeeks.org/problems/prime-numbers-in-a-range/1) | Prefix counts, or a segmented sieve | O(1) per query |

> The links are from memory and unverified. Basic maths topics (GCD, divisors, palindrome number, Armstrong number) belong to the Beginner Problems section of the sheet.

## Run any program
```
javac -d out *.java
java -cp out PrintAllPrimesTillN
```
