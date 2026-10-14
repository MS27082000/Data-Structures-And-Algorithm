# GCD of Two Numbers

**Problem:** Greatest common divisor (HCF) of a and b.

**Intuition:** gcd(a, b) = gcd(b, a mod b); the remainders shrink fast until b is 0.

**Approach / complexity:** Brute force O(min(a, b)). Euclid O(log min(a, b)) time, O(1) space.

**Edge cases:** gcd(0, x) = x. Equal numbers. Co-prime numbers (1).

**Interview traps**
- Do not forget the base case b == 0.
- Euclid works with the remainder, not the difference (the difference version is slow).

**How to explain:** "I replace (a, b) with (b, a mod b) until the second number is zero; the first is the answer."
