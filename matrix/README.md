# Matrix

Source: Striver's A2Z DSA Sheet, Arrays → FAQs (Medium). Active recall: solve from scratch, then check the notes.

| # | Question (notes) | LeetCode | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Spiral Matrix](SpiralMatrix.md) | [54](https://leetcode.com/problems/spiral-matrix/) | Four shrinking boundaries | O(m·n) | O(1) |
| 2 | [Rotate Matrix 90°](RotateMatrix.md) | [48](https://leetcode.com/problems/rotate-image/) | Transpose + reverse rows | O(n²) | O(1) |
| 3 | [Set Matrix Zeroes](SetMatrixZeroes.md) | [73](https://leetcode.com/problems/set-matrix-zeroes/) | First row/column as markers | O(m·n) | O(1) |
| 4 | [Pascal's Triangle I, II, III](PascalsTriangle.md) | [118](https://leetcode.com/problems/pascals-triangle/) (III), [119](https://leetcode.com/problems/pascals-triangle-ii/) (II) | nCr with the multiplicative formula | O(n²) for the full triangle | O(1) per element/row |

Pascal I, II and III share one file (`PascalsTriangle.java`), with a method for each variant.

## Run any program
```
javac -d out *.java
java -cp out SpiralMatrix
```
