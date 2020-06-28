package dfs;

/* Zuma game
   Row of balls, red(R), yellow(Y), blue(B), green(G) and white(W)
   Find the minimal balls you have to insert to remove all the balls
   Search status board status, hand status
 */

import java.util.HashMap;
import java.util.Map;

public class L488 {
    public int findMinStep(String board, String hand) {
        if (board == null || hand == null) {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> myHand = new HashMap<>();
        for (char ch : hand.toCharArray()) {
            myHand.put(ch, myHand.getOrDefault(ch, 0) + 1);
        }

        int res = dfs(board, myHand);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(String board, Map<Character, Integer> myHand) {
        if (board.length() == 0) {
            return 0;
        }
        if (myHand.size() == 0) {
            return Integer.MAX_VALUE;
        }

        Integer min = Integer.MAX_VALUE;
        // What does visited mean?
        for (int i = 0; i < board.length(); i++) {
            char ch = board.charAt(i);
            // If we have two adjacent, we want to eliminate two
            if (i + 1 < board.length() && board.charAt(i + 1) == ch) {
                Integer cnt = myHand.get(ch);
                if (myHand.get(ch) != null) {
                    int newCnt = cnt - 1;
                    String newBoard = getNewBoard(board, i - 1, i + 2);
                    if (newCnt == 0) {
                        myHand.remove(ch);
                    }
                    else {
                        myHand.put(ch, newCnt);
                    }
                    int ret = dfs(newBoard, myHand);
                    min = Math.min(min, ret == Integer.MAX_VALUE ? min : ret + 1);
                    myHand.put(ch, cnt);
                }
            }
            else {
                Integer cnt = myHand.get(ch);
                if (myHand.get(ch) != null && myHand.get(ch) >= 2) {
                    int newCnt = cnt - 2;
                    String newBoard = getNewBoard(board, i - 1, i + 1);
                    if (newCnt == 0) {
                        myHand.remove(ch);
                    }
                    else {
                        myHand.put(ch, newCnt);
                    }
                    int ret = dfs(newBoard, myHand);
                    min = Math.min(min, ret == Integer.MAX_VALUE ? min : ret + 2);
                    myHand.put(ch, cnt);
                }
            }
        }
        return min;
    }

    /*    WWRRBBWW
           i
              j
          Only possible way is eliminate by adding left and right
     */
    private String getNewBoard(String board, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < board.length()) {
            char ch = board.charAt(left);
            int l = left;
            while (l >= 0 && board.charAt(l) == ch) {
                cnt++;
                l--;
            }
            int r = right;
            while (r < board.length() && board.charAt(r) == ch) {
                cnt++;
                r++;
            }
            if (cnt < 3) {
                break;
            }
            else {
                left = l;
                right = r;
                cnt = 0;
            }
        }

        return board.substring(0, left + 1) + board.substring(right);
    }
}
