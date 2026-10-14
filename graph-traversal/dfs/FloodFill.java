import java.util.Arrays;

/** Flood Fill (LC 733): recolour the connected region (4-directional) that contains (sr, sc) */
public class FloodFill {

    // DFS from the start cell over cells that have the ORIGINAL colour. O(R*C) time, O(R*C) stack
    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;                  // TRAP: same colour => nothing to do (otherwise infinite recursion)
        fill(image, sr, sc, original, color);
        return image;
    }

    private static void fill(int[][] img, int r, int c, int original, int color) {
        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length || img[r][c] != original) return;
        img[r][c] = color;                                    // recolouring doubles as the "visited" marker
        fill(img, r + 1, c, original, color);
        fill(img, r - 1, c, original, color);
        fill(img, r, c + 1, original, color);
        fill(img, r, c - 1, original, color);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        // [[2, 2, 2], [2, 2, 0], [2, 0, 1]]   (the bottom-right 1 is not connected)
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0)));   // unchanged (same colour)
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 1, 0, 3)));   // [[3, 3, 3], [3, 3, 3]]
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1}}, 0, 0, 9)));                      // [[9]]
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 0}, {0, 1}}, 0, 0, 5)));           // [[5, 0], [0, 1]]
    }
}
