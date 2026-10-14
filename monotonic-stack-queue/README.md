# Monotonic Stack / Queue

Source: Striver's A2Z DSA Sheet, Stack / Queues → Monotonic Stack (7) and FAQs (8 of them). Active recall: open the link, solve from scratch, then check the notes.

## When to use
- "Next / previous **greater** or **smaller** element"
- "Largest rectangle", "span", "sum over all subarrays of min/max"
- "Maximum of every sliding window" (monotonic **deque**)

## The idea
Keep a stack whose elements are **sorted** (increasing or decreasing). When a new element breaks the order, **pop** elements until the order is restored. Each popped element has just found its answer (its next greater/smaller). Every element is pushed and popped **once**, so the total is **O(n)**.

## Template (next greater element, right → left)
```java
Deque<Integer> stack = new ArrayDeque<>();
for (int i = n - 1; i >= 0; i--) {
    while (!stack.isEmpty() && stack.peek() <= a[i]) stack.pop();   // useless candidates
    res[i] = stack.isEmpty() ? -1 : stack.peek();
    stack.push(a[i]);
}
```

## Which variant
| Need | Scan | Pop while |
|---|---|---|
| Next greater | right → left | `top <= a[i]` |
| Next smaller | right → left | `top >= a[i]` |
| Previous greater / Stock span | left → right | `top <= a[i]` |
| Previous smaller | left → right | `top >= a[i]` |
| Circular array | scan 2n | use `i % n` |
| Window maximum | deque of indices | pop back `<=`, pop front if out of window |

## Monotonic Stack section
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Next Greater Element](NextGreaterElement.md) | [LC 496](https://leetcode.com/problems/next-greater-element-i/) | Decreasing stack + map | O(n+m) |
| 2 | [Next Greater Element II](NextGreaterElementII.md) | [LC 503](https://leetcode.com/problems/next-greater-element-ii/) | Scan twice, `i % n` | O(n) |
| 3 | [Asteroid Collision](AsteroidCollision.md) | [LC 735](https://leetcode.com/problems/asteroid-collision/) | Stack of survivors | O(n) |
| 4 | [Sum of Subarray Minimums](SumOfSubarrayMinimums.md) | [LC 907](https://leetcode.com/problems/sum-of-subarray-minimums/) | Contribution: left × right | O(n) |
| 5 | [Sum of Subarray Ranges](SumOfSubarrayRanges.md) | [LC 2104](https://leetcode.com/problems/sum-of-subarray-ranges/) | Sum of maxes − sum of mins | O(n) |
| 6 | [Remove K Digits](RemoveKDigits.md) | [LC 402](https://leetcode.com/problems/remove-k-digits/) | Pop larger digits | O(n) |
| 7 | [Next Smaller Element](NextSmallerElement.md) | [GfG](https://www.geeksforgeeks.org/problems/next-smaller-element/1) | Mirror of next greater | O(n) |

## FAQs
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 8 | [Sliding Window Maximum](SlidingWindowMaximum.md) | [LC 239](https://leetcode.com/problems/sliding-window-maximum/) | Monotonic deque of indices | O(n) |
| 9 | [Trapping Rainwater](TrappingRainWaterStack.md) (stack version; [two-pointer version](../two-pointers/TrappingRainWater.md)) | [LC 42](https://leetcode.com/problems/trapping-rain-water/) | Layer-by-layer on pop | O(n) |
| 10 | [Largest Rectangle in a Histogram](LargestRectangleHistogram.md) | [LC 84](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Increasing stack + sentinel | O(n) |
| 11 | [Maximal Rectangles](MaximalRectangle.md) | [LC 85](https://leetcode.com/problems/maximal-rectangle/) | Histogram per row | O(m·n) |
| 12 | [Stock Span Problem](StockSpanner.md) | [LC 901](https://leetcode.com/problems/online-stock-span/) | Stack of (price, span) | O(1) amortised |
| 13 | [Number of Greater Elements to the Right](GreaterElementsToRight.md) | [GfG](https://www.geeksforgeeks.org/problems/count-the-elements/1) | Counting (BIT), not a stack | O(n log n) |

## Other FAQs from the same sheet section
[Min Stack](../stack-and-queue/MinStack.md) and [Celebrity Problem](../stack-and-queue/CelebrityProblem.md) are in [stack-and-queue](../stack-and-queue/README.md). [LRU Cache and LFU Cache](../design/README.md) are in `design`.

## Run any program
```
javac -d out *.java
java -cp out SlidingWindowMaximum
```
