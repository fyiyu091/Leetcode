package tree;

import java.util.ArrayList;
import java.util.List;

/* Different ways to add parentheses
   2-1-1, ((2-1)-1), (2-(1-1))
 */
public class L241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }
        boolean isNum = true;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                isNum = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                res.addAll(combine(left, right, ch));
            }
        }

        if (isNum) {
            res.add(Integer.valueOf(input));
        }

        return res;
    }

    private List<Integer> combine(List<Integer> left, List<Integer> right, char ch) {
        List<Integer> res = new ArrayList<>();
        for (int i : left) {
            for (int j : right) {
                if (ch == '+') {
                    res.add(i + j);
                }
                else if (ch == '-') {
                    res.add(i - j);
                }
                else {
                    res.add(i * j);
                }
            }
        }
        return res;
    }
}
