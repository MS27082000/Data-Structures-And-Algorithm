# Majority Element I (LC 169)

**Problem:** Find the element that appears **more than `n/2` times**. It always exists.
`[2,2,1,1,1,2,2]` → `2`

## Approaches
1. **Brute force:** count every element with nested loops. O(n²).
2. **Sort:** the majority element is always at index `n/2` after sorting. O(n log n).
3. **HashMap:** count occurrences. O(n) time, O(n) space.
4. **Boyer-Moore Voting (optimal):** O(n) time, O(1) space.

## Boyer-Moore in plain words
It's an election with one candidate and a vote count.

- Look at each number `x`.
- If `count == 0`, nobody is leading. Make `x` the candidate.
- If `x` equals the candidate, `count++`. If not, `count--`.
- At the end, the candidate is the answer.

### Walkthrough: `[2, 2, 1, 1, 1, 2, 2]`

| x | count before | candidate | x == candidate? | count after |
|---|---|---|---|---|
| 2 | 0 → pick 2 | 2 | yes | 1 |
| 2 | 1 | 2 | yes | 2 |
| 1 | 2 | 2 | no | 1 |
| 1 | 1 | 2 | no | 0 |
| 1 | 0 → pick 1 | 1 | yes | 1 |
| 2 | 1 | 1 | no | 0 |
| 2 | 0 → pick 2 | 2 | yes | 1 |

The final candidate is `2`. The candidate changed along the way, but the real majority wins in the end.

### Why it works
Each time `x` differs from the candidate, the two numbers cancel each other out (a pair is removed). The majority element appears more than half the time, so there aren't enough other numbers to cancel all of it. Something from the majority is always left standing.

## Code
```java
int candidate = 0, count = 0;
for (int x : nums) {
    if (count == 0) candidate = x;
    if (x == candidate) count++;
    else count--;
}
return candidate;
```

**Complexity:** Time O(n), Space O(1).

**Edge cases:** single element, all elements equal, negative numbers.

**Interview traps**
- If a majority is **not guaranteed**, make a second pass to count the candidate and check it exceeds `n/2`.
- Be ready to explain the cancellation argument.
- Sorting and taking `nums[n/2]` works, but it is O(n log n).

**How to explain:** "Pair off different elements so they cancel. The majority has more than half the votes, so it can't be cancelled completely, and it is what remains."
