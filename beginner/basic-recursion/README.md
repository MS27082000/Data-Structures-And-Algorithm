# Basic Recursion

Source: Striver's A2Z DSA Sheet, Beginner Problems. Two theory items (Recursion Theory, Recursion Concepts with Parameters) are covered together in RecursionBasics. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Recursion Theory and Concepts with Parameters](RecursionBasics.md) | Theory | Base case, call stack, parameterised vs functional | - |
| 2 | [Sum of First N Numbers](SumOfFirstNNumbers.md) | - | n + sum(n-1) | O(n) |
| 3 | [Factorial](FactorialRecursive.md) | - | n * (n-1)! | O(n) |
| 4 | [Sum of Array Elements II](SumOfArrayElementsII.md) | - | arr[i] + sum(i+1) | O(n) |
| 5 | [Reverse a String I](ReverseStringI.md) | [LC 344](https://leetcode.com/problems/reverse-string/) | Swap the ends and recurse | O(n) |
| 6 | [Palindrome String](PalindromeStringRecursive.md) | - | Compare ends, recurse inside | O(n) |
| 7 | [Prime Number](PrimeCheckRecursive.md) | - | Recurse over divisors to sqrt n | O(sqrt n) |
| 8 | [Reverse an Array 2](ReverseArrayII.md) | - | Swap ends, recurse inwards | O(n) |
| 9 | [Check if Array is Sorted II](CheckIfArrayIsSortedII.md) | - | Adjacent pair + rest sorted | O(n) |
| 10 | [Sum of Digits](SumOfDigits.md) | - | n % 10 + sum(n / 10) | O(log n) |
| 11 | [Fibonacci Number](FibonacciNumber.md) | [LC 509](https://leetcode.com/problems/fibonacci-number/) | Recursion, memo, two variables | O(n) |

## Run any program
```
javac -d out *.java
java -cp out RecursionBasics
```
