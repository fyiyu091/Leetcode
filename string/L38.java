package string;

/* Count and say
*  1211
*  111221
* */

public class L38 { //TODO, iteratively
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String ret = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < ret.length()) {
            char num = ret.charAt(i++);
            int count = 1;
            while (i < ret.length() && ret.charAt(i) == num) {
                count++;
                i++;
            }
            res.append(count);
            res.append(num);
        }

        return res.toString();
    }
}
