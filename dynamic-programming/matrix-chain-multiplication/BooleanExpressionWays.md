# Boolean Expression Ways (Boolean Parenthesization)

**Problem:** Expression like `T|F&T^F`. Count the ways to put brackets so that it evaluates to **true**. (Assumption: the sheet item "Evaluate Boolean Expression to True" is the GfG "Boolean Parenthesization" problem.)

**Intuition:** Interval DP over operands. For each operator position k, combine the true/false counts of the left and right parts:
- `&`: true = lT*rT
- `|`: true = total - lF*rF
- `^`: true = lT*rF + lF*rT

Keep both `T` and `F` counts per range; total = (lT+lF)*(rT+rF).

**Brute force:** Generate all bracketings (Catalan).
**Optimised:** O(n^3) time, O(n^2) space (n = operands).

**Edge cases:** Single operand. Answer is huge -> modulo 1e9+7 (use `long`).

**Interview traps**
- Track both true **and** false counts, since `^` and `|` need the false ones.
- Apply the modulo carefully when subtracting.

**How to explain:** "For every operator as the last one evaluated, I combine the ways each side is true or false."
