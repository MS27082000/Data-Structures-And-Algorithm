# KMP Algorithm (LPS Array)

**Problem:** Find all occurrences of a pattern in a text in linear time.

**LPS array:** `lps[i]` = length of the longest **proper** prefix of `pat[0..i]` that is also a suffix of it. It tells how far the pattern can fall back after a mismatch without re-reading the text.
- Build: compare `pat[i]` with `pat[len]`. Equal -> `lps[i] = ++len`. Not equal and `len > 0` -> `len = lps[len-1]` (do **not** advance i). Else `lps[i] = 0`.

**Search:** One pointer `i` over the text, one `j` over the pattern. On a mismatch set `j = lps[j-1]` (the text pointer never goes back). When `j == m` record a match and set `j = lps[j-1]` to find overlapping matches.

**Brute force:** O(n * m).
**Optimised:** O(n + m) time, O(m) space.

**Edge cases:** Empty pattern, pattern longer than text, repeated letters (`aaaa`), overlapping matches.

**Interview traps**
- On a mismatch inside LPS construction, loop with `len = lps[len-1]` before giving up.
- After a full match fall back via `lps[m-1]` - not to 0.
- The LPS array is reused in several problems (Shortest Palindrome, Longest Happy Prefix, repeated substring pattern).

**How to explain:** "Before searching, I record for each prefix of the pattern how much of its start it repeats at its end; on a mismatch I jump back by that amount so no text character is read twice."
