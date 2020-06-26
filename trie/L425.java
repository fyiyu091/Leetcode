package trie;

import java.util.ArrayList;
import java.util.List;

/* Word squares
   b a l l
   a r e a
   l e a d
   l a d y

   m[0][2] = m[2][0]
   m[x][y] = m[y][x] ? This is correct!

   row by row pick word, how to pick the next word?

 */

public class L425 {
    class TrieNode {
        private char ch;
        private TrieNode[] children;
        private List<String> prefixOf;
        TrieNode(char ch, String str) {
            this.ch = ch;
            this.children = new TrieNode[256];
            this.prefixOf = new ArrayList<>();
            this.prefixOf.add(str);
        }
    }

    class PrefixTrie {
        private TrieNode root;

        PrefixTrie(String[] strs) {
            this.root = new TrieNode('\0', null);
            for (String str : strs) {
                insert(str);
            }
        }

        private void insert(String str) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                if (curr.children[ch] == null) {
                    curr.children[ch] = new TrieNode(ch, str);
                }
                else {
                    curr.children[ch].prefixOf.add(str);
                }
                curr = curr.children[ch];
            }
        }

        private List<String> getPrefixOf(String str) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                if (curr.children[ch] == null) {
                    return new ArrayList<>();
                }
                else {
                    curr = curr.children[ch];
                }
            }
            return curr.prefixOf;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        PrefixTrie trie = new PrefixTrie(words);
        List<String> sol = new ArrayList<>();
        for (String str : words) {
            sol.add(str);
            dfs(res, sol, str, trie);
            sol.remove(sol.size() - 1);
        }

        return res;
    }

    private void dfs(List<List<String>> res, List<String> sol, String firstWord, PrefixTrie trie) {
        if (sol.size() == firstWord.length()) {
            res.add(new ArrayList<>(sol));
            return;
        }

        int position = sol.size();
        StringBuilder prefix = new StringBuilder();
        for (String str : sol) {
            prefix.append(str.charAt(position));
        }
        List<String> candidates = trie.getPrefixOf(prefix.toString());
        for (String str : candidates) {
            sol.add(str);
            dfs(res, sol, firstWord, trie);
            sol.remove(sol.size() - 1);
        }
    }
}
