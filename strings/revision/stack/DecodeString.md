# Decode String (LC 394)

**Problem:** Decode strings like `3[a2[c]]` where `k[x]` means `x` repeated `k` times.

**Approach:** Keep a current `StringBuilder` and a number `k`.
- digit → build `k` (can be multi-digit)
- `[` → push `k` and the current string, start a fresh current string
- `]` → pop the previous string and count, append current `count` times to the previous one
- letter → append to current

**Complexity:** Time and space O(length of output).

**Edge cases:** Nested brackets; multi-digit counts (`10[a]`); letters outside brackets.

**Interview traps:** Reset `k = 0` after `[`. Counts can be more than one digit.

**Pattern:** "nested structure" → stack that saves the outer state when you go in and restores it when you come out.
