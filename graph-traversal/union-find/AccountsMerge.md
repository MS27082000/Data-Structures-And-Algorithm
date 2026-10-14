# Accounts Merge (LC 721)

**Problem:** `accounts[i] = [name, email1, email2, …]`. Two accounts belong to the **same person** if they share **any** email (sharing is transitive). Merge them and return `[name, sorted emails]` for each person. Different people may share a **name**, so don't merge by name.

**Approach (Union-Find over accounts):**
1. Map each **email → the first account index** that contained it.
2. If an email already has an owner, **union** the current account with that owner.
3. Group all emails by the **root** of their account, **sort** each group, and prepend the name.
→ **O(N · K · α + N · K log(N · K))** for N accounts of up to K emails.

**Alternative:** DFS on a graph where emails are connected within an account.

**Intuition:** Sharing an email is an equivalence relation, which is exactly what union-find models. The final groups are the connected components of accounts.

**Complexity:** Time O(NK log(NK)) (the sort), Space O(NK).

**Edge cases:** A chain of overlaps (a–b, b–c, c–d → one person), same name but no shared email (stay separate), a single account, duplicate emails inside an account.

**Interview traps**
- **Never merge by name.** Only by shared emails.
- Use a **sorted set** (`TreeSet`) per group for unique, sorted emails.
- Union **accounts**, not emails, then collect emails by root (or union emails directly).
- The output order is unspecified. Sort it only for deterministic tests.

**How to explain:** "I use union-find on the accounts. Whenever an email appears in a second account, I union the two accounts. At the end I gather every email under its account's root, sort them, and attach the name."
