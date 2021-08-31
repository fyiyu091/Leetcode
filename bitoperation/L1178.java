package bitoperation;

import java.util.*;

/*
    Since each words in words and puzzles are within length of 7
    We use an 32-bit int to represent it
 */

public class L1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();

        // Create a map, key is the int representation of the word, value is the frequency
        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {
            int bitRep = 0;
            for (int i = 0; i < word.length(); i++) {
                bitRep |= 1 << (word.charAt(i) - 'a');
            }

            map.put(bitRep, map.getOrDefault(bitRep, 0) + 1);
        }

        // Going through puzzle and save the results to res
        for (String puzzle : puzzles) {
            int mask = 0;
            int count = 0;
            for (int i = 0; i < puzzle.length(); i++) {
                mask |= 1 << (puzzle.charAt(i) - 'a');
            }

            // Get the first bit
            int first = 0;
            first |= 1 << (puzzle.charAt(0) - 'a');

            // Going over all the subset of the mask
            int subset = mask;
            while (subset != 0) {
                if ((subset & first) == first && map.containsKey(subset)) {
                    count += map.get(subset);
                }
                subset = (subset - 1) & mask;
            }
            res.add(count);
        }

        return res;
    }

    /*
       1. word contains the first letter of puzzle
       2. each letter of word is in puzzle
    */
    private int getCountForWords(String puzzle, String[] words) {
        int res = 0;
        for (String word : words) {
            if (valid(word, puzzle)) {
                res++;
            }
        }
        return res;
    }

    private boolean valid(String word, String puzzle) {
        Set<Character> wordLetter = new HashSet<>();
        Set<Character> puzzleLetter = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            wordLetter.add(word.charAt(i));
        }
        for (int i = 0; i < puzzle.length(); i++) {
            puzzleLetter.add(puzzle.charAt(i));
        }

        if (!wordLetter.contains(puzzle.charAt(0))) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (!puzzleLetter.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
