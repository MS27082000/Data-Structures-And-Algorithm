# Reverse Vowels of a String (LC 345)

**Problem:** Reverse only the vowels (both cases) of the string. Other characters stay in place.

**Approach:** Two pointers from both ends. Move each pointer until it sits on a vowel, swap, move both inward.

**Complexity:** Time O(n), Space O(n) (char array, strings are immutable).

**Edge cases:** No vowels; uppercase vowels (`'A'`, `'E'`...); single character.

**Interview traps:** Keep `left < right` inside the inner while loops. Include uppercase vowels.

**Pattern:** "do something only to some characters, from both ends" → two pointers that skip the rest.
