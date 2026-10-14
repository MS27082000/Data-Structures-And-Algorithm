/** LC 11 - Container With Most Water */
public class ContainerWithMostWater {

    // O(n) time, O(1) space. Always move the pointer at the SHORTER line.
    static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1}));                      // 1
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));             // 16
    }
}
