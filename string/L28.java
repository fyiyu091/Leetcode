package string;

/* Implement strStr() */

public class L28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
