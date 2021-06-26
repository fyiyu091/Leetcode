package array;

public class L186 {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int len = s.length;
        // reverse the entire char array
        reverse(s, 0, len - 1);
        // reverse each word
        int i = 0;
        int j = 0;
        while (i < len) {
            i = j;
            while (i < len && s[i] == ' ') i++;
            j = i;
            while (j < len && s[j] != ' ') j++;
            reverse(s, i, j - 1);
        }
        return;
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        return;
    }
}
