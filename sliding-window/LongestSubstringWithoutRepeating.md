# Longest Substring Without Repeating Characters (LC 3)

**Problem:** Length of the longest substring with all distinct characters.

**Brute force:** Check every substring with a set → O(n²) to O(n³).
**Better:** Sliding window + `HashSet`: add `s[right]`; while it's already in the set, remove `s[left]` and `left++` → O(n) (each char added/removed at most once).
**Optimal:** Store the **last index** of every character. On a repeat, **jump** `left` directly to `lastIndex + 1` → O(n), single pass.

**Intuition:** The window must never contain duplicates. When `s[right]` repeats a character inside the window, the new window must start just after that earlier copy.

**Complexity:** Time O(n), Space O(min(n, alphabet)) → O(1) with a fixed-size array.

**Edge cases:** Empty string (0), all same (`"bbbbb"` → 1), all distinct, `"abba"` (answer 2), a space character.

**Interview traps**
- **`if (lastIndex[c] >= left)`**: only jump if the old copy is **inside** the current window. Otherwise `left` would move **backwards** (`"abba"` returns 3 instead of 2).
- Use `left = lastIndex + 1`, not `lastIndex`.
- A substring is **contiguous**, unlike a subsequence.
- Use `int[256]` (or 128) for ASCII, or a `HashMap` for Unicode.

**How to explain:** "I track where each character last appeared. When I see a repeat inside my window I move the left edge just past the previous occurrence. The window always holds distinct characters, and I record its length each step."
