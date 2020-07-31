package string;

/* Reverse words in a String */

public class L151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        // \\s+ match one or more whitespace
        String[] strs = s.trim().split("\\s+");
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            String tmp = strs[left];
            strs[left] = strs[right];
            strs[right] = tmp;
            left++;
            right--;
        }
        return String.join(" ", strs);
    }
}
