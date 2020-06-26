package amazonoa;

import java.util.*;

public class SearchSuggestion {
    TrieNode root;

    class TrieNode {
        char ch;
        Map<Character, TrieNode> nexts;
        Set<String> prefixOf;
        TrieNode(char ch) {
            this.ch = ch;
            nexts = new HashMap<>();
            prefixOf = new HashSet<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        if (products == null || products.length == 0 || searchWord == null || searchWord.length() == 0) {
            return res;
        }

        Set<String> dict = new HashSet<>();
        root = new TrieNode(' ');
        for (String str : products) {
            if (str.length() != 0) {
                dict.add(str);
                buildTrie(str, root);
            }
        }
        res = search(searchWord, root);
        return res;
    }

    private void buildTrie(String str, TrieNode root) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            if (!curr.nexts.containsKey(ch)) {
                curr.nexts.put(ch, new TrieNode(ch));

            }
            curr = curr.nexts.get(ch);
            curr.prefixOf.add(str);
        }
        return;
    }

    private List<List<String>> search(String searchWord, TrieNode root) {
        List<List<String>> res = new ArrayList<>();
        TrieNode curr = root;
        for (char ch : searchWord.toCharArray()) {
            List<String> sol = new ArrayList<>();
            if (!curr.nexts.containsKey(ch)) {
                break;
            }
            curr = curr.nexts.get(ch);
            Queue<String> minHeap = new PriorityQueue<>();
            for (String pre : curr.prefixOf) {
                minHeap.offer(pre);
            }
            int k = 3;
            while (!minHeap.isEmpty() && k-- > 0) {
                sol.add(minHeap.poll());
            }
            res.add(sol);
        }
        while (res.size() != searchWord.length()) {
            res.add(new ArrayList<>());
        }
        return res;
    }
}
