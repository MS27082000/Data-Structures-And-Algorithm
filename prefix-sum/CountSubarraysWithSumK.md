# Count Subarrays with Sum K (LC 560)

**Problem:** Count the contiguous subarrays whose sum is exactly `k`. Negatives and zeros are allowed.

`[1, 2, 3]`, `k = 3` → `2` (`[1, 2]` and `[3]`)

## Approaches

1. **Brute force:** check all subarrays. O(n²).
2. **Sliding window:** does **not** work, because negative numbers break the "shrink to reduce the sum" rule.
3. **Prefix sum + HashMap of counts (main):** O(n) time, O(n) space.

---

## 1. The one formula to remember

`prefix[i]` = sum of elements from the start up to index `i`.

```
sum of subarray (j+1 .. i) = prefix[i] − prefix[j]
```

We want that subarray sum to be `k`:

```
prefix[i] − prefix[j] = k
        prefix[j] = prefix[i] − k
```

## 2. Why we search for `prefix[i] − k`

At position `i` we already know `prefix[i]` (the running sum). The only unknown is `prefix[j]`, the earlier prefix where the subarray starts. The formula says it must equal `prefix[i] − k`. So we **search for it** among the earlier prefixes.

```
|------------ prefix[i] ------------|
|--- prefix[j] ---|------ k --------|
  (what we search)   (the subarray)
```

`prefix[i] − k` is **not** the `k` part. It is the part **before** the `k` part.

## 3. Why not search for `k` itself?

A subarray sum is a **difference** of two prefixes. Searching "prefix equals `k`" finds only subarrays that **start at index 0**.

`[1, 2, 3]`, `k = 3`:
- "prefix equals 3" finds `[1, 2]` only (prefix 3 after two elements).
- It misses `[3]`. For that, at the last element: `prefix = 6`, `need = 6 − 3 = 3`, and prefix `3` exists earlier. The stretch after it is `[3]`, which sums to `3`. ✓

## 4. Why we add a **count** (the map stores counts)

The same prefix value can occur **many times**. Each earlier occurrence is a **different start**, so it gives a **different subarray** ending at `i`.

`[0, 0, 3]`, `k = 3`:

```
prefix before everything = 0
prefix after 1st zero    = 0
prefix after 2nd zero    = 0
prefix after the 3       = 3
```

At the `3`: `need = 3 − 3 = 0`. The prefix `0` appeared **3 times**:

| Earlier prefix 0 at | Subarray ending now | Sum |
|---|---|---|
| before everything | `[0, 0, 3]` | 3 ✓ |
| after the 1st zero | `[0, 3]` | 3 ✓ |
| after the 2nd zero | `[3]` | 3 ✓ |

So `count += 3`. That is why we store how many times each prefix appeared, and add `map.get(need)`.

## 5. The three details people get wrong

**(a) Seed the map with `{0: 1}`.**
If the subarray starts at index 0, the earlier prefix is "nothing", which is `0`. Without the seed, subarrays that start at the beginning are missed.

**(b) Look up `prefix − k` BEFORE inserting `prefix`.**
If you insert first, then with `k = 0` the lookup finds the current prefix itself and counts an empty subarray.
Example `[5]`, `k = 0`: prefix is `5`, need is `5`. If `5` is already inserted, you count `1`, but the right answer is `0`.

**(c) Use `long` for prefix sums** if values can be big (to avoid overflow).

## 6. Code

```java
Map<Long, Integer> count = new HashMap<>();
count.put(0L, 1);                                        // (a) seed
long prefix = 0;
int total = 0;

for (int x : nums) {
    prefix += x;
    total += count.getOrDefault(prefix - k, 0);          // (b) look up first
    count.merge(prefix, 1, Integer::sum);                //     then insert
}
return total;
```

## 7. Dry run: `[1, 2, 3]`, `k = 3`

```
map = {0:1}

x=1  prefix=1  need = 1−3 = −2  not in map   total=0   map={0:1, 1:1}
x=2  prefix=3  need = 3−3 = 0   count 1      total=1   map={0:1, 1:1, 3:1}     ([1,2])
x=3  prefix=6  need = 6−3 = 3   count 1      total=2   map={0:1, 1:1, 3:1, 6:1} ([3])
```

Answer: `2`.

## 8. Longest vs count: what the map stores

| Question | Map value | On a match |
|---|---|---|
| Longest subarray with sum `k` | **first index** of the prefix | `maxLen = max(maxLen, i − index)` |
| Count subarrays with sum `k` | **count** of the prefix | `total += count` |

The prefix-sum idea is identical. Only what you store, and what you do on a match, changes.

**Complexity:** time O(n), space O(n).

**Edge cases:** all zeros with `k = 0` (`[0,0,0]` → 6), negatives, no match, `k` equals the total sum of the array.

**Interview traps**
- Sliding window fails with negative numbers.
- Seed `{0: 1}`.
- Lookup before insert.
- Count version: map stores **counts**. Longest version: map stores **first index**.

**How to explain:** "A subarray sum is the difference of two prefix sums. At each position I know the current prefix, so I look for how many earlier prefixes equal `prefix − k`. Each one is a different start, so I add that count."
