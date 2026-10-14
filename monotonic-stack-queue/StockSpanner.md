# Stock Span Problem (Online Stock Span, LC 901)

**Problem:** For each day's price, the **span** is the number of consecutive previous days (including today) with price **less than or equal to** today's. Return the span for each day (online: prices arrive one by one).

**Brute force:** For each day walk back while prices are `<=` → O(n²).
**Optimal:** A **monotonic stack** of `(price, span)`. For a new price, pop every entry with `price <= today`, adding each popped **span** to today's span. Push `(today, span)` → amortised O(1) per call.

**Offline equivalent:** `span[i] = i − (index of the previous GREATER element)` (or `i + 1` if none). That's "previous greater element" from the monotonic stack family.

**Intuition:** A popped day's span already covers all days before it that were no bigger, so today absorbs it instead of walking back again.

**Complexity:** Time O(n) total (each entry is pushed/popped once), Space O(n).

**Edge cases:** Increasing prices (span grows `1,2,3…`), decreasing (all 1), equal prices (span counts equals: `<=`), single day.

**Interview traps**
- Use **`<=`** (equal prices are included in the span).
- Store the **span** in the stack so a single pop absorbs many days.
- LeetCode's version is a **class with `next(price)`**, which is why you can't scan the full array.
- Closely related: Daily Temperatures (next greater), Next Greater Element.

**How to explain:** "I keep a stack of price ranges. A new price swallows every previous range whose price isn't higher, adding up their spans, so each day's span is computed without walking back."
