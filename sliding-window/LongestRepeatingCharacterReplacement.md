# Longest Repeating Character Replacement (LC 424)

**Problem:** String `s` of uppercase letters, and `k`. You can change at most `k` letters to any letter. Return the length of the longest substring of one repeated letter you can get.

`"AABABBA"`, `k = 1` → `4`

## Idea

In a window, keep the most frequent letter and change the rest:

```
changes needed = window length - maxFreq
```

The window is valid if `changes needed <= k`. Find the **longest valid window**.

## Brute force: O(n²)

For every start `i`, extend `j`. Keep letter counts and `maxFreq`. If the window is valid, update the best length. If not, stop extending.

## Sliding window: O(n)

One window, one `freq[26]` array.

| Question | Answer |
|---|---|
| State | `freq[26]`, `maxFreq` |
| Invalid when | `(right - left + 1) - maxFreq > k` |
| When `left` leaves | `freq[s[left]]--` |

Steps:
1. **Add** `s[right]`, update `maxFreq`.
2. **While** invalid: `freq[s[left]]--`, `left++`.
3. **Update** `maxLen = max(maxLen, right - left + 1)`.

## Code

```java
int[] freq = new int[26];
int left = 0, maxLen = 0, maxFreq = 0;

for (int right = 0; right < s.length(); right++) {
    char ch = s.charAt(right);
    freq[ch - 'A']++;
    maxFreq = Math.max(maxFreq, freq[ch - 'A']);

    while ((right - left + 1) - maxFreq > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
return maxLen;
```

## Dry run: `"AABABBA"`, `k = 1`

```
right=0 'A'  A=1          maxFreq=1  length 1  changes 0  valid    maxLen=1
right=1 'A'  A=2          maxFreq=2  length 2  changes 0  valid    maxLen=2
right=2 'B'  A=2,B=1      maxFreq=2  length 3  changes 1  valid    maxLen=3
right=3 'A'  A=3,B=1      maxFreq=3  length 4  changes 1  valid    maxLen=4
right=4 'B'  A=3,B=2      maxFreq=3  length 5  changes 2 > 1 → remove s[0]='A', left=1
                                     length 4  changes 1  valid    maxLen=4
right=5 'B'  A=2,B=3      maxFreq=3  length 5  changes 2 > 1 → remove s[1]='A', left=2
                                     length 4  changes 1  valid    maxLen=4
right=6 'A'  A=2,B=3      maxFreq=3  length 5  changes 2 > 1 → remove s[2]='B', left=3
                                     length 4  changes 1  valid    maxLen=4
```

Answer: `4`.

## Why `maxFreq` is never decreased

When `left` leaves, `maxFreq` may become too big for the window. That's fine. The answer can only grow when `maxFreq` gets a **new bigger** value, so a stale `maxFreq` can't give a wrong, longer answer.

**Complexity:** time O(n), space O(26).

**Edge cases:** `k = 0` (longest run of one letter), `k >= n` (the whole string), a single letter.

**How to explain:** "A window needs `length - maxFreq` changes. I grow the window, and when it needs more than `k` changes I shrink it from the left, tracking the longest valid window."
