# Basic Maths

Source: Striver's A2Z DSA Sheet, Beginner Problems. Digits, divisors, primes, GCD/LCM. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Count All Digits](CountDigits.md) | - | Divide by 10 until 0 | O(log n) |
| 2 | [Count Odd Digits](CountOddDigits.md) | - | Peel digits with % 10 | O(log n) |
| 3 | [Reverse a Number](ReverseNumber.md) | [LC 7](https://leetcode.com/problems/reverse-integer/) | rev = rev*10 + digit; guard overflow | O(log n) |
| 4 | [Palindrome Number](PalindromeNumber.md) | [LC 9](https://leetcode.com/problems/palindrome-number/) | Reverse half the digits | O(log n) |
| 5 | [Largest Digit](LargestDigit.md) | - | Running maximum | O(log n) |
| 6 | [Factorial](Factorial.md) | - | Product 2..n; long overflows at 21! | O(n) |
| 7 | [Armstrong Number](ArmstrongNumber.md) | [GfG](https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1) | Sum of d^k equals n | O(log n) |
| 8 | [Perfect Number](PerfectNumber.md) | [GfG](https://www.geeksforgeeks.org/problems/perfect-numbers3207/1) | Divisor pairs up to sqrt n | O(sqrt n) |
| 9 | [Prime Number](PrimeCheck.md) | [GfG](https://www.geeksforgeeks.org/problems/prime-number2314/1) | Trial division to sqrt n | O(sqrt n) |
| 10 | [Count Primes Till N](CountPrimesTillN.md) | [LC 204](https://leetcode.com/problems/count-primes/) | Sieve of Eratosthenes | O(n log log n) |
| 11 | [GCD](GCDOfTwoNumbers.md) | [GfG](https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1) | Euclid | O(log n) |
| 12 | [LCM](LCMOfTwoNumbers.md) | [GfG](https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1) | a / gcd * b | O(log n) |
| 13 | [Divisors of a Number](DivisorsOfNumber.md) | [GfG](https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1) | Pairs (d, n/d) up to sqrt n | O(sqrt n) |

> Related: the prime sieve family in [maths](../../maths/README.md).

## Run any program
```
javac -d out *.java
java -cp out GCDOfTwoNumbers
```
