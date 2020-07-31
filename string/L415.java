package string;

/*
     976
      55

     1301
 */
public class L415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int idx1 = len1 - 1;
        int idx2 = len2 - 1;
        while (idx1 >= 0 || idx2 >= 0) {
            int digit1 = idx1 >= 0 ? num1.charAt(idx1--) - '0' : 0;
            int digit2 = idx2 >= 0 ? num2.charAt(idx2--) - '0' : 0;
            int val = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            sb.append(val);
        }
        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
