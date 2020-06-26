package trie;

import java.util.*;

public class AutocompleteSystem {
    class TrieNode {
        char ch;
        Map<String, Integer> count;
        Map<Character, TrieNode> neis;
        TrieNode(char ch) {
            this.ch = ch;
            count = new HashMap<>();
            neis = new HashMap<>();
        }
    }

    TrieNode root;
    String curr;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode('\0');
        for (int i = 0; i < sentences.length; i++) {
            addCount(root, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addCount(root, curr, 1);
            // Have to initialize curr String
            curr = "";
            return new ArrayList<>();
        }
        else {
            TrieNode node = root;
            curr += c;
            for (char ch : curr.toCharArray()) {
                if (!node.neis.containsKey(ch)) {
                    return new ArrayList<>();
                }
                node = node.neis.get(ch);
            }
            return getTopThree(node);
        }
    }

    private void addCount(TrieNode root, String str, int count) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            if (!curr.neis.containsKey(ch)) {
                curr.neis.put(ch, new TrieNode(ch));
            }
            curr = curr.neis.get(ch);
            curr.count.put(str, curr.count.getOrDefault(str, 0) + count);
        }
    }

    private List<String> getTopThree(TrieNode node) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = node.count;
        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o2.compareTo(o1);
                }
                else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });

        for (String str : map.keySet()) {
            minHeap.offer(str);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            // The last one will be the max, put it at index 0
            res.add(0, minHeap.poll());
        }

        return res;
    }
}
