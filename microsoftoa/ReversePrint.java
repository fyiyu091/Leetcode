package microsoftoa;

/* if n is 1230, print 321 */
/* if n is 0, print 0 */

public class ReversePrint {
    public static void reversePrint(int n) {
        int enablePrint = n % 10;
        while (n > 0) {
            if (enablePrint == 0 && n / 10 != 0) {
                enablePrint = n / 10 % 10;
            }
            else {
                System.out.println(n % 10);
            }
            n /= 10;
        }
    }
}
