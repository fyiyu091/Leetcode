package string;

import java.util.ArrayList;
import java.util.List;

/*
    Function to start at a word and find the end word
    Function to pad the line
    Fill out the spaces until all the spaces were filled
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]
 */

public class L68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        int left = 0;
        while (left < words.length) {
            int right = findRight(words, maxWidth, left);
            String str = justify(words, maxWidth, left, right);
            res.add(str);
            left = right + 1;
        }

        return res;
    }

    // The function to find the right index with the starting index at left
    private int findRight(String[] words, int maxWidth, int left) {
        int right = left;
        int totalLength = words[right++].length();

        while (right < words.length && (totalLength + words[right].length() + 1) <= maxWidth) {
            totalLength += words[right++].length() + 1;
        }

        return right - 1;
    }

    /*
        How do we know if it's the last line?
        If right is at the end of the words, it means that we are at the last line
        How to add spaces?
        1. If it's the last line, must be left-justified
        2. If it's not the last line, just exhaust spaces between words
     */
    private String justify(String[] words, int maxWidth, int left, int right) {
        // If we can only fit one word
        boolean isLastLine = false;
        if (left == right) {
            return padStr(words[left], maxWidth);
        }

        if (right == words.length - 1) {
            isLastLine = true;
        }

        // numberBetweenWords can't be the denominator
        int numberBetweenWords = right - left;
        int numberOfSpaces = maxWidth - getLength(words, left, right);
        String baseSpace = isLastLine ? " " : blank(numberOfSpaces / numberBetweenWords);
        int remainderSpaces = isLastLine ? 0 : numberOfSpaces % numberBetweenWords;

        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i]).append(baseSpace).append(remainderSpaces-- > 0 ? " " : "");

        }
        return padStr(sb.toString().trim(), maxWidth);
    }

    private int getLength(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += words[i].length();
        }
        return res;
    }

    private String padStr(String str, int maxWidth) {
        return str + blank(maxWidth - str.length());
    }

    // Generate spaces String
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}
