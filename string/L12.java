package string;

/* Integer to roman */

public class L12 {
    public String intToRoman(int num) {
        String[] name = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            while (num >= val[i]) {
                sb.append(name[i]);
                num -= val[i];
            }
            i++;
        }
        return sb.toString();
    }
}
