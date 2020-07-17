package bfs;

/* Letter combinations of a phone number
*  Input: "23"
*  a b c
*  b c ad ae af
*  c ad ae af bd be bf
*  ad ae af bd be bf cd ce cf
* */

import java.util.*;

public class L17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Integer, List<Character>> map = new HashMap<>();

        char start = 'a';
        for (int i = 2; i <= 9; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }
            if (i == 7 || i == 9) {
                for (int j = 0; j < 4; j++) {
                    map.get(i).add(start++);
                }
            }
            else {
                for (int j = 0; j < 3; j++) {
                    map.get(i).add(start++);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        int firstDigit = Character.getNumericValue(digits.charAt(0));
        for (char ch : map.get(firstDigit)) {
            queue.offer(ch + "");
        }

        for (int i = 1; i < digits.length(); i++) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                int currDigit = Character.getNumericValue(digits.charAt(i));
                for (char ch : map.get(currDigit)) {
                    queue.offer(curr + ch);
                }
            }
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }
}
