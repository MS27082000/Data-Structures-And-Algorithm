import java.util.HashMap;
import java.util.Map;

/** Count Subarrays with XOR K */
public class CountSubarraysWithXorK {

    // Prefix XOR + HashMap of counts. xor(a[j+1..i]) = prefix[i] ^ prefix[j], so we need prefix[j] = prefix[i] ^ k.
    // O(n) time, O(n) space
    static int subarraysWithXorK(int[] a, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, total = 0;
        for (int x : a) {
            prefix ^= x;
            total += count.getOrDefault(prefix ^ k, 0);
            count.merge(prefix, 1, Integer::sum);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithXorK(new int[]{4, 2, 2, 6, 4}, 6));   // 4
        System.out.println(subarraysWithXorK(new int[]{5, 6, 7, 8, 9}, 5));   // 2
        System.out.println(subarraysWithXorK(new int[]{1, 2, 3}, 0));         // 1  ([1,2,3])
        System.out.println(subarraysWithXorK(new int[]{0, 0}, 0));            // 3
    }
}
