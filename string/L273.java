package string;

/* Integer to English words
   10,001,000
   Ten million one Thousand
   10,001,000 % 1000 = 0
   10,001,000 / 1000 = 10,001
   10,001 % 1000 = 1
   10,001 / 1000 = 10
*/

public class L273 {
    private static final String[] TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] LARGE = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String res = "";
        int i = 0;
        while (num != 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + LARGE[i] + " " + res;
            }
            num /= 1000;
            i++;
        }

        return res.trim();
    }

    /*
        986
        nine hundred helper(86)
        nine hundred eighty (6)
        nine hundred eighty six
     */
    private String helper(int num) {
        if (num == 0) {
            return "";
        }
        else if (num < 20) {
            return TEN[num] + " ";
        }
        else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10) ;
        }
        else {
            return TEN[num / 100] + " Hundred " + helper(num % 100) ;
        }
    }
}
