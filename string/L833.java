package string;

/*
    Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
    Output: "eeebffff"
 */
public class L833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null || S.length() == 0) {
            return S;
        }

        int strLen = S.length();
        int strIdx = 0, indexIdx = 0;
        StringBuilder res = new StringBuilder();

        while (strIdx < strLen) {
            if (strIdx == indexes[indexIdx]) {
                int strTmp = strIdx;
                int sourceIdx = 0;
                String source = sources[indexIdx];
                while (strTmp < strLen && sourceIdx < source.length()) {
                    if (S.charAt(strTmp) == source.charAt(sourceIdx)) {
                        strTmp++;
                        sourceIdx++;
                    }
                    else {
                        break;
                    }
                }
                if (sourceIdx == source.length()) {
                    res.append(targets[indexIdx]);
                    strIdx = strTmp;
                    indexIdx++;
                }
                else {
                    res.append(S.charAt(strIdx));
                    strIdx++;
                }
            }
            else {
                res.append(S.charAt(strIdx));
                strIdx++;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        L833 test = new L833();
        String S = "abcd";
        int[] indexes = new int[] {0, 2};
        String[] sources = new String[] {"ab", "ec"};
        String[] targets = new String[] {"eee", "ffff"};
        System.out.println(test.findReplaceString(S, indexes, sources, targets));
    }
}
