# Assign Cookies (LC 455)

**Problem:** Child `i` has greed `g[i]` (minimum cookie size to be content). Cookie `j` has size `s[j]`. Each child gets at most one cookie, each cookie goes to at most one child. Maximise the number of content children.

**Brute force:** Try all assignments (matching) → exponential.
**Optimal (greedy):** Sort both arrays. With two pointers, give each child the **smallest cookie that satisfies them**; if a cookie is too small for the current (least greedy) child, no later child can use it either, so skip it.

**Why greedy is correct (exchange argument):** Giving a child a bigger cookie than needed can never help, since a bigger cookie could have satisfied a greedier child. So use the smallest sufficient cookie and keep the big ones for greedier children.

**Complexity:** Time O(n log n + m log m) (sorting), Space O(1) extra.

**Edge cases:** No children or no cookies, all cookies too small, more cookies than children, duplicates.

**Interview traps**
- **Sort both arrays**; the two-pointer logic depends on it.
- Advance the cookie pointer **every iteration**; advance the child pointer only when satisfied.
- Be ready to justify why smallest-sufficient-cookie is optimal.

**How to explain:** "Sort children by greed and cookies by size. For each cookie from smallest up, if it satisfies the least greedy unsatisfied child, give it to them. Otherwise it's too small for everyone left, so I skip it."
