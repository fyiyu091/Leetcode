package string;

/* Count how many palindromic substrings in the string
   substring two pointer expand solution
   Same method as the longest substring
   But add res along the way
*/

public class L647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res += expandAndCount(s, i, i);
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                res += expandAndCount(s, i, i + 1);
            }
        }

        return res;
    }

    private int expandAndCount(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
        return res;
    }
}
