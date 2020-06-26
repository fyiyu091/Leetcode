package pruning;

/* Wildcard matching, '?' matches any single character, '*' matches any sequence of characters */

public class L44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int lenS = s.length();
        int lenP = p.length();
        Boolean[][] mem = new Boolean[lenS + 1][lenP + 1];
        return dfs(s, 0, p, 0, mem);
    }

    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] mem) {
        if (mem[idxS][idxP] != null) {
            return mem[idxS][idxP];
        }
        if (idxP == p.length()) {
            return idxS == s.length();
        }

        if (p.charAt(idxP) != '*') {
            if (idxS < s.length() && (s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '?')) {
                return dfs(s, idxS + 1, p, idxP + 1, mem);
            }
            mem[idxS][idxP] = false;
            return mem[idxS][idxP];
        }
        else {
            int i = idxS - 1;
            while (i < s.length()) {
                if (dfs(s, i + 1, p, idxP + 1, mem)) {
                    mem[idxS][idxP] = true;
                    return mem[idxS][idxP];
                }
                i++;
            }
            mem[idxS][idxP] = false;
            return mem[idxS][idxP];
        }
    }
}
