package miscellaneous;

public class PrintDiamond {
    public static void printDiamond(int n) {
        int space = n - 1;
        for (int i = 0; i < n; i++) { // n rows
            for (int j = 0; j < space; j++) { // in the first row, print n - 1 space
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) { // in the first row, print 1 *
                System.out.print("* ");
            }
            System.out.print("\n");
            space--;
        }
        space = 0;
        for (int i = n; i > 0; i--) { // n rows again
            for (int j = 0; j < space; j++) { // in the first row, print no space
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) { // in the first row, print n *
                System.out.print("* ");
            }
            System.out.print("\n");
            space++;
        }
    }
    public static void main(String[] args) {
        printDiamond(5);
    }
}
