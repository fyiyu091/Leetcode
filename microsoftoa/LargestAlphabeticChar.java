package microsoftoa;

public class LargestAlphabeticChar {
    public static String largestChar(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            }
            if (Character.isUpperCase(ch)) {
                upper[ch - 'A'] = true;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (upper[i] && lower[i]) {
                return Character.toString((i + 'A'));
            }
        }
        return "NO";
    }
}
