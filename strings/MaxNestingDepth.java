/** Maximum Nesting Depth of the Parentheses (LC 1614) - the string is a valid parentheses string, other characters are ignored */
public class MaxNestingDepth {

    // Counter instead of a stack: ++ on '(', -- on ')', record the max. O(n) time, O(1) space
    static int maxDepth(String s) {
        int depth = 0, max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                max = Math.max(max, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));   // 3
        System.out.println(maxDepth("(1)+((2))+(((3)))"));     // 3
        System.out.println(maxDepth("1+(2*3)/(2-1)"));         // 1
        System.out.println(maxDepth("abc"));                   // 0
        System.out.println(maxDepth(""));                      // 0
    }
}
