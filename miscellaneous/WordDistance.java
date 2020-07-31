package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                res = Math.min(res, Math.abs(list1.get(i) - list2.get(j)));
            }
        }

        return res;
    }
}
