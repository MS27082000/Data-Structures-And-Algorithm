/** The 22 classic pattern-printing problems (n rows). Recipe for every one: outer loop = rows; inside, decide how many SPACES, then how many
 *  STARS/NUMBERS/LETTERS to print, as formulas of the row number i. All are O(n^2) time, O(1) space. */
public class Patterns {

    static void p1(int n) {            // solid square of stars
        for (int i = 0; i < n; i++) { for (int j = 0; j < n; j++) System.out.print("* "); System.out.println(); }
    }

    static void p2(int n) {            // right-angled triangle of stars
        for (int i = 1; i <= n; i++) { for (int j = 0; j < i; j++) System.out.print("* "); System.out.println(); }
    }

    static void p3(int n) {            // 1, 1 2, 1 2 3 ...
        for (int i = 1; i <= n; i++) { for (int j = 1; j <= i; j++) System.out.print(j + " "); System.out.println(); }
    }

    static void p4(int n) {            // row number repeated: 1, 2 2, 3 3 3 ...
        for (int i = 1; i <= n; i++) { for (int j = 0; j < i; j++) System.out.print(i + " "); System.out.println(); }
    }

    static void p5(int n) {            // inverted star triangle
        for (int i = n; i >= 1; i--) { for (int j = 0; j < i; j++) System.out.print("* "); System.out.println(); }
    }

    static void p6(int n) {            // inverted number triangle 1 2 3 4 5, 1 2 3 4 ...
        for (int i = n; i >= 1; i--) { for (int j = 1; j <= i; j++) System.out.print(j + " "); System.out.println(); }
    }

    static void p7(int n) {            // star pyramid: spaces n-i-1, then 2i+1 stars
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");
            for (int j = 0; j < 2 * i + 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    static void p8(int n) {            // inverted pyramid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) System.out.print(" ");
            for (int j = 0; j < 2 * (n - i) - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    static void p9(int n) {            // diamond = pyramid + inverted pyramid
        p7(n);
        p8(n);
    }

    static void p10(int n) {           // half diamond: widths 1..n..1
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i <= n ? i : 2 * n - i;
            for (int j = 0; j < stars; j++) System.out.print("* ");
            System.out.println();
        }
    }

    static void p11(int n) {           // binary triangle starting with 1, alternating 1 0 1 0
        for (int i = 0; i < n; i++) {
            int start = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) { System.out.print(start + " "); start = 1 - start; }
            System.out.println();
        }
    }

    static void p12(int n) {           // number crown: 1 ... 1 / 12 ... 21 / 123 ... 321 (spaces grow in the middle)
        int spaces = 2 * (n - 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j);
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = i; j >= 1; j--) System.out.print(j);
            System.out.println();
            spaces -= 2;
        }
    }

    static void p13(int n) {           // 1 / 2 3 / 4 5 6 ... (a running counter)
        int num = 1;
        for (int i = 1; i <= n; i++) { for (int j = 0; j < i; j++) System.out.print(num++ + " "); System.out.println(); }
    }

    static void p14(int n) {           // A / A B / A B C ...
        for (int i = 0; i < n; i++) { for (char c = 'A'; c <= 'A' + i; c++) System.out.print(c + " "); System.out.println(); }
    }

    static void p15(int n) {           // A B C D E / A B C D / ... / A
        for (int i = n; i >= 1; i--) { for (char c = 'A'; c < 'A' + i; c++) System.out.print(c + " "); System.out.println(); }
    }

    static void p16(int n) {           // A / B B / C C C ...
        for (int i = 0; i < n; i++) { for (int j = 0; j <= i; j++) System.out.print((char) ('A' + i) + " "); System.out.println(); }
    }

    static void p17(int n) {           // alphabet pyramid: A / ABA / ABCBA
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");
            char ch = 'A';
            int breakpoint = (2 * i + 1) / 2;
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(ch);
                if (j <= breakpoint) ch++; else ch--;
            }
            System.out.println();
        }
    }

    static void p18(int n) {           // E / D E / C D E ...
        for (int i = 0; i < n; i++) {
            for (char c = (char) ('A' + n - 1 - i); c <= 'A' + n - 1; c++) System.out.print(c + " ");
            System.out.println();
        }
    }

    static void p19(int n) {           // symmetric void: stars shrink while spaces grow, then mirror
        int spaces = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) System.out.print("*");
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < n - i; j++) System.out.print("*");
            System.out.println();
            spaces += 2;
        }
        spaces = 2 * n - 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) System.out.print("*");
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
            spaces -= 2;
        }
    }

    static void p20(int n) {           // symmetric butterfly
        int spaces = 2 * n - 2;
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i <= n ? i : 2 * n - i;
            for (int j = 0; j < stars; j++) System.out.print("*");
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < stars; j++) System.out.print("*");
            System.out.println();
            spaces += i < n ? -2 : 2;
        }
    }

    static void p21(int n) {           // hollow square: stars only on the border
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(i == 0 || j == 0 || i == n - 1 || j == n - 1 ? "* " : "  ");
            System.out.println();
        }
    }

    static void p22(int n) {           // concentric numbers: value at (i, j) = n - min(distance to any border)
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int d = Math.min(Math.min(i, j), Math.min(2 * n - 2 - i, 2 * n - 2 - j));
                System.out.print((n - d) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Runnable[] all = {() -> p1(3), () -> p2(4), () -> p3(4), () -> p4(4), () -> p5(4), () -> p6(4), () -> p7(4), () -> p8(4), () -> p9(3),
                () -> p10(3), () -> p11(4), () -> p12(3), () -> p13(4), () -> p14(4), () -> p15(4), () -> p16(4), () -> p17(4), () -> p18(4),
                () -> p19(3), () -> p20(3), () -> p21(4), () -> p22(3)};
        for (int i = 0; i < all.length; i++) {
            System.out.println("--- Pattern " + (i + 1));
            all[i].run();
        }
    }
}
