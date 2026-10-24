# Intersection of Two Sorted Arrays (LC 350 style)

**Problem:** Return the common elements of two sorted arrays. Duplicates appear as many times as they appear in **both** (min of the counts).

**Brute force:** For each element of `a`, search `b` (with a visited marker) → O(n·m).
**Better:** HashMap of counts → O(n+m) time, O(min(n,m)) space. Good when the arrays are **unsorted**.
**Optimal for sorted input:** Two pointers → O(n+m) time, O(1) extra space.

**Steps:** `a[i] < b[j]` → `i++`; `a[i] > b[j]` → `j++`; equal → add, `i++`, `j++`.

**Intuition:** Sortedness means the smaller front element can never match anything later in the other array, so it is safe to skip.

**Complexity:** Time O(n+m), Space O(1) extra.

## Follow-up: one array is much smaller than the other

Say `small` has `n` elements and `big` has `m` elements, with `n` much smaller than `m` (for example `n = 10`, `m = 1,000,000`). Two pointers takes O(n + m), so it walks through almost all of `big` even though there are only a few things to look for. These two approaches do better.

### Approach A: hash map of the small array

**Idea:** store the small array in a map (`value → count`), then scan the big array once.

**Steps:**
- Build the map from `small`.
- For each `x` in `big`: if `map[x] > 0`, add `x` to the result and decrement `map[x]`.

```java
public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length <= nums2.length) return helper(nums1, nums2);
    else return helper(nums2, nums1);
}

private int[] helper(int[] small, int[] big) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : small) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    List<Integer> result = new ArrayList<>();
    for (int x : big) {
        if (map.getOrDefault(x, 0) > 0) {
            result.add(x);
            map.put(x, map.get(x) - 1);
        }
    }

    int[] answer = new int[result.size()];
    for (int k = 0; k < result.size(); k++) answer[k] = result.get(k);
    return answer;
}
```

**Why it is efficient:**
- Time O(n + m), because each lookup is O(1).
- Space O(n): only the **small** array is stored, so memory does not grow with the big array. This also helps when the big array is on disk and can only be read as a stream.
- It does **not** need the arrays to be sorted, so there is no sorting cost.

**Use it when:** the arrays are unsorted, one is much smaller than the other, or the big one is too large to hold in memory.

### Approach B: binary search for each small element

**Idea:** both arrays must be **sorted**. For each element of `small`, binary search for it in `big`.

**Steps:**
- Keep `start = 0`, the position in `big` where the search begins.
- For each `x` in `small`: find the **first** position of `x` in `big`, from `start`.
- If found at `idx`: add `x`, then set `start = idx + 1`, so that big element is not used twice.

The binary search must return the **leftmost** copy of `x`. When `big[mid] == x`, save `mid` and keep searching to the left (`right = mid - 1`). If it stopped on any copy, `start` could jump past other copies and lose matches, for example `small = [2,2,2]` with `big = [2,2,2]`.

```java
public int[] intersect(int[] small, int[] big) {
    List<Integer> result = new ArrayList<>();
    int start = 0;

    for (int x : small) {
        int idx = findFirst(big, x, start);
        if (idx != -1) {              // x exists in big
            result.add(x);
            start = idx + 1;          // that copy is used, so the next search starts after it
        }
    }

    int[] answer = new int[result.size()];
    for (int k = 0; k < result.size(); k++) answer[k] = result.get(k);
    return answer;
}

private int findFirst(int[] big, int x, int start) {
    int left = start, right = big.length - 1;
    int answer = -1;                          // -1 means not found

    while (left <= right) {
        int mid = (left + right) / 2;
        if (big[mid] == x) {
            answer = mid;                     // found a copy
            right = mid - 1;                  // but keep looking left for the first copy
        } else if (big[mid] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return answer;
}
```

**Dry run:** `small = [2, 2]`, `big = [1, 2, 2, 2, 5]`
- `x = 2`, `start = 0`: first position of 2 is index 1. Add 2, `start = 2`.
- `x = 2`, `start = 2`: first position of 2 from index 2 is index 2. Add 2, `start = 3`.
- Result `[2, 2]`.

**Why it is efficient:**
- Time O(n log m). For `n = 10` and `m = 1,000,000`, that is about `10 × 20 = 200` steps, against a million for two pointers.
- Space O(1) besides the output.
- It never reads most of `big`.

**Use it when:** both arrays are **already sorted** and one is much smaller. If the sizes are similar, `n log m` is worse than `n + m`, so use two pointers.

**Note on duplicates:** a plain binary search (stop at any match) is fine only when the question wants **unique** elements (LC 349). With duplicates allowed (LC 350), use the leftmost-copy version above.

### Which approach to choose

| Situation | Best choice | Time | Space |
|---|---|---|---|
| Both sorted, similar size | two pointers | O(n + m) | O(1) |
| Unsorted, similar size | sort both + two pointers | O(n log n + m log m) | O(1) |
| Unsorted, one much smaller | hash map of the small one | O(n + m) | O(n) |
| Both sorted, one much smaller | binary search each small element | O(n log m) | O(1) |
| Big array on disk, small one fits in memory | hash map of the small one, stream the big one | O(n + m) | O(n) |

**Edge cases:** No common elements, one empty array, heavy duplicates (`[1,1,1]` and `[1,1]` → `[1,1]`).

**Interview traps**
- Clarify whether the result should be **distinct** or keep multiplicity. For distinct, skip repeats when adding.
- Follow-ups (LC 350): if one array is much smaller, use a hashmap on the smaller; if arrays are on disk, use sorted merge or chunking.
- Move **both** pointers on a match.

**How to explain:** "Two pointers walk both sorted arrays. I advance whichever is smaller, and when they match I record it and advance both."
