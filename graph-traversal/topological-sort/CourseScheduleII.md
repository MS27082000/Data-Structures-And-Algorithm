# Course Schedule II (LC 210)

**Problem:** Same input as [Course Schedule I](CourseScheduleI.md), but return **an order** in which to take the courses, or an **empty array** if that's impossible.

**Approach:** Kahn's algorithm and **keep the order of removal**. If the order contains all `numCourses` courses, return it; otherwise there's a cycle → return `[]` → **O(V + E)**.

**Intuition:** A topological order is exactly a valid course order. Kahn's algorithm produces one.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** No prerequisites (any order, e.g. `0..n−1`), a cycle (`[]`), multiple valid answers (LeetCode accepts any), a single course.

**Interview traps**
- The answer is **not unique**. Test validity rather than an exact array.
- Return an **empty array** (not `null`) for the impossible case.
- Edge direction: prerequisite → course.
- Make sure the output array is filled in the **order the courses are dequeued**.

**How to explain:** "I run Kahn's algorithm and record each course as it's taken. If every course ends up in the list, that's a valid schedule; if not, a cycle blocked some courses, so no schedule exists."
