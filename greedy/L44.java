package greedy;

public class L44 {
    public boolean isMatch(String s, String p) {
        // corner case
        if (s == null || p == null) {
            return false;
        }
        int lenS = s.length();
        int lenP = p.length();
        int idxS = 0;
        int idxP = 0;
        int afterStart = -1;
        int tmpS = 0;
        while (idxS < lenS) {
            if (idxP < lenP && (p.charAt(idxP) == '?' || s.charAt(idxS) == p.charAt(idxP))) {
                idxP++;
                idxS++;
            }
            else if (idxP < lenP && p.charAt(idxP) == '*') {
                afterStart = ++idxP;
                tmpS = idxS;
            }
            else if (afterStart != -1) {
                idxP = afterStart;
                idxS = ++tmpS;
            }
            else {
                return false;
            }
        }

        while (idxP < lenP && p.charAt(idxP) == '*') {
            idxP++;
        }
        return idxP == lenP;
    }
}
