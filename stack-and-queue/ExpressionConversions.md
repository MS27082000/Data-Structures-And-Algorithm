# Prefix, Infix and Postfix Conversions

Covers 6 sheet items in one file (`ExpressionConversions.java`): Infix→Postfix, Infix→Prefix, Prefix→Infix, Prefix→Postfix, Postfix→Infix, Postfix→Prefix.

## The three notations (for `(a + b) * c`)
| Notation | Operator position | Example | Needs parentheses? |
|---|---|---|---|
| **Infix** | between operands | `(a+b)*c` | Yes, plus precedence rules |
| **Prefix** (Polish) | before operands | `*+abc` | No |
| **Postfix** (Reverse Polish) | after operands | `ab+c*` | No |

Prefix and postfix are unambiguous, so they are easy for machines to evaluate with a stack.

## Operator precedence and associativity
`^` (highest, **right**-associative) > `* /` > `+ -` (all others **left**-associative). So `a-b-c = (a-b)-c` but `a^b^c = a^(b^c)`.

## Algorithms
| Conversion | Method |
|---|---|
| **Infix → Postfix** | Shunting-yard: operands go straight to the output; an operator pops operators of **higher precedence (or equal, if left-assoc)** first; `(` pushes; `)` pops until `(`; at the end pop everything. |
| **Infix → Prefix** | **Reverse** the infix (swap `(` and `)`), convert to postfix with the associativity rule **flipped**, then **reverse** the result. |
| **Postfix → Infix** | Scan **left→right**. On an operator pop `b`, then `a`, push `"(a op b)"`. |
| **Prefix → Infix** | Scan **right→left**. On an operator pop `a`, then `b`, push `"(a op b)"`. |
| **Postfix → Prefix** | Scan left→right. Pop `b`, then `a`, push `op a b`. |
| **Prefix → Postfix** | Scan right→left. Pop `a`, then `b`, push `a b op`. |

**Complexity:** All are O(n) time and O(n) space (stack), except the string-building conversions, which are O(n²) in the worst case because of repeated concatenation (use `StringBuilder` for long inputs).

## Verified examples
| Infix | Postfix | Prefix |
|---|---|---|
| `(a+b)*c` | `ab+c*` | `*+abc` |
| `a+b*c-d` | `abc*+d-` | `-+a*bcd` |
| `a-b-c` | `ab-c-` | `--abc` |
| `a^b^c` | `abc^^` | `^a^bc` |

## Edge cases
Single operand, nested parentheses, equal-precedence chains (`a-b-c`, `a/b/c`), right-associative `^`, multi-digit or multi-letter operands (need a tokenizer).

## Interview traps
- **Associativity at equal precedence is the whole difficulty.** In postfix, pop on `>=` for left-assoc operators and on `>` for `^`. In the **reversed** pass for prefix it flips: don't pop on equal, except for `^`.
- Pop order for operands differs between postfix (`b` then `a`) and prefix (`a` then `b`).
- `(` must stay on the stack (precedence lowest) and never be popped by an operator.
- Check the result by converting back or evaluating with a number example.

**How to explain:** "For infix to postfix I use a stack of operators and output operands immediately, popping operators of higher or equal precedence first. Prefix is the same on the reversed expression. The other four conversions are single-pass stacks of sub-expression strings."
