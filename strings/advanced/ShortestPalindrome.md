# Shortest Palindrome (LC 214)

**Problem:** You may add characters only at the **front** of `s`. Return the shortest palindrome you can make.

**Intuition:** Find the longest palindromic **prefix** of s. The part after it, reversed, is what must go in front. So the answer is `reverse(rest) + s`.

**Finding the longest palindromic prefix fast:** Build `t = s + '#' + reverse(s)` and compute its LPS array. The last LPS value is the length of the longest prefix of s that equals a suffix of reverse(s) - which means a palindromic prefix of s.

**Brute force:** Shrink the end until `s[0..end]` is a palindrome, O(n^2).
**Optimised:** KMP/LPS in O(n) time and space. (Rolling hash also works.)

**Edge cases:** Empty string, already a palindrome (add nothing), all distinct letters (add everything except the first), `aaaaab`.

**Interview traps**
- The `#` separator stops the LPS from overlapping the two halves.
- Longest palindromic **prefix**, not substring.
- Prepend, do not append.

**How to explain:** "Keep the longest palindromic prefix as is, and mirror whatever comes after it onto the front. KMP's failure array finds that prefix in linear time."
