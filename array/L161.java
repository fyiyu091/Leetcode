package array;

/* If they are both one edit distance apart */

public class L161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int lenS = s.length();
        int lenT = t.length();
        int idxS = 0;
        int idxT = 0;
        int count = 0;

        while (idxS < lenS && idxT < lenT) {
            if (s.charAt(idxS) != t.charAt(idxT)) {
                if (lenS == lenT) {
                    idxS++;
                    idxT++;
                }
                else if (lenS < lenT) {
                    idxT++;
                }
                else {
                    idxS++;
                }
                count++;
            }
            else {
                idxS++;
                idxT++;
            }
        }

        while (idxS < lenS) {
            idxS++;
            count++;
        }
        while (idxT < lenT) {
            idxT++;
            count++;
        }

        return count == 1;
    }
}
