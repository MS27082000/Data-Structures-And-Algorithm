import java.util.ArrayDeque;
import java.util.Deque;

/** Prefix, Infix and Postfix conversions (all six directions).
 *  Operands are single letters/digits; operators are + - * / ^ ; ^ is right-associative; parentheses are supported in infix. */
public class ExpressionConversions {

    private static int prec(char op) {
        switch (op) {
            case '^': return 3;
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default: return 0;                                   // '(' sits lowest so it is never popped by an operator
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // 1) Infix -> Postfix (shunting-yard). Equal precedence: pop the stack top for LEFT-associative operators, don't for RIGHT-associative.
    //    Normal pass: only '^' is right-associative. In the REVERSED pass (used for prefix) it flips: everything except '^' behaves as
    //    right-associative. O(n)
    private static String infixToPostfix(String infix, boolean reversedPass) {
        StringBuilder out = new StringBuilder();
        Deque<Character> ops = new ArrayDeque<>();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                out.append(c);                                   // operands go straight to the output
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') out.append(ops.pop());
                ops.pop();                                       // discard '('
            } else {                                             // operator
                while (!ops.isEmpty() && ops.peek() != '(') {
                    int top = prec(ops.peek()), cur = prec(c);
                    boolean curRightAssoc = reversedPass ? (c != '^') : (c == '^');
                    if (top > cur || (top == cur && !curRightAssoc)) out.append(ops.pop());
                    else break;
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) out.append(ops.pop());
        return out.toString();
    }

    static String infixToPostfix(String infix) {
        return infixToPostfix(infix, false);
    }

    // 2) Infix -> Prefix: reverse the infix (swapping parentheses), convert to postfix with flipped associativity, reverse again
    static String infixToPrefix(String infix) {
        StringBuilder rev = new StringBuilder();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            rev.append(c == '(' ? ')' : c == ')' ? '(' : c);
        }
        return new StringBuilder(infixToPostfix(rev.toString(), true)).reverse().toString();
    }

    // 3) Prefix -> Infix: scan RIGHT to LEFT; operator takes (first, second) from the stack
    static String prefixToInfix(String prefix) {
        Deque<String> st = new ArrayDeque<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperator(c)) {
                String a = st.pop(), b = st.pop();
                st.push("(" + a + c + b + ")");
            } else {
                st.push(String.valueOf(c));
            }
        }
        return st.pop();
    }

    // 4) Prefix -> Postfix: scan RIGHT to LEFT: a b op
    static String prefixToPostfix(String prefix) {
        Deque<String> st = new ArrayDeque<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperator(c)) {
                String a = st.pop(), b = st.pop();
                st.push(a + b + c);
            } else {
                st.push(String.valueOf(c));
            }
        }
        return st.pop();
    }

    // 5) Postfix -> Infix: scan LEFT to RIGHT; operator takes (second, first) from the stack
    static String postfixToInfix(String postfix) {
        Deque<String> st = new ArrayDeque<>();
        for (char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                String b = st.pop(), a = st.pop();
                st.push("(" + a + c + b + ")");
            } else {
                st.push(String.valueOf(c));
            }
        }
        return st.pop();
    }

    // 6) Postfix -> Prefix: scan LEFT to RIGHT: op a b
    static String postfixToPrefix(String postfix) {
        Deque<String> st = new ArrayDeque<>();
        for (char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                String b = st.pop(), a = st.pop();
                st.push(c + a + b);
            } else {
                st.push(String.valueOf(c));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("(a+b)*c"));         // ab+c*
        System.out.println(infixToPostfix("a+b*c-d"));         // abc*+d-
        System.out.println(infixToPostfix("a^b^c"));           // abc^^  (right associative)
        System.out.println(infixToPostfix("a-b-c"));           // ab-c-  (left associative)
        System.out.println(infixToPostfix("a*(b+c)/d"));       // abc+*d/

        System.out.println(infixToPrefix("(a+b)*c"));          // *+abc
        System.out.println(infixToPrefix("a+b*c-d"));          // -+a*bcd
        System.out.println(infixToPrefix("a^b^c"));            // ^a^bc
        System.out.println(infixToPrefix("a-b-c"));            // --abc
        System.out.println(infixToPrefix("a*(b+c)/d"));        // /*a+bcd
        System.out.println(infixToPrefix("a/b/c"));            // //abc

        System.out.println(prefixToInfix("*+abc"));            // ((a+b)*c)
        System.out.println(prefixToPostfix("*+abc"));          // ab+c*
        System.out.println(postfixToInfix("ab+c*"));           // ((a+b)*c)
        System.out.println(postfixToPrefix("ab+c*"));          // *+abc
        System.out.println(postfixToInfix("abc*+d-"));         // ((a+(b*c))-d)
    }
}
