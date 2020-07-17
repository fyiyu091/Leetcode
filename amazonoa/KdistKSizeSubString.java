package amazonoa;

import java.util.ArrayList;
import java.util.List;

/*
   Find all size is K and K distinct characters
   fix size window, use a variable to keep track of duplicates
   once the duplicate is 0, then the curr window is good to add into res

   a b c d
   s
           e
 */
public class KdistKSizeSubString {
    public static List<String> subStringKDist(String inputStr, int num) {
        List<String> res = new ArrayList<>();
        if (inputStr == null || inputStr.length() == 0 || num > inputStr.length()) {
            return res;
        }

        int[] cnt = new int[26];
        int start = 0;
        int dup = 0;
        int end = 0;
        int len = inputStr.length();
        while (end < len) {
            if (end < num) {
                if (cnt[inputStr.charAt(end) - 'a'] >= 1) {
                    dup++;
                }
                cnt[inputStr.charAt(end++) - 'a']++;
                if (end == num && dup == 1) { // the window is [start, end)
                    res.add(inputStr.substring(start, end));
                }
                continue;
            }

            if (cnt[inputStr.charAt(start) - 'a'] > 1) {
                dup--;
            }
            cnt[inputStr.charAt(start++) - 'a']--;
            if (cnt[inputStr.charAt(end) - 'a'] >= 1) {
                dup++;
            }
            cnt[inputStr.charAt(end++) - 'a']++;
            if (dup == 1) {
                res.add(inputStr.substring(start, end)); // when end == len, we check [start, end)
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String input = "awaglk";
        int num = 4;
        List<String> res = subStringKDist(input, num);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
