package array;

/* Count and say
   1 -> one 1
   11 -> two 1
   21 -> one 2 one 1
   1211 -> one 1 one 2 two 1
   111221 -> three 1 two 2 one 1
   312211 -> ...
 */
public class L38 {
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
