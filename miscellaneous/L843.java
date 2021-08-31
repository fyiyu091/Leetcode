package miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    Guess the word
    Randomly pick up one and remove all the words that have the same match
 */
public class L843 {
    interface Master {
        public int guess(String word);
    }
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, matches = 0; i < 10 && matches < 6; i++) {
            Random rand = new Random();
            int nextGuess = rand.nextInt(wordlist.length);
            String pickedWord = wordlist[nextGuess];
            matches = master.guess(pickedWord);
            List<String> updatedWordList = new ArrayList<>();
            for (String word : wordlist) {
                if (getMatches(pickedWord, word) == matches) {
                    updatedWordList.add(word);
                }
            }
            wordlist = updatedWordList.toArray(new String[] {});
        }
    }

    private int getMatches(String w1, String w2) {
        int res = 0;
        for (int i = 0; i < 6; i++) {
            if (w1.charAt(i) == w2.charAt(i)) {
                res++;
            }
        }

        return res;
    }
}
