# Count and Say (LC 38)

**Problem:** Term 1 is `"1"`. Each next term describes the previous one by runs: `"21"` is "one 2, one 1" so the next is `"1211"`. Return term n.

**Intuition:** It is run-length encoding applied n-1 times: for each run of equal digits write `count` then `digit`.

**Brute force / standard:** Build term by term with a `StringBuilder` and two pointers over runs. Recursion works too.
**Complexity:** Time and space proportional to the total length of the terms; the length grows roughly 30% per term (term 30 has 4462 characters).

**Edge cases:** n = 1 -> `"1"`. The last run must be flushed after the loop.

**Interview traps**
- Forgetting to emit the last run.
- Use `StringBuilder`, not repeated string concatenation.
- Digits never exceed 3, so a count is always one digit.

**How to explain:** "Each term is the run-length encoding of the previous one, so I repeat that encoding n-1 times."
