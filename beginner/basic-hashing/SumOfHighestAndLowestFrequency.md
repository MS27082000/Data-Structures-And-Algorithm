# Sum of Highest and Lowest Frequency

**Problem:** Add the maximum and the minimum frequency in the array.

**Intuition:** Count frequencies, then take max and min of the counts.

**Approach / complexity:** O(n) time, O(n) space.

**Edge cases:** One distinct value counts as both max and min. Empty array -> 0.

**Interview traps**
- Initialise min to a large value.
- One distinct value gives 2 * its count.

**How to explain:** "I build the frequency map and add its largest and smallest value."
