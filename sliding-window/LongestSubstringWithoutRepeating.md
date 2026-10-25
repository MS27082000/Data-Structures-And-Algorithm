# Longest Substring Without Repeating Characters (LC 3)

**Problem:** Return the length of the longest substring (contiguous) in which all characters are distinct.

`"abcabcbb"` → `3` (`"abc"`)

## The three answers

| Question | Answer |
|---|---|
| What do I track (state)? | a map: character → count in the window |
| When is the window invalid? | the **incoming** character is already in the map |
| What changes when `left` leaves? | decrease its count; **remove the key when the count is 0** |

## Approach 1: map and step-by-step shrink

1. For each `right`, take `ch = s[right]`.
2. **While** `ch` is already in the map: remove `s[left]` from the map (decrease the count, delete the key at 0), then `left++`.
3. Now `ch` is not in the window. **Add** it to the map.
4. Update `maxLen = max(maxLen, right - left + 1)`.

Here the shrink comes **before** the add. That's fine, because the invalid condition only needs the incoming character (`ch`). It doesn't need the window after the add.

```java
Map<Character, Integer> map = new HashMap<>();
int left = 0, maxLen = 0;

for (int right = 0; right < s.length(); right++) {
    char ch = s.charAt(right);

    while (map.containsKey(ch)) {
        char leftChar = s.charAt(left);
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) == 0) {
            map.remove(leftChar);
        }
        left++;
    }

    map.put(ch, map.getOrDefault(ch, 0) + 1);
    maxLen = Math.max(maxLen, right - left + 1);
}
return maxLen;
```

### Dry run: `"abcabcbb"`

```
right=0 ('a')  not in window   add          window "a"    length 1   maxLen=1
right=1 ('b')  not in window   add          window "ab"   length 2   maxLen=2
right=2 ('c')  not in window   add          window "abc"  length 3   maxLen=3
right=3 ('a')  'a' IS in window → remove s[0]='a', left=1 → add 'a'
                                            window "bca"  length 3   maxLen=3
right=4 ('b')  'b' IS in window → remove s[1]='b', left=2 → add 'b'
                                            window "cab"  length 3   maxLen=3
right=5 ('c')  'c' IS in window → remove s[2]='c', left=3 → add 'c'
                                            window "abc"  length 3   maxLen=3
right=6 ('b')  'b' IS in window → remove s[3]='a', left=4 ('b' still there)
                                  remove s[4]='b', left=5 → add 'b'
                                            window "cb"   length 2   maxLen=3
right=7 ('b')  'b' IS in window → remove s[5]='c', left=6 ('b' still there)
                                  remove s[6]='b', left=7 → add 'b'
                                            window "b"    length 1   maxLen=3
```

Answer: `3`.

**Complexity:** time O(n) (each character is added once and removed once), space O(min(n, alphabet size)).

## Approach 2: jump `left` using the last index

Store each character's **last index**. When `ch` repeats inside the window, move `left` straight to `lastIndex + 1`, with no step-by-step removal.

```java
int[] lastIndex = new int[256];
Arrays.fill(lastIndex, -1);
int left = 0, best = 0;

for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    if (lastIndex[c] >= left) left = lastIndex[c] + 1;   // only if the old copy is INSIDE the window
    lastIndex[c] = right;
    best = Math.max(best, right - left + 1);
}
return best;
```

**Why `lastIndex[c] >= left`:** the old copy may be outside the window already. Then `left` must not move backward. On `"abba"`, without this check the answer is `3` instead of `2`.

## Common mistakes

- Using a HashSet only works here because each character appears **once** in the window. It doesn't work for "at most k distinct" questions, where counts matter.
- In approach 2, forgetting the `>= left` check (`left` moves backward).
- In approach 2, writing `left = lastIndex` instead of `lastIndex + 1`.

**Edge cases:** empty string (0), all the same (`"bbbbb"` → 1), all distinct, `"abba"` (answer 2), a space character.

**How to explain:** "The window never holds a repeat. When the new character is already inside, I move the left edge forward until it's gone, then add it. I track the longest window."
