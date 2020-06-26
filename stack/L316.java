package stack;

public class L316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int[] count = new int[26];
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (used[ch - 'a']) {
                count[ch - 'a']--;
                continue;
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch &&
                    count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            count[ch - 'a']--;
            used[ch - 'a'] = true;
        }

        return sb.toString();
    }
}
