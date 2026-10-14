import java.util.ArrayDeque;
import java.util.Deque;

/** Online Stock Span (LC 901): span of today's price = number of consecutive days (including today) with price <= today's */
public class StockSpanner {

    // Stack of {price, span}. Pop every previous price <= today's and absorb its span. Amortised O(1) per call, O(n) space
    private final Deque<int[]> stack = new ArrayDeque<>();

    int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) span += stack.pop()[1];
        stack.push(new int[]{price, span});
        return span;
    }

    // Offline version for a whole array: span[i] = i - (index of previous GREATER element). O(n)
    static int[] spans(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();                 // indices with decreasing prices
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) stack.pop();
            res[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        StringBuilder sb = new StringBuilder();
        for (int p : prices) sb.append(s.next(p)).append(' ');
        System.out.println(sb.toString().trim());                                // 1 1 1 2 1 4 6
        System.out.println(java.util.Arrays.toString(spans(prices)));            // [1, 1, 1, 2, 1, 4, 6]
        System.out.println(java.util.Arrays.toString(spans(new int[]{10, 20, 30})));   // [1, 2, 3]
        System.out.println(java.util.Arrays.toString(spans(new int[]{30, 20, 10})));   // [1, 1, 1]
        System.out.println(java.util.Arrays.toString(spans(new int[]{5, 5, 5})));      // [1, 2, 3]
    }
}
