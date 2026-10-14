import java.util.ArrayList;
import java.util.List;

/** Find Pairs with Given Sum in a SORTED Doubly Linked List of distinct positive numbers */
public class PairsWithGivenSumDLL {

    static class Node {
        int val;
        Node prev, next;
        Node(int v) { val = v; }
    }

    static Node build(int... a) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : a) {
            Node n = new Node(x);
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        if (dummy.next != null) dummy.next.prev = null;
        return dummy.next;
    }

    // Two pointers: left at the head, right at the tail (reachable thanks to the prev pointers).
    // sum too small => left = left.next, too big => right = right.prev. O(n) time, O(1) space
    static List<List<Integer>> findPairs(Node head, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (head == null) return res;
        Node left = head, right = head;
        while (right.next != null) right = right.next;
        while (left != right && right.next != left) {            // stop when the pointers meet or cross
            int sum = left.val + right.val;
            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(left.val);
                pair.add(right.val);
                res.add(pair);
                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(build(1, 2, 4, 5, 6, 8, 9), 7));    // [[1, 6], [2, 5]]
        System.out.println(findPairs(build(1, 5, 6), 6));                // [[1, 5]]
        System.out.println(findPairs(build(1, 2, 3), 10));               // []
        System.out.println(findPairs(build(5), 10));                     // [] (one element can't pair with itself)
        System.out.println(findPairs(null, 3));                          // []
        System.out.println(findPairs(build(1, 2, 3, 4), 5));             // [[1, 4], [2, 3]]
    }
}
