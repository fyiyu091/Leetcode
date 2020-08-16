package string;

/*
    Reorganize string so that adjacent to each other are not the same, otherwise return ""
    aab -> aba
 */
public class L767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        int[] count = new int[26];
        int max = 0;
        char maxChar = 'a';
        for (char ch : S.toCharArray()) {
            count[ch - 'a']++;
            if (count[ch - 'a'] > max) {
                max = count[ch - 'a'];
                maxChar = ch;
            }
            if (max > (S.length() + 1) / 2) {
                return "";
            }
        }

        char[] res = new char[S.length()];
        int i = 0;
        while (max-- > 0) { //Fill the maxChar first
            res[i] = maxChar;
            i += 2;
            count[maxChar - 'a']--;
        }

        for (int k = 0; k < 26; k++) {
            while (count[k] > 0) {
                if (i >= S.length()) {
                    i = 1;
                }
                res[i] = (char) (k + 'a');
                i += 2;
                count[k]--;
            }
        }

        return String.valueOf(res);
    }
}
