package pruning;

/* Regular expression matching, '.' matches any single character, '*' matches zero or more of the preceding element */

public class L10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        Boolean[][] mem = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, 0, p, 0, mem);
    }

    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] mem) {
        if (mem[idxS][idxP] != null) {
            return mem[idxS][idxP];
        }

        if (idxP == p.length()) {
            return idxS == s.length();
        }

        if (idxP + 1 == p.length() || p.charAt(idxP + 1) != '*') {
            if (idxS < s.length() && isMatch(s, idxS, p, idxP)) {
                mem[idxS][idxP] = dfs(s, idxS + 1, p, idxP + 1, mem);
                return mem[idxS][idxP];
            }
            else {
                mem[idxS][idxP] = false;
                return false;
            }
        }
        else {
            int i = idxS - 1;
            while (i < s.length() && (i < idxS || isMatch(s, i, p, idxP))) {
                if (dfs(s, i + 1, p, idxP + 2, mem)) {
                    mem[idxS][idxP] = true;
                    return true;
                }
                i++;
            }
            mem[idxS][idxP] = false;
            return false;
        }
    }

    private boolean isMatch(String s, int idxS, String p, int idxP) {
        return p.charAt(idxP) == '.' || s.charAt(idxS) == p.charAt(idxP);
    }
}
