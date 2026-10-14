import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/** Asteroid Collision (LC 735): positive = moving right, negative = moving left, same speed. Smaller explodes; equal both explode */
public class AsteroidCollision {

    // A collision happens only when the stack top moves RIGHT (> 0) and the incoming asteroid moves LEFT (< 0).
    // O(n) time, O(n) space
    static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean alive = true;
            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -a) {
                    stack.pop();                         // top explodes, keep checking the next one
                } else if (top == -a) {
                    stack.pop();                         // both explode
                    alive = false;
                } else {
                    alive = false;                       // the incoming one explodes
                }
            }
            if (alive) stack.push(a);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();   // stack top is the last asteroid
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));        // [5, 10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));            // []
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));        // [10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2})));     // [-2, -1, 1, 2] (never meet)
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, -2, -2})));    // [-2, -2, -2]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3, 2, 1, -4})));      // [-4]
    }
}
