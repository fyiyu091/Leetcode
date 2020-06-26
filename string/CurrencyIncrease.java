package string;

/* X borrowed $40.0 percentage from Y $10.0
*  increase 20 percent
*  X borrowed $48.0 percentage from Y $12.0
* */

public class CurrencyIncrease {
    public String currencyIncrease(String str, int percentage) {
        if (str == null || str.length() == 0) {
            return null;
        }

        int i = 0;
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            char ch = str.charAt(i);
            if (ch == '$') {
                sb.append(ch);
                i++;
                StringBuilder tmp = new StringBuilder();
                while (i < len && (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                    tmp.append(str.charAt(i++));
                }
                Double num = Double.valueOf(tmp.toString());
                Double increase = num * (percentage / 100.0);
                num += increase;
                sb.append(num);
            }
            else {
                sb.append(ch);
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CurrencyIncrease test = new CurrencyIncrease();
        String input = "X borrowed $40 percentage from Y $10";
        System.out.println(test.currencyIncrease(input, 20));
    }
}
