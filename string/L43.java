package string;

/* Multiply strings
   multiply two Strings contains only digits 0 - 9
   Has not leading zero, except the number 0 itself

      1 2 3
      4 5 6

      7 3 8
    6 1 5
  4 9 2

  5 6 0 8 8
 */
public class L43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int low = i + j + 1;
                int high = i + j;
                tmp += res[low];
                res[low] = tmp % 10;
                res[high] += tmp / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
