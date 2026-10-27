# Ransom Note (LC 383)

**Problem:** Can `ransomNote` be made using letters from `magazine`, each letter used once?

**Approach:** Count letters of `magazine` in a 26-array. For each letter of the note, decrement; if a count goes below 0, return false.

**Complexity:** Time O(n + m), Space O(1).

**Edge cases:** Note longer than magazine → false; empty note → true.

**Interview traps:** Order of the arguments. Count the **magazine**, consume with the **note**.

**Pattern:** "can A be built from B" → frequency array, subtract, check negative.
