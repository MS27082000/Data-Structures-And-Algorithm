import java.util.HashMap;
import java.util.Map;

/**
 * Count Subarrays with XOR K.
 *
 * Same idea as "Count Subarrays with Sum K", with XOR in place of sum.
 * Formula: xor of subarray (j+1 .. i) = prefix[i] ^ prefix[j].
 * We want this to be k, so prefix[j] must be prefix[i] ^ k. (If a ^ b = k, then b = a ^ k.)
 *
 * The map stores: prefix XOR -> HOW MANY TIMES it appeared.
 *
 * Time O(n), space O(n).
 */
public class CountSubarraysWithXorK {

    static int subarraysWithXorK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);                                // the empty prefix (xor 0) has appeared once
        int prefixXor = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixXor = prefixXor ^ arr[i];

            // how many earlier prefixes equal (prefixXor ^ k)? Each one is a valid subarray ending at i.
            // Look up BEFORE inserting the current prefix.
            if (map.containsKey(prefixXor ^ k)) {
                count += map.get(prefixXor ^ k);
            }

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithXorK(new int[]{4, 2, 2, 6, 4}, 6));   // 4
        System.out.println(subarraysWithXorK(new int[]{5, 6, 7, 8, 9}, 5));   // 2
        System.out.println(subarraysWithXorK(new int[]{1, 2, 3}, 0));         // 1  ([1,2,3])
        System.out.println(subarraysWithXorK(new int[]{0, 0}, 0));            // 3
    }
}
