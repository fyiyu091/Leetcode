package trie;

public class Entry {
    boolean[] prefix;
    int port;
    public Entry(boolean[] prefix, int port) {
        this.prefix = prefix;
        this.port = port;
    }
}
