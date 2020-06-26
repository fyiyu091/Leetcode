package trie;

public class WordDictionary {
    class TrieNode {
        char ch;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char ch) {
            this.children = new TrieNode[256];
            this.isWord = false;
            this.ch = ch;
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('\0');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch] == null) {
                curr.children[ch] = new TrieNode(ch);
            }
            curr = curr.children[ch];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode root, String word, int idx) {
        if (idx == word.length() && root.isWord) {
            return true;
        }

        if (root == null || idx == word.length()) {
            return false;
        }

        char ch = word.charAt(idx);
        if (ch >= 'a' && ch <= 'z') {
            TrieNode curr = root.children[ch];
            if (curr == null) {
                return false;
            }
            return dfs(curr, word, idx + 1);
        }
        else if (ch == '.') {
            for (TrieNode curr : root.children) {
                if (curr != null) {
                    if (dfs(curr, word, idx + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
