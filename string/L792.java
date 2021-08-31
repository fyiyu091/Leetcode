package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Find how many word in words array is the subsequence of String s
    Maintain a hashMap the key is the starting character (26)
    The value is a list of word that has the key as the starting character

    For every character, scan the list, remove the very first one character, and move it to the next list that has
    the starting character


 */
public class L792 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        int res = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new ArrayList<>());
        }

        for (String word : words) {
            char startingChar = word.charAt(0);
            List<String> list = map.get(startingChar);
            list.add(word);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<String> wordList = map.get(ch);
            List<String> helperList = new ArrayList<>();
            for (String theWord : wordList) {
                helperList.add(theWord);
            }
            wordList.clear();
            for (int j = 0; j < helperList.size(); j++) {
                String word = helperList.get(j);
                if (word.length() == 1) {
                    res++;
                }
                else {
                    String nextStr = word.substring(1, word.length());
                    char nextChar = nextStr.charAt(0);
                    map.get(nextChar).add(nextStr);
                }
            }
        }

        return res;
    }
}
