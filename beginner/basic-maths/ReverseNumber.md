# Reverse a Number (LC 7)

**Problem:** Reverse the digits of an integer. LeetCode 7 returns 0 if the result leaves the 32-bit range.

**Intuition:** rev = rev * 10 + lastDigit, then drop the last digit of n.

**Approach / complexity:** O(log10 n) time, O(1) space. For int overflow, check against MAX/10 and MIN/10 BEFORE multiplying.

**Edge cases:** Trailing zeros vanish (1200 -> 21). Negative numbers. Overflow (1534236469 -> 0). 0.

**Interview traps**
- Overflow check must come before rev * 10 + d.
- The sign is carried naturally by % and / in Java.
- Do not convert to a string if the interviewer asks for no extra space.

**How to explain:** "I build the reversed number digit by digit and guard against overflow before each multiply."
