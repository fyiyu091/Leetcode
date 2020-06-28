package dfs;

/* Generalized abbreviation, word to 1ord, 2rd, w1r1 ... */

import java.util.ArrayList;
import java.util.List;

public class L320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String word, int index, int count) {
        if (index == word.length()) {
            int originLen = sb.length();
            if (count != 0) {
                sb.append(count);
            }
            res.add(sb.toString());
            sb.setLength(originLen);
            return;
        }

        int originLen = sb.length();
        // Unless we append all the count, we can't append any char
        if (count != 0) {
            sb.append(count);
        }
        sb.append(word.charAt(index));
        dfs(res, sb, word, index + 1, 0);
        sb.setLength(originLen);

        dfs(res, sb, word, index + 1, count + 1);
        return;
    }
}
