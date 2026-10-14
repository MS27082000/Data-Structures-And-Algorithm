import java.util.Arrays;

/** Assign Cookies (LC 455): child i is content if given a cookie of size >= g[i]; each child gets at most one cookie.
 *  Maximise the number of content children. */
public class AssignCookies {

    // Sort both. Greedy: give each child the SMALLEST cookie that satisfies them. O(n log n + m log m), O(1) extra
    static int findContentChildren(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);
        int child = 0, cookie = 0;
        while (child < greed.length && cookie < cookies.length) {
            if (cookies[cookie] >= greed[child]) child++;     // this cookie satisfies the child
            cookie++;                                         // the cookie is used or too small: move on either way
        }
        return child;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));          // 1
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));          // 2
        System.out.println(findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8})); // 2
        System.out.println(findContentChildren(new int[]{}, new int[]{1}));                    // 0
        System.out.println(findContentChildren(new int[]{5}, new int[]{}));                    // 0
    }
}
