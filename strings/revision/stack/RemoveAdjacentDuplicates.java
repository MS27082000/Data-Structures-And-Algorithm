/** Remove All Adjacent Duplicates In String (LC 1047). */
public class RemoveAdjacentDuplicates {

    // StringBuilder used as a stack. O(n) time, O(n) space
    static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = sb.length();
            if (n > 0 && sb.charAt(n - 1) == c) sb.deleteCharAt(n - 1);
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));  // ca
        System.out.println(removeDuplicates("azxxzy"));  // ay
        System.out.println(removeDuplicates("aa"));      // (empty)
    }
}
