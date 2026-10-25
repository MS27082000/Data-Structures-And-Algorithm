# Number of Substrings Containing All Three Characters (LC 1358)

**Problem:** `s` has only `a`, `b`, `c`. Count substrings that contain **at least one of each**.

## Main approach: atMost(3) − atMost(2)

`s` has only `a`, `b`, `c`, so a substring that contains all three has **exactly 3 distinct characters**.

```
answer = atMost(3) - atMost(2)
```

`atMost(k)` = number of substrings with at most `k` distinct characters.

| Question | Answer |
|---|---|
| State | map: character → count in the window |
| Invalid when | `map.size() > k` |
| When `left` leaves | decrease its count, remove the key at 0 |

Steps for `atMost(k)`:
1. **Add** `s[right]` to the map.
2. **While** `map.size() > k`: shrink from the left.
3. **Count** `right - left + 1`. These are all valid substrings ending at `right`.

```java
public int numberOfSubstrings(String s) {
    int k = 3;
    return numberOfSubstringsAtMostK(s, k) - numberOfSubstringsAtMostK(s, k - 1);
}

private static int numberOfSubstringsAtMostK(String s, int k) {
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int count = 0;
    for (int right = 0; right < s.length(); right++) {
        char rightChar = s.charAt(right);
        map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
        while (map.size() > k) {
            char leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            left++;
        }
        count += right - left + 1;
    }
    return count;
}
```

**Dry run: `"abc"`**

`atMost(3)`:
```
right=0 'a'  map={a:1}          size 1   left=0   count += 1 → 1
right=1 'b'  map={a:1,b:1}      size 2   left=0   count += 2 → 3
right=2 'c'  map={a:1,b:1,c:1}  size 3   left=0   count += 3 → 6
```
`atMost(2)`:
```
right=0 'a'  map={a:1}          size 1   left=0   count += 1 → 1
right=1 'b'  map={a:1,b:1}      size 2   left=0   count += 2 → 3
right=2 'c'  map={a:1,b:1,c:1}  size 3 > 2 → remove s[0]='a', left=1
                                size 2   left=1   count += 2 → 5
```
Answer: `6 − 5 = 1`.

**Complexity:** time O(n), space O(1).

The same trick counts "exactly k distinct" in other problems: `atMost(k) − atMost(k − 1)`.

## Other approaches

**Brute force:** Check every substring → O(n²) or O(n³).
**Optimal (last seen):** Keep the last index of `a`, `b`, `c`. For each `right`, a valid substring ending at `right` can start anywhere from `0` up to `min(lastA, lastB, lastC)`, so add `min + 1` (it's `0` if some letter hasn't appeared, because `min = -1`) → O(n), O(1).
**Window version:** For each `left`, find the smallest `right` with all three present. Then every longer end also works: add `n − right`. Shrink and repeat.

**Intuition:** Once a window ending at `right` contains all three letters, **extending the start further left keeps it valid**. So you count all starts at or before the earliest of the three last positions.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Missing a letter (0), exactly `"abc"` (1), a long run of one letter, repeated cycles `"abcabc"` (10).

**Interview traps**
- Count **substrings ending at `right`**, not windows of minimal size.
- When a letter hasn't appeared, `last = -1` makes `min + 1 = 0` automatically.
- In the window version add `n − right` (all ends from `right` to `n−1`), then shrink.
- Same monotonic idea as Count Subarrays problems. Superset windows of a valid window stay valid.

**How to explain:** "For each end position, the substrings that contain all three letters start at or before the leftmost of the three most recent occurrences, so I add that position plus one."
