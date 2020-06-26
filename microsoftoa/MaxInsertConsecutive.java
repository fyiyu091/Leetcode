package microsoftoa;

/*
  Max inserts to obtain string without 3 consecutive 'a'
 */
public class MaxInsertConsecutive {
    public static int maxInsert(String s) {
        if (s == null || s.length() == 0) {
            return 2;
        }

        int res = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                count++;
                if (count == 3) {
                    return -1;
                }
            }
            else {
                res += 2 - count;
                count = 0;
            }
        }
        if (s.charAt(s.length() - 1) != 'a') {
            res += 2;
        }
        else {
            res += 2 - count;
        }
        return res;
    }
}
