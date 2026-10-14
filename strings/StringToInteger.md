# String to Integer, atoi (LC 8)

**Problem:** Implement `atoi`. Skip leading spaces, read an optional `+`/`-`, read digits until a non-digit, clamp to the 32-bit signed range. Return 0 if no valid number.

**Brute force:** Use `Integer.parseInt` / regex. Not allowed and it throws on bad input.
**Optimal:** A single pass, manual parsing with an **overflow check before each step** → O(n) time, O(1) space.

**Steps:** 1) skip spaces → 2) sign → 3) accumulate digits → 4) stop at the first non-digit → 5) clamp.

**Overflow check (key):** Before `result = result * 10 + digit`, check
`result > MAX/10 || (result == MAX/10 && digit > 7)`. If so, return `MAX` (or `MIN` for a negative sign).

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty string, only spaces, `"+-12"` (→ 0), `"0-1"` (→ 0), `"words and 987"` (→ 0, not 987), `"-91283472332"` (clamp to MIN), `"2147483648"` (clamp to MAX), `"-2147483648"` (valid, equals MIN).

**Interview traps**
- Detect overflow **before** it happens. After it happens the `int` has already wrapped.
- The digit limit is `7` for positive (MAX ends in 7). For `-2147483648` the digit 8 also needs the clamp, which happens to return MIN, the correct value.
- Only **one** sign is allowed, and it must come right after the spaces.
- Parsing stops at the first non-digit (don't skip invalid characters).

**How to explain:** "Skip whitespace, read one optional sign, then build the number digit by digit. Before multiplying by ten I check whether it would overflow, and clamp to the int limits if so."
