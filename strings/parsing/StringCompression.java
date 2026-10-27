/** String Compression (LC 443): compress a char array in place, return the new length. */
public class StringCompression {

    // Read pointer groups equal chars; write pointer writes char + count digits. O(n) time, O(1) space
    static int compress(char[] chars) {
        int write = 0, read = 0;
        while (read < chars.length) {
            char c = chars[read];
            int start = read;
            while (read < chars.length && chars[read] == c) read++;

            chars[write++] = c;
            int count = read - start;
            if (count > 1) {
                for (char d : String.valueOf(count).toCharArray()) chars[write++] = d;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        char[] a = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int n = compress(a);
        System.out.println(n + " " + new String(a, 0, n));   // 6 a2b2c3

        char[] b = {'a'};
        n = compress(b);
        System.out.println(n + " " + new String(b, 0, n));   // 1 a

        char[] c = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        n = compress(c);
        System.out.println(n + " " + new String(c, 0, n));   // 4 ab12
    }
}
