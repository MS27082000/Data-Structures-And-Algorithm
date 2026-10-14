# Expression Add Operators (LC 282)

**Problem:** Given a digit string `num` and a `target`, insert `+`, `-`, or `*` between digits (or nothing, to join digits into a multi-digit number) so the expression evaluates to `target`. Return all expressions.

**Brute force:** Generate every expression, then evaluate each with a parser → O(4ⁿ · n).
**Optimal:** **Backtracking that evaluates on the fly.** Carry `eval` (value so far) and `last` (the last operand added/subtracted). Operators:
- `+ cur`: `eval + cur`, `last = cur`
- `- cur`: `eval - cur`, `last = -cur`
- `* cur`: `eval - last + last * cur`, `last = last * cur` (undo the last term, then apply the multiplication, since `*` binds tighter)

**Intuition:** Tracking `last` lets us fix up precedence without building an expression tree.

**Complexity:** Time O(4ⁿ · n) (each of n-1 gaps has 4 choices: +, -, *, none; building strings costs n), Space O(n) stack.

**Edge cases:** Leading zeros (`"105"` can use `10` and `5` but not `05`), `"00"` → `0+0, 0-0, 0*0`, overflow in large digit strings, no solution.

**Interview traps**
- **Skip operands with leading zeros** (break when `num[pos] == '0'` and the operand is longer than 1).
- **Use `long`** for the running value and operands (up to 10 digits).
- The first operand has no operator in front.
- Multiplication: `eval - last + last * cur`. Getting this wrong is the main bug.

**How to explain:** "I try every split of the digits into operands and every operator between them, keeping the running total and the last term so that multiplication can retroactively replace the previous addition."
