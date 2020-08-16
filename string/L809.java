package string;

/*
    Expressive words
    hello can't become helloo, because hello has to become hellooo, with 3 or more o
    hello
             p
    helo
        p

    Two pointer
 */
public class L809 {
    public int expressiveWords(String S, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int res = 0;
        for (String word : words) {
            if (match(S, word)) {
                res++;
            }
        }

        return res;
    }

    private boolean match(String S, String word) {
        int sLength = S.length();
        int wordLength = word.length();

        int sP = 0;
        int wP = 0;
        while (sP < sLength && wP < wordLength) {
            char sChar = S.charAt(sP);
            char wChar = word.charAt(wP);
            if (sChar != wChar) {
                return false;
            }
            int c1 = 0, c2 = 0;
            while (sP < sLength && S.charAt(sP) == sChar) {
                sP++;
                c1++;
            }
            while (wP < wordLength && word.charAt(wP) == wChar) {
                wP++;
                c2++;
            }
            if (c1 < c2 || (c1 > c2 && c1 < 3)) { // count1 is like <= 2 and count2 is smaller than count1
                return false;
            }
        }

        return sP == sLength && wP == wordLength;
    }
}
