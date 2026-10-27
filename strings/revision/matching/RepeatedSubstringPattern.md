# Repeated Substring Pattern (LC 459)

**Problem:** Can `s` be built by repeating a smaller substring two or more times?

**Brute force:** For each length that divides `n`, repeat the block and compare → O(n · d(n)).

**Trick:** Take `s + s`, remove the first and last character, and check if `s` is still inside. If `s` is a repeated block, it shows up at a shifted position. If not, the only matches are the two ends we removed.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Single character → false; whole string equals the block (only 1 repeat) → does not count.

**Interview traps:** Removing the first and last character is what stops the trivial match at index 0 and index n.

**Pattern:** Same idea as Rotate String (`s2` inside `s1 + s1`).
