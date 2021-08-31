package string;

import java.util.HashMap;
import java.util.Map;

/*
    Find how many sentences can fill up the screen
    a,bcd,e if 5 -> 5 % 3 -> 2 which is e, what is 5

    a-bcd-
    e-a---
    bcd-e-

    The brute force is ok, but we can use a hashmap to store the starting and how many words can fill the row
 */
public class L418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // corner case
        if (sentence == null || sentence.length == 0) {
            return 0;
        }
        // Key is with current index word start, how many words we can have stored
        Map<Integer, Integer> map = new HashMap<>();
        // Variables to store how many words we got put on screen
        // Count is how many words we have fit into the screen
        // Key is if we starting this word as the first word in the screen, how many can we fit for the line
        int count = 0;
        int len = sentence.length;
        for (int i = 0; i < rows; i++) {
            if (map.containsKey(count % len)) {
                count += map.get(count % len);
                continue;
            }
            else {
                int wordsCnt = 0;
                int remaind = cols;
                int idx = count % len;
                while (remaind > 0) {
                    if (sentence[count % len].length() <= remaind) {
                        // If not adding 1, we might have no space between two words case
                        remaind -= (sentence[count % len].length() + 1);
                        count++;
                        wordsCnt++;
                    }
                    else {
                        break;
                    }
                }
                map.put(idx, wordsCnt);
            }
        }

        return count / len;
    }
}
