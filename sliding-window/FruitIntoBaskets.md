# Fruit Into Baskets (LC 904)

**Problem:** Trees in a row, `fruits[i]` is the fruit type of tree `i`. You have **two baskets**, each holding one type (any amount). Starting at any tree, you pick one fruit from every tree moving right, and stop when a fruit doesn't fit. Return the maximum fruits picked.

`[1, 2, 3, 2, 2]` → `4` (pick `[2, 3, 2, 2]`)

## Idea

Picking from consecutive trees with only 2 types is the same as: **the longest subarray with at most 2 distinct values.**

## The three answers

| Question | Answer |
|---|---|
| What do I track (state)? | a map: fruit type → count in the window |
| When is the window invalid? | `map.size() > 2` |
| What changes when `left` leaves? | decrease its count; **remove the key when the count is 0** |

## Steps (the order matters)

1. **Add** `fruits[right]` to the map.
2. **While** `map.size() > 2`: shrink from the left.
3. The window is valid now. **Update** `maxLen`.

## Code

```java
Map<Integer, Integer> map = new HashMap<>();
int maxLen = 0, left = 0, k = 2;

for (int right = 0; right < fruits.length; right++) {
    map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);   // 1. add

    while (map.size() > k) {                                          // 2. shrink
        map.put(fruits[left], map.get(fruits[left]) - 1);
        if (map.get(fruits[left]) == 0) {
            map.remove(fruits[left]);
        }
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);                      // 3. update
}
return maxLen;
```

## Dry run: `[1, 2, 3, 2, 2]`

```
right=0 (1)  map={1:1}          size 1   left=0  length 1   maxLen=1
right=1 (2)  map={1:1,2:1}      size 2   left=0  length 2   maxLen=2
right=2 (3)  map={1:1,2:1,3:1}  size 3 > 2 → shrink:
               remove fruits[0]=1 → map={2:1,3:1}, left=1
                                size 2   left=1  length 2   maxLen=2
right=3 (2)  map={2:2,3:1}      size 2   left=1  length 3   maxLen=3
right=4 (2)  map={2:3,3:1}      size 2   left=1  length 4   maxLen=4
```

Answer: `4`.

## Common mistakes

- **Shrinking before adding.** Then the window can hold 3 types when `maxLen` is updated. On `[1, 2, 3]` it returns `3` instead of `2`. Always do add → shrink → update.
- **Not removing the key at count 0.** `size()` then counts types that are no longer in the window.

**Complexity:** Time O(n), space O(1) (at most 3 keys in the map).

**Edge cases:** one tree, only one type, exactly two types (the whole array), empty array.

**Note:** this is "Longest Substring with At Most K Distinct Characters" with `K = 2`.

**How to explain:** "I keep a window with at most two fruit types. When a third type enters, I shrink from the left until only two remain, tracking the longest window."
