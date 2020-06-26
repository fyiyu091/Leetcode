package string;

/* Shortest palindrome
   adding char in front of it
   find the shortest palindrome
 */
public class L214 { //TODO: optimal solution will be KMP
    public String shortestPalindrome(String s) { // Find the longest palindrome starting at 0 position, reverse the rest and append in front
        if (s == null || s.length() == 0) {
            return null;
        }

        int i = 0;
        int j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                i = 0;
                end--;
                j = end;
            }
        }

        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
