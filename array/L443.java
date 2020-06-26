package array;

/* String compression */
public class L443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int i = 0;
        int idx = 0;
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            chars[idx++] = chars[i];
            if (j - i > 1) {
                String str = String.valueOf((j - i));
                for (char ch : str.toCharArray()) {
                    chars[idx++] = ch;
                }
            }
            i = j;
        }
        return idx;
    }
}
