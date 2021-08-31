package string;

/* Remove comments */

import java.util.ArrayList;
import java.util.List;

public class L722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) {
            return res;
        }

        boolean blockComment = false;
        StringBuilder sb = new StringBuilder();

        for (String line : source) {
            int i = 0;
            while (i < line.length()) {
                if (blockComment) {
                    while (i + 1 < line.length() && !(line.charAt(i) == '*' && line.charAt(i + 1) == '/')) {
                        i++;
                    }
                    // i either stops at the last idx or at '*'
                    if (i + 1 < line.length()) {
                        blockComment = false;
                    }
                    i += 2;
                }
                else if (i + 1 < line.length() && (line.charAt(i) == '/' && line.charAt(i + 1) == '/')) {
                    break;
                }
                else if (i + 1 < line.length() && (line.charAt(i) == '/' && line.charAt(i + 1) == '*')) {
                    blockComment = true;
                    i += 2;
                }
                else {
                    sb.append(line.charAt(i++));
                }
            }

            if (sb.length() > 0 && !blockComment) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;
    }
}
