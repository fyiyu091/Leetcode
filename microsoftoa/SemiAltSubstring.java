package microsoftoa;

public class SemiAltSubstring {
    public static int semiAltSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() < 3) {
            return s.length();
        }

        int curr = 0;
        int end = 1;
        int maxLen = 2;
        int count = 1;
        char ch = s.charAt(0);

        while (end < s.length()) {
            if (s.charAt(end) == ch) {
                count++;
                if (count == 2) {
                    if (end - curr + 1 > maxLen) {
                        maxLen = end - curr + 1;
                    }
                }
                else {
                    curr = end - 1;
                }
            }
            else {
                ch = s.charAt(end);
                count = 1;
                if (end - curr + 1 > maxLen) {
                    maxLen = end - curr + 1;
                }
            }
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "baaabbabbb";
        String s2 = "babba";
        String s3 = "abaaaa";
        String s4 = "a";
        System.out.println(semiAltSubstring(s1));
        System.out.println(semiAltSubstring(s2));
        System.out.println(semiAltSubstring(s3));
        System.out.println(semiAltSubstring(s4));
    }

}
