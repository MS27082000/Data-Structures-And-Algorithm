# Asteroid Collision (LC 735)

**Problem:** Asteroids in a row; sign = direction (positive → right, negative → left), absolute value = size, all same speed. Two asteroids that meet: the **smaller explodes**; if **equal**, both explode. Return the survivors.

**Brute force:** Repeatedly scan for a right-moving asteroid followed by a left-moving one and resolve → O(n²).
**Optimal:** A **stack** of survivors. For each incoming asteroid `a`:
- A collision happens only if `a < 0` and the stack top `> 0`.
- While colliding: top smaller → pop and continue; equal → pop and `a` dies; top larger → `a` dies.
- If `a` survived, push it.
Return the stack in order → O(n).

**Intuition:** Asteroids moving left only ever hit the nearest right-moving survivor in front of them, which is the stack top. It is monotonic-stack-like behaviour with a "collision" rule.

**Complexity:** Time O(n) (each asteroid is pushed/popped once), Space O(n).

**Edge cases:** All same direction (no collisions), left-movers first then right-movers (never meet), equal sizes (`[8,-8]` → `[]`), one big left-mover wiping out many right-movers (`[3,2,1,-4]` → `[-4]`).

**Interview traps**
- **Only `+` then `−` collides.** A `−` followed by `+` moves apart.
- After popping a smaller top, **keep looping** (the same incoming asteroid may hit more).
- Use a `boolean alive` flag for the incoming asteroid.
- Convert the stack back to an array in the right order (the stack iterates top-first).

**How to explain:** "I keep a stack of surviving asteroids. A left-moving newcomer fights the right-moving ones on top of the stack: it destroys smaller ones, dies against bigger ones, and both die on a tie."
