# Introduction to Bits and Tricks (Theory)

## Operators (Java `int` = 32 bits, two's complement)
| Op | Meaning | Example |
|---|---|---|
| `&` | AND (1 only if both are 1) | `5 & 3 = 1` |
| `\|` | OR | `5 \| 3 = 7` |
| `^` | XOR (1 if the bits differ) | `5 ^ 3 = 6` |
| `~` | NOT (flip all bits) | `~5 = -6` (`~n = -n - 1`) |
| `<<` | Shift left = multiply by 2ᵏ | `5 << 2 = 20` |
| `>>` | Arithmetic shift right = divide by 2ᵏ (keeps the sign) | `-8 >> 1 = -4` |
| `>>>` | Logical shift right (zeros fill in) | `-8 >>> 28 = 15` |

## Must-know one-liners
| Goal | Expression |
|---|---|
| Get bit i | `(n >> i) & 1` |
| Set bit i | `n \| (1 << i)` |
| Clear bit i | `n & ~(1 << i)` |
| Toggle bit i | `n ^ (1 << i)` |
| Is odd | `(n & 1) == 1` |
| Power of two | `n > 0 && (n & (n-1)) == 0` |
| **Clear the lowest set bit** | `n & (n - 1)` |
| **Isolate the lowest set bit** | `n & -n` |
| Multiply / divide by 2ᵏ | `n << k` / `n >> k` |
| Swap | `a ^= b; b ^= a; a ^= b` |

## XOR properties (the heart of many problems)
`x ^ x = 0`, `x ^ 0 = x`, commutative, associative. So XOR-ing a list cancels pairs and leaves the unpaired value.

## Two's complement (why `-n = ~n + 1`)
A negative number is its positive twin inverted plus one. That's why `n & -n` isolates the lowest set bit and why `-1` is all ones.

## Common traps
- **`>>` vs `>>>`** on negatives. `>>` keeps the sign bit; `>>>` doesn't. Use `>>>` when looping over bits of a possibly negative number.
- **`1 << 31`** is `Integer.MIN_VALUE`. Beyond 31 bits use `1L << k`.
- **Operator precedence:** `==` binds tighter than `&`. Write `(n & 1) == 1`, **with parentheses**.
- `Integer.MAX_VALUE + 1` overflows to `MIN_VALUE` silently.
- Java shifts use only the low 5 bits of the shift count (`1 << 32 == 1`).

## Useful built-ins
`Integer.bitCount`, `Integer.toBinaryString`, `Integer.highestOneBit`, `Integer.numberOfTrailingZeros`, `Integer.reverse`.

**How to explain:** "Bits give O(1) operations on flags and sets. The key identities are `n & (n-1)` to drop the lowest set bit, `n & -n` to isolate it, and XOR cancelling equal values."
