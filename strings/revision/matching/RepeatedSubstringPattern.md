# Repeated Substring Pattern (LC 459)

**Problem:** Is `s` made by repeating a smaller substring two or more times?
`"abab"` → `true` (`ab` × 2), `"aba"` → `false`

**Brute force:** For each length `len` that divides `n`, repeat `s[0..len)` and compare with `s` → about O(n · number of divisors).

**The trick:** Build `s + s` and cut off the first and last character. If `s` still appears inside, the answer is `true`.

**Why it works:** If `s = block × k` (k ≥ 2), then `s + s = block × 2k`. Starting from index `len(block)` you can read `s` again, and that start is strictly inside, so cutting the ends does not destroy it. If `s` is not periodic, the only places `s` appears in `s + s` are index `0` and index `n`, exactly the two we cut away.

**Dry run (`"abab"`):**
- `s + s = "abababab"`, minus ends = `"bababa"`
- does `"bababa"` contain `"abab"`? Yes, at index 1 → `true`

**Dry run (`"aba"`):**
- `s + s = "abaaba"`, minus ends = `"baab"`, contains `"aba"`? No → `false`

**Complexity:** Time O(n) with a good `contains` (Java's `contains` is O(n·m) worst case; KMP guarantees O(n)). Space O(n).

**Edge cases:** Single character → `false`; `"aaaa"` → `true`.

**Interview traps:** Without trimming the ends, every string matches itself.

**Pattern:** Same trick as Rotate String (`goal` inside `s + s`): "cyclic / periodic" → doubled string.
