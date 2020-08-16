package trie;

import java.util.ArrayList;
import java.util.List;

/*
    Return all concatenated words in the given list of words

    Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
    Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

    Build the trie and then search to check if the word can be added into the list
 */
public class L472 {
    class TrieNode {
        private char ch;
        private TrieNode[] next;
        private boolean isWord;
        TrieNode(char ch) {
            this.ch = ch;
            this.next = new TrieNode[26];
            this.isWord = false;
        }
    }

    TrieNode root = new TrieNode('\0');
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        for (String word : words) {
            insertWord(word);
        }

        // Now the trie is built, check each word in the words
        for (String word : words) {
            if (dfs(word, 0, 0)) {
                res.add(word);
            }
        }

        return res;
    }

    // Return whether [idx, word.length() - 1] is in the trie
    private boolean dfs(String word, int idx, int used) {
        if (idx == word.length()) {
            return used >= 2;
        }

        TrieNode curr = root;
        for (int i = idx; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.next[ch - 'a'] == null) {
                return false;
            }
            curr = curr.next[ch - 'a'];
            if (curr.isWord && dfs(word, i + 1, used + 1)) { // Just need one path to be true
                return true; // Can't put dfs(...) in here,
                             // because it only gives this level the very first chance, however, we just need one path not the first
            }
        }
        return false;
    }

    private void insertWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.next[ch - 'a'] == null) {
                curr.next[ch - 'a'] = new TrieNode(ch);
            }
            curr = curr.next[ch - 'a'];
        }
        curr.isWord = true;
    }
}
