package string;

import java.util.ArrayList;
import java.util.List;

/* Encode list of strings to a string
   Decode the string back to list of strings
   Can use , to separate String.
   How to encode a single String?
   Use a fixed size String preceded to representing the length
 */
public class L271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(addingLen(str));
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        List<String> res = new ArrayList<>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            int strLen = Integer.valueOf(s.substring(i, i + 4));
            i += 4;
            String nextStr = s.substring(i, i + strLen);
            res.add(nextStr);
            i += strLen;
        }

        return res;
    }

    private static String addingLen(String str) {
        int len = str.length();
        String strLen = String.valueOf(len);
        StringBuilder sb = new StringBuilder(strLen);
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        return sb.append(str).toString();
    }
}
