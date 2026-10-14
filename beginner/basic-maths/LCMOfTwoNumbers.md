# LCM of Two Numbers

**Problem:** Smallest number divisible by both a and b.

**Intuition:** a * b = gcd * lcm, so lcm = a / gcd * b.

**Approach / complexity:** O(log min(a, b)) time, O(1) space.

**Edge cases:** Zero input -> 0. Equal numbers. Co-prime numbers (the product). Large values.

**Interview traps**
- Divide before multiplying so the intermediate cannot overflow.
- Use long.

**How to explain:** "I compute the GCD with Euclid and then lcm = a / gcd * b."
