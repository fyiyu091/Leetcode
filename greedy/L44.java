package greedy;

/*
   ? matches any single character
   * matches any sequence of character (including the empty sequence)
   Why we can use greedy in this case?
   Local optimal can leads to global optimal solution
   When seeing a '*', try to match as much as possible
   a b c d f b c d e h
       i
       t
   a * b c d e h
       j
       s

   initially, we thought * matches empty
   however, in reality, * matches b c d f

   a a a a
       i
   t
   * * * a
         j
         p
 */
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
                afterStart = ++idxP; // afterStart to skip '*' and find the next char
                tmpS = idxS; // can't increment idxS yet, because every char in s has to be matched
            }
            else if (afterStart != -1) { // meaning that we seeing the '*' before
                idxP = afterStart;       // Rewind back the indP
                idxS = ++tmpS;           // Use * to consume one char in string
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
