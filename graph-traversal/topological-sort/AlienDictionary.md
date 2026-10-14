# Alien Dictionary (LC 269)

**Problem:** A list of words sorted lexicographically in an **unknown alphabet**. Deduce the order of the letters (any valid one), or return `""` if the input is inconsistent.

**Approach:**
1. **Nodes** = every distinct letter in the words.
2. For each **adjacent pair** of words, find the **first position where they differ**: letter `x` (earlier word) must come before `y` (later word) → edge `x → y`. Stop at the first difference (later letters tell nothing).
3. **Topologically sort** the letters (Kahn's algorithm). If a **cycle** exists → `""`.
4. **Prefix rule:** if the longer word comes **before** its own prefix (`"abc"` then `"ab"`) the input is invalid → `""`.
→ **O(total characters + alphabet)**.

**Intuition:** A dictionary is sorted by the first differing character, which gives pairwise ordering constraints between letters. A topological sort is the order satisfying all of them.

**Complexity:** Time O(C) for C = total characters (plus alphabet size), Space O(alphabet).

**Edge cases:** A single word, words that are all prefixes in the right order, a letter with no constraints (any position is fine), duplicate constraints (add each edge once), cyclic constraints (`"z","x","z"`).

**Interview traps**
- **Include every letter** as a node, even those with no edges, in the output.
- Add each edge **once** (use a `Set`), or the in-degrees are inflated.
- The **prefix-order check** is easy to forget.
- Don't compare non-adjacent words, and don't continue past the first difference.
- Multiple valid answers exist. Verify the result against the words.

**How to explain:** "Each adjacent pair of words gives one ordering rule from their first differing letters. I build a graph from those rules and topologically sort it; a cycle or a longer word before its prefix means the dictionary is impossible."
