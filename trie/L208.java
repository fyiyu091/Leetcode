package trie;

public class L208 {
    class TrieNode {
        private boolean isWord;
        private char ch;
        private TrieNode[] children;

        TrieNode(char ch) {
            this.isWord = false;
            this.children = new TrieNode[26];
            this.ch = ch;
        }
    }
    /** Initialize your data structure here. */
    private TrieNode root;
    public L208() {
        root = new TrieNode('\0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode(ch);
            }
            // If already exists, just go down the path
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            TrieNode next = curr.children[ch - 'a'];
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode next = curr.children[ch - 'a'];
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return true;
    }
}
