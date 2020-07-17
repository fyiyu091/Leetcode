package array;

/* Integer to English words
   No and
 */
public class L273 {
    private static final String[] TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] LARGE = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        String res = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                res = convert(num % 1000) + LARGE[i] + " " + res;
            }
            num /= 1000;
            i++;
        }

        return res.trim();
    }

    // For numbers that are below 1000
    private String convert(int n) {
        if (n == 0) {
            return "";
        }

        if (n < 20) {
            return TEN[n] + " ";
        }

        if (n < 100) {
            return TENS[n / 10] + " " + convert(n % 10);
        }

        return TEN[n / 100] + " Hundred" + " " + convert(n % 100);
    }
}
