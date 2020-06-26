package math;

/* Fraction to recurring decimal
*  input 2, 3
*  output 0.(6)
*  4 / 333 -> 0.012012012... -> 0.(012)
*
*  Divide get the quotient and remainder
*  if remainder is not 0, adding '.' into the sb
*  Adding zero to denominator if denominator is smaller than numerator
*  need to save the reminder to a HashSet, when seeing it again just adding parentheses
*         0.(012)
*   333   4
*         4 00
*         3 33
*           670
*           666
*             4
* */

import java.util.HashMap;
import java.util.Map;

public class L166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append('-');
        }
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator); // Why need long, because abs(Integer.MIN_VALUE) will still be negative
        long quotient = num / denom;
        long remainder = num % denom;
        sb.append(quotient);
        // Need store from remainder to index in StringBuilder
        Map<Long, Integer> map = new HashMap<>();
        if (remainder != 0) {
            sb.append('.');
        }
        while (remainder != 0) {
            // Store the seen quotient before
            if (!map.containsKey(remainder)) {
                map.put(remainder, sb.length());
                remainder *= 10;
                sb.append(remainder / denom);
                remainder = remainder % denom;
            }
            else { // Insert parentheses into the StringBuilder then break
                sb.append(')');
                sb.insert((int) map.get(remainder), '(');
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num1 = 6;
        int num2 = 4;
        int num3 = -6;
        int num4 = -4;
        System.out.println(num1 % num2); // 6 % 4    2   4 * 1 + 2
        System.out.println(num1 % num4); // 6 % -4   2  -4 * -1 + 2
        System.out.println((-6) % 4); // -6 % 4  -2   4 * -1 - 2
        System.out.println(num3 % num4); // -6 % -4 -2  -4 * 1 - 2
        System.out.println(num2 % num1); // 4 % 6    4   6 * 0 + 4
        System.out.println(num4 % num1); // -4 % 6  -4   6 * 0 - 4
        System.out.println(num2 % num3); // 4 % -6   4  -6 * 0 + 4
        System.out.println(num4 % num3); // -4 % -6  4  -6 * 0 - 4

        // Convert to absolute value
    }
}
